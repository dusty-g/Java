<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Admin Dashboard</h1>
<h2>Customers</h2>
<form action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button>Logout</button>
</form>
<table>
    <tr><th>Name</th><th>Next Date</th><th>Amount</th><th>Package Type</th></tr>

    <c:forEach items="${users}" var="user">

        <tr><td>${user.firstName} ${user.lastName}</td><td><c:if test="${today.getDate()< user.subscription.due}">${today.getMonth()+1}</c:if><c:if test="${today.getDate()>= user.subscription.due}">${today.getMonth()+2}</c:if>/${user.subscription.due}/${today.getYear()+1900}</td><td>$${user.subscription.plan.price}</td><td>${user.subscription.plan.name}</td></tr>
    </c:forEach>
</table>

<h2>Packages</h2>
<table>
    <tr><th>Package Name</th><th>Package Cost</th><th>Available</th><th>Users</th><th>Actions</th></tr>

    <c:forEach items="${plans}" var="plan">

        <tr><td>${plan.name}</td><td>count ${plan.subscriptions.size()}</td><td><c:if test="${plan.available}"><a href="/admin/deactivate/${plan.id}">Deactivate</a> </c:if> <c:if test="${!plan.available}"><a href="/admin/activate/${plan.id}">Activate</a> </c:if> <c:if test="${plan.subscriptions.size()<1}"><a href="/admin/delete/${plan.id}">Delete</a></c:if> </td></tr>
    </c:forEach>
</table>

<form action="/admin/plan/new" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <p>Create Package</p>
    <p>Package Name: <input name="packageName"></p>
    <p>Cost: <input type="number" name="price"></p>
    <button>Create new Package</button>
</form>