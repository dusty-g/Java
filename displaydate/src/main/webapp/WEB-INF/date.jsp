<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--<span><%=new SimpleDateFormat("E, dd, MMMM, yyyy").format((Date) request.getAttribute("date")) %></span>--%>
<span><c:out value="${date}"></c:out> </span>