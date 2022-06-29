<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE HTML>
<html>
<head>
  <title>Hotel 3C</title>
  <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
  <meta charset="UTF-8" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/design.css"/>
</head>
<body>
<div id="container">
  <div id="header">
    <div id="website_title">
      <div id="title"> Hotel 3C  </div>
      <div id="salgon"> Comfortable Courteous Contemporary<br>
                            Feel at home!</div>
    </div>
  </div>
   <div id="banner">
      <div id="menu">
        <ul>
          <li>${pageContext.request.userPrincipal.name}</li>
          <li><a href="/" class="current">Main</a></li>
          <li><sec:authorize access="!isAuthenticated()">
                  <a href="/SingIn">Sing in</a>
               </sec:authorize></li>
          <li><sec:authorize access="!isAuthenticated()">
                  <a href="/registration">Sing up</a>
                </sec:authorize></li>
          <li><sec:authorize access= "hasRole('ROLE_USER')">
                  <a href="/apart_classes"> Our apartments </a>
                </sec:authorize></li>
          <li><a href = '/reservation'> Book</a></li>
          <li><sec:authorize access="isAuthenticated()">
                 <a href="/logout">Logout</a>
                </sec:authorize></li>
          <li><sec:authorize access="isAuthenticated()">
                  <a href="/account">My account</a>
                </sec:authorize></li>
        </ul>
      </div>
    </div>
  <div>
    <div id="footer">
          <sec:authorize access= "hasRole('ROLE_ADMIN')">
              <a href="/admin"><strong>Administrate</strong></a>
          </sec:authorize>
              <a href="#"class="last"><strong>Contact</strong></a>
  </div>
</div>
</body>
</html>