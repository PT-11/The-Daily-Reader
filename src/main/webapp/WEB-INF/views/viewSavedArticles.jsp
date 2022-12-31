<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saved Articles</title>
</head>

<%@include file="header.jsp" %>

  <body>
        <div class="content-wrapper">
          <div class="container">
            <div class="col-sm-12">
              <div class="card" data-aos="fade-up">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-12">
                      <h1 class="font-weight-600 mb-4">
                        Saved Articles
                      </h1>
                      	<c:if test="${not empty requestScope.noSavedArticles }">
							<p>${requestScope.noSavedArticles }</p>
						</c:if>
						<br>
						<br>
                    </div>
                  </div>
                  
                  <div class="row">
                  
                    <div class="col-lg-8">
                    
                    <c:forEach var="article" items="${sessionScope.savedList}">
		
			<c:url var="removeLink" value="deleteArticle">
				<c:param name="url" value="${article.url}"/>
			</c:url>
                    
                      <div class="row">
                        <div class="col-sm-4 grid-margin">
                          <div class="rotate-img">
                            <img
                              src="${article.urlToImage}"
                              alt="banner"
                              class="img-fluid"
                            />
                          </div>
                        </div>
                        <div class="col-sm-8 grid-margin">
                          <h2 class="font-weight-600 mb-2">
                          <a style="color:#000000;" href="${article.url}">${article.title}</a> 
                            
                          </h2>
                          <p class="fs-13 text-muted mb-0">
                            <span class="mr-2"><a style="color:#000000;" href="${removeLink}">Remove</a>
                          </p>
                          <p class="fs-15">
                            ${article.desc}
                          </p>
                        </div>
                      </div>
                      </c:forEach>
                    </div>

  

        <!-- partial -->
      </div>
    </div>
    <!-- inject:js -->
    <script src="../assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- plugin js for this page -->
    
    <script src="../assets/vendors/aos/dist/aos.js/aos.js"></script>
    <!-- End plugin js for this page -->
    <!-- Custom js for this page-->
    <script src="../assets/js/demo.js"></script>
    <script src="../assets/js/jquery.easeScroll.js"></script>
    <!-- End custom js for this page-->
  </body>
</html>

