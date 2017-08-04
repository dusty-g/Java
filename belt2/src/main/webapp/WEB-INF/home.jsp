<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><link href="/public/style.css" rel="stylesheet"></head>
<h1>Login</h1>
<c:if test="${logoutMessage != null}">
    <c:out value="${logoutMessage}"/>
</c:if>
<c:if test="${errorMessage != null}">
    <c:out value="${errorMessage}"/>
</c:if>
<p><form:errors path="user.*"/></p>
    <form method="POST" action="/login">
        <p>
            <label for="username">Email</label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login!"/>
    </form>

<br>
<h1>Register</h1>
<form:form action="/registration" method="post" modelAttribute="user">

    <p>
        Email:
        <form:input path="username"/>
    </p>
    <p>
        First Name:
        <form:input path="firstName"/>
    </p>
    <p>
        Last Name:
        <form:input path="lastName"/>
    </p>
    <p>
        Password:
        <form:input type="password" path="password"/>
    </p>
    <p>
        Confirm Password:
        <form:input type="password" path="passwordConfirmation"/>
    </p>
    <button>Register</button>
</form:form>