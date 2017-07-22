<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>${question.question}</h1>
<h3><c:forEach var="tag" items="${question.tags}"><span class="tag">(${tag.subject})</span></c:forEach></h3>

<table>
    <tr><th>Answers</th></tr>
    <c:forEach items="${question.answers}" var="ans">
        <tr><td>${ans.answer}</td></tr>
    </c:forEach>
</table>

<form:form modelAttribute="answerModel" method="post" action="/questions/${question.id}">
    <form:label path="answer">
        Answer Question:<br>
        <form:errors path="answer"/>
        <form:textarea path="answer" rows="4" cols="30"/>
    </form:label>
    <button>Answer</button>
</form:form>
<a href="/questions">Dashboard</a>