<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/4/2022
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Code:</th>
                <td>
                    <input type="text" name="customerCode" size="30">
                    <p style="color: red">${error.customerCode}</p>
                </td>
            </tr>
            <tr>
                <th>customerType:</th>
                <td>
                    <select name="customerTypeId"><c:forEach var="customerType" items="${typeCustomers}">
                        <option value="${customerType.customerTypeId}"> ${customerType.customerTypeName} </option>
                    </c:forEach></select>
                </td>
            </tr>
            <tr>
                <th>customerName:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>customerBirthday:</th>
                <td>
                    <input type="date" name="birthday" id="birthday"/>
                </td>
            </tr>
            <tr>
                <th>customerGender:</th>
                <td>
                    <select name="gender">
                        <option value="1">Male</option>
                        <option value="0">Female</option>
                        <%--                        <option value="-1">Others</option>--%>
                    </select>
                </td>
            </tr>
            <tr>
                <th>customerIdCard:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="20"/>
                    <p style="color: red">${error.idCard}</p>
                </td>
            </tr>
            <tr>
                <th>customerPhone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="20"/>
                    <p style="color: red">${error.phone}</p>
                </td>
            </tr>
            <tr>
                <th>customerEmail:</th>
                <td>
                    <input type="text" name="email" id="email" size="20"/>
                    <p style="color: red">${error.email}</p>
                </td>
            </tr>
            <tr>
                <th>customerAddress:</th>
                <td>
                    <input type="text" name="address" id="address" size="20"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                    <button>
                        <a href="customers?action=customers">Back</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
