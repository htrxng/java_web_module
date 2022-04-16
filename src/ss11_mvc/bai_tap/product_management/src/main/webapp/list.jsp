<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/4/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <button class="btn btn-primary" style="color: white"><a href="/product?action=create">Add</a></button>
    <form method="get" action="/product">
        <input type="hidden" name="action" value="search">
        <label>Name product </label>
        <input type="text" name="name">
        <button type="submit">Search</button>
    </form>
    <tr>
        <td>ID</td>
        <td>Product's Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Manufacturer</td>
        <td>Edit</td>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getNameProduct()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getManufacturer()}</td>
            <td><a href="/product?action=update&id=${product.getId()}">Update</a></td>
            <td><a href="/product?action=remove&id=${product.getId()}">Remove</a></td>
            <td><a href="/product?action=detail&id=${product.getId()}">Detail</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
