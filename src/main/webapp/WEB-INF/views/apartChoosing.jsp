<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Apartment choosing</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>

<body>
<form:form method="POST" modelAttribute="apartChoosingForm">
 <p>Select apartment class:</p>

<form>
  <input type="radio" id="econom" path="apclass" value="Econom">
  <label for="econom">Econom</label><br>
  <input type="radio" id="standart" path="apclass" value="Standart">
  <label for="standart">Standart</label><br>
  <input type="radio" id="lux" path="apclass" value="Lux">
  <label for="lux">Lux</label>
</form>


<p>Select number of rooms in your apartment:</p>
<form>
  <input type="radio" id="oneRoom" path="roomsQuantity" value="1">
  <label for="oneRoom">1</label><br>
  <input type="radio" id="twoRoom" path="roomsQuantity" value="2">
  <label for="twoRoom">2</label><br>
  <input type="radio" id="threeRoom" path="roomsQuantity" value="3">
  <label for="threeRoom">3</label>
</form>

<button type="submit">Confirm</button>
</form:form>
<div>
<a href="/reservation">Go to booking</a>
</div>
<div>
<a href="/">Main</a>
</div>
</body>

</html>
