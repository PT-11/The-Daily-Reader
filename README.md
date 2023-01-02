# The-Daily-Reader
This is a web application that enables users to browse trending new articles from around the world, browse and save them.

Live link: **currently setting up CICD pipelines - check back later**

In the meantime you can run the web application on your local machine by following these instructions:
1. Obtain a free API key from https://www.thenewsapi.com/
2. Create a global environment variable on your machine with the key of "TheNewsApiKey" and have the value set to the API key you received. 
3. Go to src/main/java -> com.SoloProject -> SoloProjectApplication.java and run it.
4. Visit http://localhost:8088/SpringApp/ on your browser to view the website.


Trouble Shooting

Status 500 Internal Server:
This could mean the program is unable to retrieve the Api Key
- Ensure the environment variable is set globally. This can be checked by opening a new command prompt or terminal and to retrieve the value of the key. 
- Restart your machine, sometimes programs need to be restarted to pick up new changes.
- Check API Key is valid

