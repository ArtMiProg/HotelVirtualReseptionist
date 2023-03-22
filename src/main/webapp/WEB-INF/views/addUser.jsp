<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head
    <meta charset="utf-8">
    <title>User adding</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>
<body>
    <h2>Add a new user and set him a role: 5 if the new user is an admin, 6 if the new user is a user</h2>
    <div id="secondary">
    <form:form method="post" modelAttribute="newUser">
        <ul>
            <div>
                <form:input type="text" path="name" placeholder="Name"
                      autofocus="true"></form:input>
                <form:errors path="name"></form:errors>
                            ${nameError}
            </div>
            <div>
                <form:input type="text" path="surname" placeholder="Surname"
                      autofocus="true"></form:input>
                <form:errors path="surname"></form:errors>
                            ${surnameError}
            </div>
            <div>
                <form:input type="text" path="roleId" placeholder="Role ID"
                      autofocus="true" modelAttribute="roleId"></form:input>
                <form:errors path="roleId"></form:errors>
                            ${roleIdError}
            </div>
            <div>
                <form:input type="text" path="username" placeholder="Username"
                      autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
                            ${usernameError}
            </div>
            <div>
                <form:input type="password" path="password" placeholder="Password"
                      autofocus="true"></form:input>
            </div>
            <div>
                <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"
                      autofocus="true"></form:input>
                <form:errors path="password"></form:errors>
                        ${passwordError}
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/admin/addUser" method="post" modelAttribute="roleId">
                <input type="hidden" name="roleId" value= <%=request.getParameter("roleId")%> />
            </div>
            <button type="submit">Add user</button>
        </ul>
    </form:form>
    <div id="footer"><a href="/"><h2>Main</h2></a></div>
    </div>
</div>
</body>

</html>