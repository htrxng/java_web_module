<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/4/2022
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label>Name of Product</label>
    <input type="text" name="name"> <br>
    <p style="color:red;">${error.get("name")}</p>
    <label>Price</label>
    <input type="number" name="price"> <br>
    <label>Amount</label>
    <input type="number" name="amount">
    <button type="submit">Add</button>
</form>
</body>
</html>
