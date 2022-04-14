<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/4/2022
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/calculator" method="post">
    <label>Operator</label>
    <label>First Operand</label>
    <input type="number" name="first_operand" placeholder="Enter a"> <br>
    <select name="operator">
      <option value="plus" >Plus</option>
      <option value="minus">Minus</option>
      <option value="multiplied">Multiplied</option>
      <option value="divide">Divide</option>
    </select> <br>
    <label>Second Operand</label>
    <input type="number" name="second_operand" placeholder="Enter b"> <br>
    <input type = "submit" id = "submit" value = "Calculator"/>
  </form>
<%--  <c:redirect url="/calculator"></c:redirect>--%>
  </body>
</html>
