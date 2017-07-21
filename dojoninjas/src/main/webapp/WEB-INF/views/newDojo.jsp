<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>New Dojo</h1>
<form:form action="/dojos/new" method="post" modelAttribute="dojo">
    <form:label path="dojoName">
        Name:
        <form:errors path="dojoName"/>
        <form:input path="dojoName"/>

    </form:label>
    <button>Create</button>
</form:form>