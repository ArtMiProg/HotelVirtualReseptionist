<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Room reservation</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>

<body>
<div>

</div>
<div id="secondary">
  <form:form method="POST" modelAttribute="reservationForm">
    <h2>Room booking</h2>
    <ul>
    <li>
          <form:input type="text" path="passportData" placeholder="Write your document number"
                      autofocus="true"></form:input>
          <form:errors path="passportData"></form:errors>
            ${passportDataError}
    </li>
    <li>
          <form:input type="text" path="userId" placeholder="UserId"
                      autofocus="true"></form:input>
          <form:errors path="userId"></form:errors>
            ${userIdError}
    </li>
    <li>
          <form:input type="date"  path="checkInDate" placeholder="Arrival date"
                      autofocus="true"></form:input>
          <form:errors path="checkInDate"></form:errors>
            ${checkInDateError}
    </li>
    <li>
          <form:input type="date"  path="checkOutDate" placeholder="Departure date"
                      autofocus="true"></form:input>
          <form:errors path="checkOutDate"></form:errors>
            ${checkOutDateError}
    </li>
    <li>
          <p>Choose your Apartment class:</p>
          <form>
             <input type="radio"  id="prefApClass" name="prefApClass" value="Econom" path="prefApClass">
             <label for="Ecomon">Econom</label><br>
             <input type="radio"  id="prefApClass" name="prefApClass" value="Standart" path="prefApClass">
             <label for="Standart">Standart</label><br>
             <input type="radio"  id="prefApClass" name="prefApClass" value="Lux" path="prefApClass">
             <label for="Lux">Lux</label><br>
          </form>
          <form:errors path="prefApClass"></form:errors>
            ${prefApClassError}
    </li>
    <li>
          <p>Choose number of rooms in your apartment:</p>
          <form:input type="number"  id="prefApSize" name="prefApSize" path="prefApSize" value="1" min="1" max="3"
                                autofocus="true"></form:input>
          <form:errors path="prefApSize"></form:errors>
             ${prefApSizeError}
    </li>
    <button type="submit">Book</button>
    </ul>
  </form:form><br>
  <div id="footer"><a href="/"><h2>Main</h2></a></div>
 </div>
</body>
</html>