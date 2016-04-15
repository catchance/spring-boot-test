<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>hello world</title>
</head>
<body>
<h1> Hello [[${httpServletRequest}]]!</h1>
    <form action="/logout" method="post">
        <input type = "submit" vlaue ="sign out"/>
    </form>
</body>
</html>