<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Welcome ${user.firstName}</h1>

<p>current package: ${user.subscription.plan.name}</p>
<p>next due date: <c:if test="${today.getDate()< user.subscription.due}">${today.getMonth()+1}</c:if><c:if test="${today.getDate()>= user.subscription.due}">${today.getMonth()+2}</c:if>/${user.subscription.due}/${today.getYear()+1900}</p>
<p>amount: $${user.subscription.plan.price}</p>
<p>user since: ${user.createdAt}</p>
<form action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button>Logout</button>
</form>