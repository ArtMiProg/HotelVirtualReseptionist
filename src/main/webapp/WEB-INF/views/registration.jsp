<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Registration</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>

<body>
<div id="footer"><a href="/"><h2>Main</h2></a></div>
<div id="secondary">
  <form:form method="POST" modelAttribute="userForm">
    <h2>Registration</h2>
    <ul>
    <li>
          <form:input type="text" path="name" placeholder="Name"
                      autofocus="true"></form:input>
          <form:errors path="name"></form:errors>
            ${nameError}
    </li>
    <li>
          <form:input type="text" path="surname" placeholder="Surname"
                  autofocus="true"></form:input>
          <form:errors path="surname"></form:errors>
            ${surnameError}
    </li>
    <li>
          <form:input type="text" path="roleId" placeholder="Role Id"
                  autofocus="true"></form:input>
          <form:errors path="roleId"></form:errors>
            ${surnameError}
    </li>
    <li>
         <form:input type="text" path="username" placeholder="Username"
                  autofocus="true"></form:input>
         <form:errors path="username"></form:errors>
           ${usernameError}
    </li>
    <li>
         <form:input type="password" path="password" placeholder="Password"></form:input>
    </li>
    <li>
         <form:input type="password" path="passwordConfirm"
                  placeholder="Confirm your password"></form:input>
         <form:errors path="password"></form:errors>
           ${passwordError}
    </li>
    <button type="submit">Register</button>
    </ul>
  </form:form>
</div>
</body>
</html>