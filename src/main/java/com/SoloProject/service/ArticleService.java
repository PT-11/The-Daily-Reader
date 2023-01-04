package com.SoloProject.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.SoloProject.model.Article;
import com.SoloProject.repository.ArticleRepository;

@Service
public class ArticleService {

	ArticleRepository articleRepo;
	

	private static final String APIKEY = System.getenv("TheNewsApiKey");
	
	public ArticleService() {
		super();
	}
	
	//Use this method to search with specific terms
	public List<Article> getSearchResults(String searchSubject, HttpSession session, boolean before) { 
		
		LocalDate currentDate = java.time.LocalDate.now();
		String searchFrom = currentDate.minusWeeks(1).toString();
		String urlString = null;
		System.out.println("SearchFrom variable is: " + searchFrom);
		
		if (before) {
			urlString = "https://api.thenewsapi.com/v1/news/top?api_token=" 
					+ APIKEY
					+ "&search=" + searchSubject
					+ "&language=en"
					+ "&published_after=" + searchFrom;
		}
		else if (!before) {
			urlString = "https://api.thenewsapi.com/v1/news/top?api_token=" 
					+ APIKEY
					+ "&search=" + searchSubject
					+ "&language=en"
					+ "&published_before=" + searchFrom;
		}

		
		return callNewsApi(urlString, false);
	}

	//Use this method to search with categories determined by the API
	public List<Article> getNewApi(String category, HttpSession session, boolean secondList, boolean limitToThree) {
	
		LocalDate currentDate = java.time.LocalDate.now();
		String date = null;
		
		if (secondList) {
			date = currentDate.minusWeeks(1).toString();
		} 
		else if (!secondList) {
			date = currentDate.minusDays(2).toString();
		}
			
		if (category == null) {
			category = "general";
		}
		
		String urlString = "https://api.thenewsapi.com/v1/news/top?api_token=" 
				+ APIKEY
				+ "&categories=" + category
				+ "&language=en"
				+ "&published_before=" + date;
		
		return callNewsApi(urlString, limitToThree);
	}
	
	//List to find the latest new articles for a particular category
	public List<Article> getLatestCategory(String category, HttpSession session, boolean limitedToThree) {
		
		if (category == null) {
			category = "sports";
		}
		
		String urlString = "https://api.thenewsapi.com/v1/news/top?api_token=" 
				+ APIKEY
				+ "&categories=" + category
				+ "&language=en";
		
		return callNewsApi(urlString, limitedToThree);
	}

	private List<Article> callNewsApi(String urlString, boolean limitedToThree) {
	
		StringBuilder responseContent =  null;
		
		List<Article> returnedArticles = null;
		
		BufferedReader reader = null;
		String line = null;
		HttpURLConnection connection = null;
		
		try {
			URL url = new URL(urlString);
			
						
			 connection = (HttpURLConnection) url.openConnection();
			
			//Request setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(7000);
			connection.setReadTimeout(7000);
			
			int status = connection.getResponseCode();
			
			responseContent = new StringBuilder();
			
		
			
			if (status > 200) {
				System.out.println("Status is > 200");
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				
			}
			System.out.println("Response for url: " + urlString + " is " + responseContent);
			returnedArticles = parse(responseContent.toString(), limitedToThree);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(connection != null){
			   connection.disconnect();
			}
			
			if(reader != null){
				try
				{
				reader.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
					ex.printStackTrace();
					
				}
			}
		
		}
		
		return returnedArticles;
	}

	private List<Article> parse(String responseBody, boolean limitToThree) {
		
		List<Article> articleList = new ArrayList<Article>(5);
		
	
		String title;
		String articleURL;
		String urlToImage;
		String desc = "";
		
		String responseUpdated = responseBody.substring(responseBody.indexOf("["));
		responseUpdated.trim();

		JSONArray articles = new JSONArray(responseUpdated);
		int size = articles.length();
		
		if (limitToThree) {
			size = 3;
		}
		
		for (int i = 0; i < size; i++) {
			JSONObject article = articles.getJSONObject(i);
			
			if (article.isNull("title") || article.getString("title").trim().isEmpty()) {
				title = "No title available";
			}
			else {
				title = article.getString("title");
			}
	
			if (article.isNull("url") || article.getString("url").trim().isEmpty()) {
				articleURL = "No link available";
			}
			else {
				articleURL = article.getString("url");
			}
			
			if (article.isNull("image_url") || article.getString("image_url").trim().isEmpty() || article.getString("image_url").contains("favicon")) {
				urlToImage = generateGenericImage();
				System.out.println("Generic image provided: " + urlToImage);
			}
			else {
				urlToImage = article.getString("image_url");
			}
			
			if (article.isNull("description") || article.getString("description").trim().isEmpty()) {
				desc = "There is no description for this article. Please visit the link for more information. Lorem ipsum dolor sit amet. "
						+ "Et eveniet excepturi non provident internos est ducimus";
			}
			else {
				desc = article.getString("description");
			}
			
			articleList.add(new Article(title, articleURL, urlToImage, desc));

		}

		return articleList;
	}
	
	private String generateGenericImage() {
		
		int max = 5;
        int min = 1;
        int range = max - min + 1;
        
        int randomNumber = (int)(Math.random() * range) + 1;
        
        switch (randomNumber) {
        case 1:
        	return "https://sa1s3optim.patientpop.com/assets/images/provider/photos/1608281.jpg";
        case 2:
        	return "https://pulmonaryfibrosisnews.com/forums/wp-content/uploads/2020/05/shutterstock_319572347_zpso2eh3rs6-1000x480@2x.jpg";
        case 3:
        	return "https://blog.dumac.com/hubfs/dumac-blog-generic-news.jpg";
        case 4:
        	return "https://www.wholesaleinvestor.com/wp-content/uploads/2022/11/news-generic3.jpg";
        case 5:
        	return "https://www.analoguetrash.com/wp-content/uploads/2022/12/AT-Generic-News-Header.jpg";
        }

		return null;
	}	
}
