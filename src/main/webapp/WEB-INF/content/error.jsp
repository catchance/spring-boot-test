<!DOCTYPE html>
<html>
<head>
<title>Error</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="http://www.thymeleaf.org"> Thymeleaf -
					Plain </a>
				<ul class="nav">
					<li><a href="home"> Home </a></li>
					<li><a href="logout"> Logout </a></li>
				</ul>
			</div>
		</div>
		<h1 th:text="${title}">Title</h1>
		<div id="created">July 11,
			2012 2:17:16 PM CDT</div>
		<div>
			There was an unexpected error
			${error}
			500</span>).
		</div>
		<div>${message} Fake content</div>
		<div>
			Please contact the operator with the above information.
		</div>
	</div>
</body>
</html>
