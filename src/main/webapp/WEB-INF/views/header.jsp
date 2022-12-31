<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
	<link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link href="css/styles.css" rel="stylesheet">
	<link href="css/explore.css" rel="stylesheet">
	<link href="css/sign-in.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Quicksand&family=Source+Sans+Pro&display=swap" rel="stylesheet">

<c:if test="${not empty sessionScope.currentUser }">
	<nav class="navbar navbar-expand-lg navbar-light navbar-custom">
	  <div class="container-fluid">
 		<a class="navbar-brand" href="#">The Daily Reader</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	      <li class="nav-item">
	          <a class="nav-link" aria-current="page" href=<c:url value="/"/>>Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="viewSavedArticles">Saved</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="processLogout">Logout</a>
	        </li>
	      </ul>

	    </div>
	    	  <form action="searchForTopic" method="GET" class="form-inline my-2 my-lg-0">
      <input name="topic" placeholder="Search For Topic" class="form-control mr-sm-2" type="search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
	  </div>
	</nav>
</c:if>

<c:if test="${empty sessionScope.currentUser }">
	<nav class="navbar navbar-expand-lg navbar-light navbar-custom">
	  <div class="container-fluid">
		<a class="navbar-brand" href="#">The Daily Reader</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	      <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href=<c:url value="/"/>>Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link disabled" href="viewSavedArticles">Saved</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="goToLoginPage">Sign in</a>
	        </li>
	                <li class="nav-item">
	          <a class="nav-link" href="goToRegisterPage">Register</a>
	        </li>
	      </ul>

	    </div>
	    	<form action="searchForTopic" method="GET" class="form-inline my-2 my-lg-0">
      <input name="topic" placeholder="Search For Topic" class="form-control mr-sm-2" type="search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
	  </div>
	</nav>
</c:if>