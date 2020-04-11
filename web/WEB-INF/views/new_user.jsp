<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New User</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout">
</form:form>

<div align="center">
    <h2>New User</h2>
    <form:form action="${pageContext.request.contextPath}/users/save" method="POST" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>Login:</td>
                <td><form:input path="username"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="password"/></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td>Second Name:</td>
                <td><form:input path="secondName"/></td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td><form:input path="birthday" type = "date"/></td>
            </tr>
            <tr>
                <td>Role(s):</td>
                <td><form:checkboxes path="roles" items="${roles}" /> </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>