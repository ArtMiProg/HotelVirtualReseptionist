<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Invoice</title>
</head>

<body>
<div>
      <c:forEach  items="${apartNumbers}" var ="apartNumber">
        ${apartNumber.number} - Class: ${apartNumber.apartClassId} Number of rooms: ${apartNumber.apartSizeId} <br>
      </c:forEach><br>
</div>
<div>
  <form:form method="POST" modelAttribute="newInvoice">
    <h2>Accept or cancel reservation</h2>
    <div>
         <form:input type="text" path="id" placeholder="Reservation number"
                      autofocus="true"></form:input>
         <form:errors path="id"></form:errors>
            ${idError}
    </div>
    <div>
          <form:input type="text" path="userId" placeholder="Write user ID"
                      autofocus="true"></form:input>
          <form:errors path="userId"></form:errors>
            ${userIdError}
    </div>
    <div>
          <form:input type="text" path="number" placeholder="Apartment number"
                      autofocus="true"></form:input>
          <form:errors path="number"></form:errors>
            ${numberError}
    </div>
    <div>
              <form:input type="text" path="price" placeholder="Price for payment"
                          autofocus="true"></form:input>
              <form:errors path="price"></form:errors>
                ${priceError}
        </div>
    <div>
          <form:input type="text"  path="checkInDate" placeholder="Arrival date"
                      autofocus="true"></form:input>
          <form:errors path="checkInDate"></form:errors>
            ${checkInDateError}
    </div>
    <div>
          <form:input type="text"  path="checkOutDate" placeholder="Departure date"
                      autofocus="true"></form:input>
          <form:errors path="checkOutDate"></form:errors>
            ${checkOutDateError}
    </div>

    <button type="submit">Send invoice</button>
  </form:form>
    <a href="/">Main</a>
 </div>
</body>
</html>
