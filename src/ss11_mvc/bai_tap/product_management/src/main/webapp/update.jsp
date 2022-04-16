<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/4/2022
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <table>
        <tr>
            <td>Name Product:</td>
            <td><input type="text" name="name" id="name" value="${requestScope["product"].getNameProduct()}"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" id="description"
                       value="${requestScope["product"].getDescription()}"></td>
        </tr>
        <tr>
            <td>Manufacturer:</td>
            <td><input type="text" name="manufacturer" id="manufacturer"
                       value="${requestScope["product"].getManufacturer()}"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update product">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
