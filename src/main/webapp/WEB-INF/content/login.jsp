<!DOCTYPE html>
<html>
<head>
<title>Login</title>
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
				</ul>
			</div>
		</div>
		<div class="content">
			<%--<p  class="alert">You have been logged out</p>--%>
			<%--<p  class="alert alert-error">There was an error, please try again</p>--%>
			<h2>Login with Username and Password</h2>
			<form name="form" action="/login" method="POST">
				<fieldset>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input type="text" name="username" value="" placeholder="Username" />
					<input type="password" name="password" placeholder="Password" />
				</fieldset>
				<label><input type="checkbox" name="remember-me" value="true" th:checked="checked"/> Remeber me</label>
				<input type="submit" id="login" value="Login"
					class="btn btn-primary" />
			</form>
		</div>
	</div>
</body>
</html>