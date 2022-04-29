<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/4/2022
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post">

    <table border="1" cellpadding="5">
        <caption> <h3>Add new Product</h3></caption>
        <tr>
            <th>Name Product: </th>
            <td><input type="text" name="name" size="50"></td>
        </tr>
        <tr>
            <th>Price:</th>
            <td><input type="number" name="price" size="20">  </td>
        </tr>
        <tr>
            <th>Quantity</th>
            <td><input type="number" name="quantity" size="20"></td>
        </tr>
        <tr>
            <th>Color</th>
            <td>
                <select name="colorId">
                    <c:forEach var="color" items="${colors}">
                        <option value="${color.colorId}">
                            ${color.colorName}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Category</th>
            <td>
                <select name="categoryId" >
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.categoryId}">
                            ${category.categoryName}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Save"/>
                <button>
                    <a href="products?action=products">Back</a>
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
