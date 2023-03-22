<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Change Apartment number</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>
<body>
    <div id="secondary">
        <form method="post" modelAttribute = "changedApartNumber" enctype="multipart/form-data">
            <label for="id">Apartment id:</label>
            <input type="text" name="id" value = "${changedApartNumber.id}"><br>
            <label for="number">Apartment number:</label>
            <input type="text" name="number" value ="${changedApartNumber.number}"><br>
            <label for="apartClassId">Class Id:</label>
            <input type="text" name="apartClassId" value ="${changedApartNumber.apartClassId}"><br>
            <label for="apartSizeId">Size Id:</label>
            <input type="text" name="apartSizeId" value ="${changedApartNumber.apartSizeId}"><br>



            <label for="image">Image:</label>
            <input type="file" name="image" ><br>
            <button type="submit">Save</button>
        </form>

        <div id="footer"><a href="/"><h2>Main</h2></a></div>
    </div>
</body>
</html>