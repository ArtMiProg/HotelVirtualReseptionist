<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Apartment view</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/apartView.css"/>
</head>
<body>
    <a href="/"><h2>Main</h2></a>
    <c:forEach items="${apartNumbers}" var="apartNumber" >
    <form method="get" class = "line">
        <input type="hidden" name="id" value = "${apartNumber.id}"/>
        <input type="hidden" name="number" value = "${apartNumber.number}"/>
        <input type="hidden" name="apClassId" value = "${apartNumber.apartClassId}"/>
        <input type="hidden" name="apSizeId" value = "${apartNumber.apartSizeId}"/>
        <input type="hidden" name="cost" value = "${apartNumber.cost}"/>
        <button><img src="data:image/jpeg;base64,${apartNumber.getImageAsBase64()}" width="100" height="70" class="line">
        <div class="bottom-right">${apartNumber.number}</div></button>
    </form>
    </c:forEach><br>
    <div class = "description">
    Apartment No ${number}<br>
    Class of apartment: ${apartClass.apclass}<br>
    Quantity of rooms: ${apartSize.roomsQuantity}<br>
    Cost per day: ${cost} BYN<br>
    See and appreciate our apartment:
    </div>
    <div class = "image" >
    <img src="data:image/jpeg;base64,${apartNumberVied.getImageAsBase64()}" width="800" />
    </div>
    <div class="footer">
       <a href="/reservation">Go to booking</a><br>
       OR<br>
       <a href="/">Return to main page</a>
    </div>
</body>
</html>