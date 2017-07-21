<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>New Category</h1>
<form:form action="/categories/new" method="post" modelAttribute="category">
    <form:label path="categoryName">
        Name:
        <form:errors path="categoryName"/>
        <form:input path="categoryName"/>
    </form:label><br>
    <button>Create</button>

</form:form>