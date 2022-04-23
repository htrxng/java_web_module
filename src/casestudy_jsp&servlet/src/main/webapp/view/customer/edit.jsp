<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/4/2022
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Customers Management</h1>
    <%--    <h2>--%>
    <%--        <a href="customers?action=customers">List All Customers</a>--%>
    <%--    </h2>--%>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>

            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="${customer.customerId}"/>
            </c:if>
            <input type="hidden" name="customerCode" value="<c:out value="${customer.customerCode}"/>"/>
            <tr>
                <th>customerType:</th>
                <td>
                    <select name="customerTypeId">
                        <c:forEach var="customerType" items="${typeCustomers}">
                            <c:if test="${customer.customerTypeId == customerType.customerTypeId}">
                                <option selected
                                        value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                            </c:if>

                            <c:if test="${customer.customerTypeId != customerType.customerTypeId}">
                                <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                            </c:if> </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value="${customer.customerName}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="birthDay" size="45"
                           value="<c:out value="${customer.customerBirthday}" />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select name="gender">
                        <option value="0">FeMale</option>
                        <option value="1">Male</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>IdCard:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value="${customer.customerIdCard}" />"
                    />
                    <p style="color: red">${error.idCard}</p>
                </td>
            </tr>
            <tr>
                <th>customerPhone:</th>
                <td>
                    <input type="text" name="phone" size="15"
                           value="<c:out value='${customer.customerPhone}' />"
                    />
                    <p style="color: red">${error.phone}</p>
                </td>
            </tr>
            <tr>
                <th>customerEmail:</th>
                <td>
                    <input type="text" name="email" size="35"
                           value="<c:out value='${customer.customerEmail}' />"
                    />
                    <p style="color: red">${error.email}</p>
                </td>
            </tr>
            <tr>
                <th>customerAddress:</th>
                <td>
                    <input type="text" name="address" size="50"
                           value="<c:out value='${customer.customerAddress}' />"
                    />
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
