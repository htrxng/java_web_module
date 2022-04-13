<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/4/2022
  Time: 7:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>discount_calculator</title>
</head>
<body>
<form action="/display-discount" method="post">
    <input type="text" name="describe" placeholder="Enter describe product: "/>
    <input type="number" name="fixed_price" placeholder="Enter fixed price: "/>
    <input type="number" name="discount_percent" placeholder="Enter discount percent: "/>
    <input type="submit" id="submit" value="Calculate Discount"/>
</form>
</body>
</html>
