<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link href="css/styles.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Quicksand&family=Source+Sans+Pro&display=swap" rel="stylesheet">
</head>
<body>

<c:if test="${not empty sessionScope.currentUser }">
	<nav class="navbar navbar-expand-lg navbar-light navbar-custom sticky-top">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">NewsCentral</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	      <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href=<c:url value="/"/>>Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" aria-current="page" href="searchForArticles">Explore Articles</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="goToTechNews">Technology</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="viewSavedArticles">My Saved Articles</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="goToSettings">Account Preferences</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="goToCheckUserPage">Account</a>
	        </li>
	                <li class="nav-item">
	          <a class="nav-link" href="processLogout">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
</c:if>

<c:if test="${empty sessionScope.currentUser }">
	<nav class="navbar navbar-expand-lg navbar-light navbar-custom sticky-top">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">NewsCentral</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	      <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href=<c:url value="/"/>>Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link disabled" aria-current="page" href="searchForArticles">Explore Articles</a>
	        </li>
	       	<li class="nav-item">
	          <a class="nav-link" href="goToTechNews">Technology</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link disabled" href="viewSavedArticles">My Saved Articles</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link disabled" href="goToSettings">Account Preferences</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="goToLoginPage">Sign in</a>
	        </li>
	                <li class="nav-item">
	          <a class="nav-link" href="goToRegisterPage">Register</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
</c:if>

<img src="img/logo.png" alt="Logo">



</body>
</html>