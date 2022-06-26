<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
  <title>Hotel 3C</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div class="jumbotron text-center">
    <h1>Welcome to our Comfortable, courteous and contemporary Hotel 3C</h1>
    <h2>Feel at home!</h2>
</div>
<div>
  <h3>${pageContext.request.userPrincipal.name}</h3>
  <sec:authorize access="!isAuthenticated()">
    <h4><a href="/SingIn">Sing in</a></h4>
    <h4><a href="/registration">Sing up</a></h4>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <h4><a href="/logout">Logout</a></h4>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <h4><a href="/account">My account</a></h4>
  </sec:authorize>
  <h4><a href="/admin"> Administrate (just admin)</a></h4>

  <h4><a href="/apart_classes"> Discover our apartments (just user)</a></h4>
  <p>Virtual excursion</p>

  <div class="col-sm-4">
            <h3>Food</h3>
            <p>Lobby bar and restaurant</p>
  </div>

  <div class="container">
      <a href = '/reservation'> Book your apartment
      </a>
  </div>

</div>
</body>
</html>