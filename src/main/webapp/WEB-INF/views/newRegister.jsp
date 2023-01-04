<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Register Form</title>
</head>
<body>
<%@include file="header2.jsp" %>


<section class="vh-100">
  <div class="container h-25">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="text-black">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p style="font-weight: bold;" class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                <sf:form class="mx-1 mx-md-4" action = "processUser" method="POST" modelAttribute="user">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <sf:input path="username" type="text" id="form3Example1c" class="form-control" />
                      <sf:label path="username" class="form-label" for="form3Example1c">Username</sf:label>
						<c:if test="${not empty requestScope.error }">
							<p style="color:red;">${requestScope.error }</p>
						</c:if>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <sf:input path="email" type="email" id="form3Example3c" class="form-control" />
                      <sf:label path="email" class="form-label" for="form3Example3c">Email</sf:label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <sf:input path="Password" type="password" id="form3Example4c" class="form-control" />
                      <sf:label path="password" class="form-label" for="form3Example4c">Password</sf:label>
                    </div>
                  </div>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                   
                    <input class="btn btn-primary btn-lg" type="submit" value="Create account">
                  </div>

                </sf:form>

              </div>
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                <img src="img/cartoonhi.jpeg"
                  class="img-fluid" alt="Welcome-Image">

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>