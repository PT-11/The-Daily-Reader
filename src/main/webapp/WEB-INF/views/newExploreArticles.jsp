<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>The Daily Reader</title>
</head>
<body>
<%@include file="header.jsp" %>

  
        <div class="content-wrapper">
          <div class="container">
            <div class="col-sm-12">
              <div class="card" data-aos="fade-up">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-12">
                      <h1 class="font-weight-600 mb-4">
                        ${requestScope.header}
                      </h1>

                    </div>
                  </div>
                  
                  <div class="row">
                  
                    <div class="col-lg-8">
                    
                    <c:forEach var="standardArticle" items="${sessionScope.list}">
		
			<c:url var="saveLink" value="saveArticle">
				<c:param name="title" value="${standardArticle.title}"/>
				<c:param name="url" value="${standardArticle.url}"/>
				<c:param name="urlToImage" value="${standardArticle.urlToImage}"/>
				<c:param name="desc" value="${standardArticle.desc}"/>
				<c:param name="article" value="${standardArticle}"/>
			</c:url>
                    
                      <div class="row">
                        <div class="col-sm-4 grid-margin">
                          <div class="rotate-img">
                            <img
                              src="${standardArticle.urlToImage}"
                              alt="banner"
                              class="img-fluid"
                            />
                          </div>
                        </div>
                        <div class="col-sm-8 grid-margin">
                          <h2 class="font-weight-600 mb-2">
                          <a style="color:#000000;" href="${standardArticle.url}">${standardArticle.title}</a> 
                            
                          </h2>
                          <c:if test="${not empty sessionScope.currentUser }">
	                          <p class="fs-13 text-muted mb-0">
	                            <span class="mr-2"><a style="color:#000000;" href="${saveLink}">Save</a>
	                          </p>
                          </c:if>
                          <p class="fs-15">
                            ${standardArticle.desc}
                          </p>
                        </div>
                      </div>
                      </c:forEach>
                    </div>                 
                   
                    <!-- Side Column -->
                    <div class="col-lg-4">
                      <h2 class="mb-4 text-primary font-weight-600">
                        Latest news
                      </h2>
                      <div class="row">
                      
                       <c:forEach var="recentArticle" items="${sessionScope.recentList}">
                        <div class="col-sm-12">
                          <div class="border-bottom pb-4 pt-4">
                            <div class="row">
                              <div class="col-sm-8">
                                <h5 class="font-weight-600 mb-1">
                                  <a style="color:#000000;" href="${recentArticle.url}">${recentArticle.title}</a>
                                </h5>
                              </div>
                              <div class="col-sm-4">
                                <div class="rotate-img">
                                  <img
		                              src="${recentArticle.urlToImage}"
		                              alt="banner"
		                              class="img-fluid"
                            		/>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                         </c:forEach>
                        
                      </div>
                      
						<!-- Trending Section -->
						
                      <div class="trending">
                        <h2 class="mb-4 text-primary font-weight-600">
                          Trending
                        </h2>
                        <div class="mb-4">
                        
                        <c:forEach var="trendArticle" items="${sessionScope.trendList}">
                          <div class="rotate-img">
                             <img
		                              src="${trendArticle.urlToImage}"
		                              alt="banner"
		                              class="img-fluid"
                            	/>
                          </div>
                          <h3 class="mt-3 font-weight-600">
                            <a style="color:#000000;" href="${trendArticle.url}">${trendArticle.title}</a>
                          </h3>
                           </c:forEach>
                           
                        </div>

                    </div>
                  </div>
                  
                </div>
              </div>
            </div>
          </div>
        </div>
        
       
        <!-- container-scroller ends -->

  

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

