<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
    <title>Home Page</title>
</head>

<body>
<!-- Add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">
    <input type="submit" value="Logout"/>
</form:form>

<h2>SpringCRUD Home Page</h2>
<hr>

<p>
    User: <sec:authentication property="principal.username"/>
    <br><br>
    Role(s): <sec:authentication property="principal.authorities"/>
</p>

<sec:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/users">System Page</a>
        (Only for Admin peeps)
    </p>
</sec:authorize>


</body>
</html>









