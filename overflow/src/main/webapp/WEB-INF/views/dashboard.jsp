<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Questions Dashboard</h1>
<table>
    <tr><th>Question</th><th>Tags</th></tr>
    <c:forEach var="question" items="${questions}">
        <tr><td><a href="/questions/${question.id}">${question.question}</a></td><td><c:forEach items="${question.tags}" var="tag">(${tag.subject}) </c:forEach></td></tr>
    </c:forEach>
</table>
<a href="/questions/new">New Question</a>