<form action="/admin/newring" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <p>Create new Ring</p>
    <p>Name: <input type="text" name="ringName"/></p>
    <button>Create 🔨</button>
</form>