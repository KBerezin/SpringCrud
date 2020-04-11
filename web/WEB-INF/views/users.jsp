<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Manager</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout">
</form:form>

<div align="center">
    <h2>User Manager</h2>
    <h3><a href="${pageContext.request.contextPath}/users/new">New User</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Password</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Role(s)</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.firstName} ${user.secondName}</td>
                <td>${user.birthday}</td>
                <td>${user.roles}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/users/edit?id=${user.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/users/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</div>
</body>
</html>