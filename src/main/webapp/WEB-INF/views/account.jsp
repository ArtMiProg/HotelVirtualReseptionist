<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>My account</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>

<body>
<h2>${user.username}</h2>
<h2>Your ID is ${user.id}</2>
<div>-------------------</div>
<div>
<h4> You reservations details </h4>
  <table>
      <thead>
      <th>Reservation Number</th>
      <th>Check in date</th>
      <th>Check out date</th>
      <th>Preferred apartment class</th>
      <th>Preferred apartment size</th>
      <th>Confirmation by admin</th>
      </thead>
      <c:forEach items="${myReservations}" var="reservation">
        <tr>
          <td>${reservation.reservationNumber}</td>
          <td>${reservation.checkInDate}</td>
          <td>${reservation.checkOutDate}</td>
          <td>${reservation.prefApClass}</td>
          <td>${reservation.prefApSize}</td>
          <td>${reservation.isConfirmed}</td>
        </tr>
      </c:forEach>
  </table>

<h4>Your confirmed reservations</h4>
  <table>
      <thead>
      <th>Reservation number </th>
      <th>Apartment number </th>
      <th>Required payment </th>
      </thead>
      <c:forEach items="${currentInvoices}" var="invoice">
        <tr>
           <td>${invoice.id}</td>
           <td>${invoice.number}</td>
           <td>${invoice.price}</td>
        </tr>
       </c:forEach>
  </table>
  <div id="footer"><a href="/"><h2>Main</h2></a></div>
</div>
</body>
</html>