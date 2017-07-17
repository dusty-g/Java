<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.dusty.teamroster.models.Team" %>
 <%@ page import="com.dusty.teamroster.models.Player" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Players</title>
</head>
<body>
<% Team team = Team.getTeams().get(Integer.parseInt(request.getParameter("id"))); %>
<p>test</p>
<p><%=team.getTeam_name() %></p>
<p><a href="/TeamRoster/addPlayer?id=<%=request.getParameter("id") %>">New Player</a></p>

<table>
<tr><th>First Name</th><th>Last Name</th><th>Age</th><th>Actions</th></tr>
<%for(int i = 0; i < team.getPlayers().size(); i++ ){ %>
<tr><td><%= team.getPlayers().get(i).getFirst_name() %></td><td><%=team.getPlayers().get(i).getLast_name() %></td><td><%=team.getPlayers().get(i).getAge() %></td><td><a href="/TeamRoster/addPlayer?team_id=<%= request.getParameter("id")%>&player_id=<%=i%>&delete=true">Delete</a></td></tr>
<%} %>
</table>
</body>
</html>