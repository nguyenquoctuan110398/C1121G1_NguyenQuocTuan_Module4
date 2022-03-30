<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/30/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <br>
    <input type="submit" name="submit">
</form>
<h2>Result: </h2>
<c:forEach var="condiment" items="${condiment}">
    <h4>${condiment.toString()}</h4>
</c:forEach>

</body>
</html>
