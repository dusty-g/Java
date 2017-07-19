<!DOCTYPE html>
<html lang="en">

<head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<p><c:out value="${error}"></c:out></p>
<p>What is the code?</p>
<form action="/code" method="post">
    <input type="text" name="code" value="">
    <button>Try Code</button>
</form>

</body>
</html>