<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/31/2022
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Information Mail</title>
</head>
<body>
<form:form modelAttribute="mail" action="edit" >
    <table>
        <tr>
            <td>Languages:</td>
            <td>${mail.languages}</td>
        </tr>

        <tr>
            <td>Page Size:</td>
            <td>${mail.pageSize}</td>
        </tr>

        <tr>
            <td>Spams filter:</td>
            <td>
                <c:if test="${mail.spams == true}">Enable spams filter</c:if>
                <c:if test="${mail.spams == false}">No enable spams filter</c:if>
            </td>
        </tr>

        <tr>
            <td>Signature:</td>
            <td>${mail.signature}</td>
        </tr>

        <tr>
            <form:button>
                edit
            </form:button>
        </tr>
    </table>
    <form:hidden path="languages" value="${mail.languages}"/>
    <form:hidden path="pageSize" value="${mail.pageSize}"/>
    <form:hidden path="spams" value="${mail.spams}"/>
    <form:hidden path="signature" value="${mail.signature}"/>
</form:form>
</body>
</html>
