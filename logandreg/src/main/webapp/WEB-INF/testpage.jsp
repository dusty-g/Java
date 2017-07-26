<h1>hello ${currentUser.firstName}</h1>

<p>First Name: ${currentUser.firstName}</p>
<p>Last Name: ${currentUser.lastName}</p>
<p>Email: ${currentUser.username}</p>
<p>Sign up date: ${currentUser.createdAt}</p>
<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
</form>