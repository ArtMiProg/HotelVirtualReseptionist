<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>

<body>
<div>
  <table>
    <thead>
    <th>ID</th>
    <th>UserName</th>
    <th>UserSurname</th>
    <th>Roles</th>
    <th>UserName</th>
    <th>Password</th>
    </thead>
    <c:forEach items="${allUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.roleId}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>
          <form action="${pageContext.request.contextPath}/admin" method="post">
            <input type="hidden" name="id" value="${user.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
  </div>
  <form action="${pageContext.request.contextPath}/admin/addUser" method="get">
        <input type="hidden" name="action" value="add"/>
        <button type="submit">Add a new user</button>
  </form>
  <div id="footer"><a href="/admin/reservations"><h2>Review reservations</h2></a></div>
  <div id="footer"><a href="/admin/manageApartments"><h2>Manage apartments</h2></a></div>
  <div id="footer"><a href="/"><h2>Main</h2></a></div>
</div>
</body>
</html>