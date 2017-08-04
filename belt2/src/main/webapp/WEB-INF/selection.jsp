<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Welcome ${user.firstName}</h1>
<p>choose subscription and start date</p>
<form action="/selection" method="post">
    <p>Due day:
    <select name="due">
        <c:forEach items="${days}" var="day">
        <option value="${day}">${day}</option>

        </c:forEach>
    </select>
    </p>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <p>
        Package:
        <select name="plan">
            <c:forEach items="${plans}" var="plan">

                <option value="${plan.id}">${plan.name}</option>
            </c:forEach>
        </select>
    </p>
    <button>Sign up</button>
</form>