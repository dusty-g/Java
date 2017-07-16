<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Number Game!</h1>
	<h3>Guess a number between 1 and 100</h3>
	<%if(!(Boolean) request.getSession().getAttribute("gameOver")) {%>
	<form action="/GreatNumberGame/Game" method="post">
	<input type= "number" name="guess" >
	<button>Guess</button>
	</form>
	<%if((Boolean)request.getSession().getAttribute("hasGuessed")){ %>
		<div class="box">
		<%if((Boolean)request.getSession().getAttribute("tooHigh")){ %>
		<h1>Too high</h1>
		<%}else{ %>
		<h1>Too low</h1>
		<%} %>
		</div>
	<%} %>
	<%} else { %>
		<div class="box"><h1>The number was <%=request.getSession().getAttribute("randomNumber") %></h1>
		<form action="/GreatNumberGame/Game" method = "post">
		<input type="hidden" name="reset" value="not null">
		<button>Play again</button>
		</form>
		</div>
	<% } %>
	
	
</body>
</html>