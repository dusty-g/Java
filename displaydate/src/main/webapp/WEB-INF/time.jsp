<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var = "x" value = "<%= new java.util.Date() %>"/>
<%--<fmt:formatDate value="${x}" type="time"/>--%>
<%--<span><%=new SimpleDateFormat("hh:mm:ss a").format((Date) request.getAttribute("date")) %></span>--%>
<span><c:out value="${time}"></c:out> </span>
