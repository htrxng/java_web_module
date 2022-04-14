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
    <tr>
        <td>ID</td>
        <td>Name of Product</td>
        <td>Price</td>
        <td>Amount</td>
    </tr>
    <c:forEach var="product" items="${products}" >
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getNameProduct()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getAmount()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
