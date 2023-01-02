<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
  <head>    
	    <title>Login Page</title>
  </head>
	
  <body>
<%@include file="header.jsp" %>
 

<main class="form-signin w-100 m-auto register-box round-corner">
  <form action = "processLogin" method="POST">
    <img class="mb-4" src="img/Yahoo_News_Logo.png" alt="" width="250" height="125">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" path="username" name="username" placeholder="Username">
    </div>
    <div class="form-floating">
      <input path="password" name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
  </form>
  	<br>
	<c:if test="${not empty requestScope.error }">
		<p style="color:red;">${requestScope.error }</p>
	</c:if>
</main>
    
    
    
  </body>
</html>
