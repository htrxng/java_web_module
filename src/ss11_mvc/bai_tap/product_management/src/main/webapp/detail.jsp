<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/4/2022
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h3>Detail product</h3>
    <table>
        <tr>
            <td>Name:</td>
            <td>${product.getNameProduct()}</td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>${product.getPrice()}</td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>${product.getDescription()}</td>
        </tr>
        <tr>
            <td>Manufacturer:</td>
            <td>${product.getManufacturer()}</td>
        </tr>
        <tr>
            <td><a href="/product">Back to product list</a></td>
        </tr>
    </table>
</form>
</body>
</html>
