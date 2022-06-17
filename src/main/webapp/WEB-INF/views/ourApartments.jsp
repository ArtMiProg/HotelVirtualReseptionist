<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Our Apartments</title>
    </head>
    <body>
        <c:forEach  items="${apart_classes}" var ="apart_class">
        ${apart_class.id} - ${apart_class.apclass} - ${apart_class.classFactor}
        </c:forEach><br>
<a href="/apartChoosing">Select your apartment features</a><br>
<p>OR</p>
<a href="/reservation">Go to booking</a><br>
<a href="/">Or return to main page</a>
    </body>
</html>