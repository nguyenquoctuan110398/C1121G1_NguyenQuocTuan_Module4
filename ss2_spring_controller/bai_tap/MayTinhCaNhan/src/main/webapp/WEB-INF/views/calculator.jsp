<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/30/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post">
    <input type="text" name="number1" id="number1" placeholder="Enter number 1">
    <input type="text" name="number2" id="number2" placeholder="Enter number 2">
    <br>
    <input type="submit" name="operation" id="addition" value="Addition(+)">
    <input type="submit" name="operation" id="subtraction" value="Subtraction(-)">
    <input type="submit" name="operation" id="multiplication" value="Multiplication(*)">
    <input type="submit" name="operation" id="division" value="Division(/)">

    <h3>Result Division: ${result}</h3>
</form>
</body>

</html>
