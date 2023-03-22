<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Manage reservations</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>

<body>
 <div>
  <table>
      <thead>
      <th>Reservation Number</th>
      <th>Passport Data</th>
      <th>User ID</th>
      <th>Check in date</th>
      <th>Check out date</th>
      <th>Preferred apartment class</th>
      <th>Preferred apartment size</th>
      <th>Confirmation by admin</th>
      </thead>
      <c:forEach items="${allReservations}" var="reservation">
        <tr>
          <td>${reservation.reservationNumber}</td>
          <td>${reservation.passportData}</td>
          <td>${reservation.userId}</td>
          <td>${reservation.checkInDate}</td>
          <td>${reservation.checkOutDate}</td>
          <td>${reservation.prefApClass}</td>
          <td>${reservation.prefApSize}</td>
          <td>${reservation.isConfirmed}</td>
          <td>
            <form action="${pageContext.request.contextPath}/admin/invoice" method="get">
              <input type="hidden" name="reservationNumber" value="${reservation.reservationNumber}"/>
              <input type="hidden" name="userId" value="${reservation.userId}"/>
              <input type="hidden" name="checkInDate" value="${reservation.checkInDate}"/>
              <input type="hidden" name="checkOutDate" value="${reservation.checkOutDate}"/>
              <input type="hidden" name="prefApClass" value="${reservation.prefApClass}"/>
              <input type="hidden" name="prefApSize" value="${reservation.prefApSize}"/>
              <input type="hidden" name="action" value="review"/>
              <button type="submit">Review</button>
            </form>
          </td>
          <td>
            <form action="${pageContext.request.contextPath}/admin/reservations" method="post">
              <input type="hidden" name="reservationNumber" value="${reservation.reservationNumber}"/>
              <input type="hidden" name="action" value="delete"/>
              <button type="submit">Delete</button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
     <div id="footer"><a href="/"><h2>Main</h2></a></div>
    </div>
    </body>
    </html>