<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>My account</title>
</head>

<body>
<h4>${user.username}</h4>
<h4>Your ID is ${user.id}</h>
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
  <a href="/">Main</a>
</div>
</body>
</html>