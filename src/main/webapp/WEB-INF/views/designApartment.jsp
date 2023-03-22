<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>New Apartment number</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>
<body>
    <div id="secondary">
        <form method="post" modelAttribute = "newApartment" enctype="multipart/form-data">

        		<label for="apartClassId">Class Id:</label>
        		<input type="text" name="apartClassId" required><br>
        		<label for="apartSizeId">Size Id:</label>
        		<input type="text" name="apartSizeId" required><br>
        		<label for="image">Image:</label>
        		<input type="file" name="image" required><br>
        		<button type="submit">Save</button>
        	</form>
        <div id="footer"><a href="/"><h2>Main</h2></a></div>
    </div>
</body>
</html>