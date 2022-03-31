<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/31/2022
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>

<form:form method="post" action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td></td>
        </tr>
        <tr>
            <td><form:label path="id">Employ ID: </form:label></td>
            <td><form:input path="id"/></td>
        </tr>

        <tr>
            <td><form:label path="name">Employee's name: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="contactNumber">Contact number: </form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>

        <tr>
            <td><input type="submit" name="submit" value="submit"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
