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
<%@include file="header2.jsp" %>
 

<main style="padding-top:8.5%" class="col-sm-12 form-signin w-100 m-auto register-box round-corner">
  <form action = "processLogin" method="POST">

    <h1 style="font-weight: bold;" class="h1 mb-3 fw-normal">Sign in</h1>

    <div class="form-floating">
   		
      	<input type="text" class="form-control" id="floatingInput" path="username" name="username" placeholder="Username">
     
    </div>
    <div style="padding-top:8px" class="form-floating">
   		
     	 <input path="password" name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
    </div>
    <br>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
          <div class="text-center">
        <p>Not a member? <a href="goToRegisterPage">Register</a></p>
      </div>
  </form>
  	<br>
	<c:if test="${not empty requestScope.error }">
		<p style="color:red;">${requestScope.error }</p>
	</c:if>
</main>
    
    
    
  </body>
</html>
