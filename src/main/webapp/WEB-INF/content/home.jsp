<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<title >Title</title>
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
		<h1 >Title</h1>
		<div >Fake content</div>
		<div id="created" >July 11,
			2012 2:17:16 PM CDT</div>
		<security:authentication property="principal"></security:authentication>

		<br/>
		<%--<p>用户名：<sec:authentication property="name"/> </p>--%>
		<%--<p>用户名：<sec:authentication property="principal.username"/> </p>--%>
		<%--<p>用户姓名：<sec:authentication property="principal.name"/> </p>--%>
		<%--<p>用户名：${SPRING_SECURITY_CONTEXT.authentication.principal.Username}</p>--%>
		<%--<p>用户姓名：${SPRING_SECURITY_CONTEXT.authentication.principal.name} </p>--%>

		<form action="/logout" method="get">
            <input type="submit" value="Sign Out"/>
        </form>
	</div>
</body>
</html>
