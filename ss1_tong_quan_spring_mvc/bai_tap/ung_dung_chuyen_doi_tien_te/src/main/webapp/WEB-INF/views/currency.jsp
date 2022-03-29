<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/29/2022
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Currency</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<form action="/currency" method="post">

    <!-- Vertical -->
    <div class="form-group">
        <label for="usd">USD: </label>
        <input type="text" name="usd" id = "usd" class="form-control">
        <label for="vnd">VNĐ: </label>
        <input type="text" id="vnd" class="form-control" value="${vnd}">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>

</form>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</html>
