<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Room reservation</title>
</head>

<body>
<div>
  <form:form method="POST" modelAttribute="reservationForm">
    <h2>Room booking</h2>
    <div>
          <form:input type="text" path="passportData" placeholder="Write your document number"
                      autofocus="true"></form:input>
          <form:errors path="passportData"></form:errors>
            ${passportDataError}
    </div>
    <div>
          <form:input type="text" path="userId" placeholder="UserId"
                      autofocus="true"></form:input>
          <form:errors path="userId"></form:errors>
            ${userIdError}
    </div>
    <div>
          <form:input type="text" path="checkInDate" placeholder="Arrival date"
                      autofocus="true"></form:input>
          <form:errors path="checkInDate"></form:errors>
            ${checkInDateError}
    </div>
    <div>
          <form:input type="text" path="checkOutDate" placeholder="Departure date"
                      autofocus="true"></form:input>
          <form:errors path="checkOutDate"></form:errors>
            ${checkOutDateError}
    </div>
    <div>
          <form:input type="text" path="apartNumberId" placeholder="Apartment number"
                      autofocus="true"></form:input>
          <form:errors path="apartNumberId"></form:errors>
            ${apartNumberIdError}
    </div>
    <button type="submit">Book</button>
  </form:form>
    <a href="/">Main</a>
 </div>
</body>
</html>