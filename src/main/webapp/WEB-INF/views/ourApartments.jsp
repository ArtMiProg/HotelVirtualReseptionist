<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <meta charset="utf-8">
   <title>Our Apartments</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>
<body>
<div>
   <h2>We have apartments of three different sizes</h2>
   <table>
     <thead>
      <th>Class ID</th>
      <th>Class of apartment</th>
      <th>Class factor of cost</th>
     </thead>
   <c:forEach  items="${apart_classes}" var ="apart_class">
     <tr>
       <td> ${apart_class.id}</td>
       <td> ${apart_class.apclass}</td>
       <td> ${apart_class.classFactor}</td>
     </tr>
   </c:forEach>
   </table>
</div>
<div>
   <h2>We can offer you one-, two- and three-room apartments</h2>
   <table>
     <thead>
      <th>Size ID</th>
      <th>Number of rooms</th>
      <th>Size factor of cost</th>
     </thead>
     <tr>
       <td> 1 </td>
       <td> One </td>
       <td> 1 </td>
     </tr>
     <tr>
       <td> 2 </td>
       <td> Two </td>
       <td> 1.5 </td>
     </tr>
     <tr>
       <td> 3 </td>
       <td> Three </td>
       <td> 1.8 </td>
     </tr>
   </table>
</div>
<div id="footer">
   <a href="/apartChoosing">Select your apartment features</a><br>
   OR<br>
   <a href="/reservation">Go to booking</a><br>
   OR<br>
   <a href="/">Return to main page</a>
</div>
</body>
</html>