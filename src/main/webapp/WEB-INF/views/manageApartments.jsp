<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Manage apartments</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>
<body>
    <a href="/"><h2>Main</h2></a>
    <form method="get" modelAttribute="basicPay">
        <div>
            <label for="basicPay"><h2>You can change basic pay here:</h2></label>
            <input type="text" name="basicPay" />
            <button>Change</button>
        </div>

    </form>
    <div>
    <h2>If you want to change the basic pay to <%= request.getParameter("basicPay")%> press "Save basic pay"</h2>
    <form action="${pageContext.request.contextPath}/admin/manageApartments" method="post" modelAttribute="basicPay">
         <input type="hidden" name="basicPay" value= <%=request.getParameter("basicPay")%> />
         <input type="hidden" name="action" value="save"/>
         <button type="submit">Save basic pay</button>
    </form>
    </div>
    <div>
        <table>
            <thread>
                <th>Apartment ID</th>
                <th>Number of apartment</th>
                <th>Apartment class</th>
                <th>Apartment size</th>
                <th>Basic pay</th>
                <th>Cost</th>
            </thread>
            <c:forEach items="${apartInfos}" var="apartNumber">
            <tr>
                <td>${apartNumber.id}</td>
                <td>${apartNumber.number}</td>
                <td>${apartNumber.apartClassId}</td>
                <td>${apartNumber.apartSizeId}</td>
                <td>${apartNumber.basicPay}</td>
                <td>${apartNumber.cost}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin/manageApartments" method="post" modelAttribute="basicPay">
                        <input type="hidden" name="basicPay" value= "${apartNumber.basicPay}" />
                        <input type="hidden" name="id" value="${apartNumber.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin/changeApartmentFeatures" method="get">
                        <input type="hidden" name="id" value="${apartNumber.id}"/>
                        <input type="hidden" name="number" value="${apartNumber.number}"/>
                        <input type="hidden" name="apartClassId" value="${apartNumber.apartClassId}"/>
                        <input type="hidden" name="apartSizeId" value="${apartNumber.apartSizeId}"/>

                        <input type="hidden" name="image" value="${apartNumber.image}"/>
                        <input type="hidden" name="action" value="change"/>
                        <button type="submit">Change</button>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        </div>
    <form action="${pageContext.request.contextPath}/admin/designApartment" method="get">
            <input type="hidden" name="action" value="add"/>
            <button type="submit">Design a new apartment</button>
    </form>

</body>
</html>