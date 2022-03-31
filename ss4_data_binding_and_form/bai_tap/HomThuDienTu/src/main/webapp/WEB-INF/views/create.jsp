<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/31/2022
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Mail</title>
</head>
<body>
<form:form action="info" method="post" modelAttribute="mail">
    <table>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td>
                <form:select path="languages">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>

        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select> emails per page
            </td>
        </tr>
        
        <tr>
            <td><form:label path="spams">Spams filter</form:label></td>
            <td><form:checkbox path="spams"/>Enable spams filter</td>
        </tr>
        
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <button value="Update">Update</button>
                <button value="Cancel">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>
