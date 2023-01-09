        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
	<link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link href="css/styles.css" rel="stylesheet">
	<link href="css/full-explore.css" rel="stylesheet">
	<link href="css/sign-in.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Quicksand&family=Source+Sans+Pro&display=swap" rel="stylesheet">

<c:if test="${empty sessionScope.currentUser }">

        <header id="header">
          <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light">
              <div class="navbar-top">
                <div class="d-flex justify-content-between align-items-center">
                
                  <ul style="position: absolute; right:10px;" class="navbar-top-right-menu">
                    <li class="nav-item">

                    <li class="nav-item">
                      <a href="goToLoginPage" class="nav-link">Login</a>
                    </li>
                    <li class="nav-item">
                      <a href="goToRegisterPage" class="nav-link">Sign up</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="navbar-bottom">
                <div class="d-flex justify-content-between align-items-center">
                  <div>
                    <a class="navbar-brand" href="#"
                      ><img src="img/logo.svg" alt=""
                    /></a>
                  </div>
                  <div>
                    <button
                      class="navbar-toggler"
                      type="button"
                      data-target="#navbarSupportedContent"
                      aria-controls="navbarSupportedContent"
                      aria-expanded="false"
                      aria-label="Toggle navigation"
                    >
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div
                      class="navbar-collapse justify-content-center collapse"
                      id="navbarSupportedContent"
                    >
                      <ul style="position: absolute; right:200px;" class="navbar-nav d-lg-flex justify-content-between align-items-center">
                        <li>
                          <button class="navbar-close">
                            <i class="mdi mdi-close"></i>
                          </button>
                        </li>
                        <li class="nav-item active">
                          <a class="nav-link" href="searchForArticles?header=general">Home</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=business">Business</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=sports">Sports</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=health">Health</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=politics">Politics</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=travel">Travel</a>
                        </li>
                      
                        <li class="nav-item">
                          <form action="searchForTopic" method="GET">
                   
					  <input type="text" name="topic" style="height: 15px" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
					
					  </form>
						</li>

                       
	
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </nav>
          </div>
        </header>
       </c:if>

<c:if test="${not empty sessionScope.currentUser }">
        <!-- partial:../partials/_navbar.html -->
        <header id="header">
          <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light">
              <div class="navbar-top">
                <div class="d-flex justify-content-between align-items-center">
                  <ul class="navbar-top-right-menu">
                    <li class="nav-item">
                      <a href="#" class="nav-link"><i class="mdi mdi-magnify"></i></a>
                    </li>
                    <li class="nav-item">
                      <a href="processLogout" class="nav-link">Logout</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="navbar-bottom">
                <div class="d-flex justify-content-between align-items-center">
                  <div>
                    <a class="navbar-brand" href="#"
                      ><img src="img/logo.svg" alt=""
                    /></a>
                  </div>
                  <div>
                    <button
                      class="navbar-toggler"
                      type="button"
                      data-target="#navbarSupportedContent"
                      aria-controls="navbarSupportedContent"
                      aria-expanded="false"
                      aria-label="Toggle navigation"
                    >
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div
                      class="navbar-collapse justify-content-center collapse"
                      id="navbarSupportedContent"
                    >
                      <ul
                        class="navbar-nav d-lg-flex justify-content-between align-items-center"
                      >
                        <li>
                          <button class="navbar-close">
                            <i class="mdi mdi-close"></i>
                          </button>
                        </li>
                        <li class="nav-item active">
                          <a class="nav-link" href="searchForArticles?header=general">Home</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="viewSavedArticles">Saved</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=business">Business</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=sports">Sports</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=health">Health</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=politics">Politics</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="searchForArticles?header=travel">Travel</a>
                        </li>
                        <li class="nav-item">
                          <form action="searchForTopic" method="GET">
                   
					  <input type="text" name="topic" style="height: 15px" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
					
					  </form>
						</li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </nav>
          </div>
        </header>
       </c:if>