<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="/"> <h2>Fortran</h2></a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/m/38/0553/0733">Set Up</a></li>
            <li><a href="/m/38/0483/0345">Forms</a></li>
            <li><a href="/m/38/0553/0342">Cards</a></li>
            <li><a href="/m/26/0553/0348">Advanced</a></li>
            <li><a href="/m/26/0483/2342">Binary</a></li>

        </ul>

    </div>
</nav>
<p>This is a checkbox <input type="checkbox" value="test"></p>
<div class="panel panel-default">
    <p><c:out value="${content}"></c:out></p>
</div>
</body>
</html>