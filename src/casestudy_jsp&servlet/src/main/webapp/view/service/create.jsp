<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/4/2022
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add new Service</h2>
            </caption>
            <tr>
                <th>Service Code</th>
                <td><input type="text" name="serviceCode" size="30">
                    <p style="color: red">${error.serviceCode}</p>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <th>Name</th>
                <td><input type="text" name="name" size="30"></td>
            </tr>
            <tr>
                <th>Area</th>
                <td><input type="text" name="area" size="20"></td>
            </tr>
            <tr>
                <th>Cost</th>
                <td><input type="text" name="cost" size="20">
                    <p style="color: red">${error.cost}</p>
                </td>
            </tr>
            <tr>
                <th>Capacity</th>
                <td><input type="number" name="capacity" size="10">
                    <p style="color: red">${error.capacity}</p>
                    </td>
            </tr>
            <tr>
                <th>Rent Type</th>
                <td>
                    <select name="rentTypeId" >
                        <c:forEach var="rentType" items="${rentTypes}">
                            <option value="${rentType.rentTypeId}">
                                ${rentType.rentTypeName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Service Type</th>
                <td>
                    <select name="serviceTypeId" >
                        <c:forEach var="serviceType" items="${serviceTypes}">
                            <option value="${serviceType.serviceTypeId}">
                                ${serviceType.serviceTypeName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Standard Room</th>
                <td><input type="text" name="standardRoom"></td>
            </tr>
            <tr>
                <th>Description Other Convenience</th>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <th>Pool Area</th>
                <td><input type="text" name="poolArea"></td>
            </tr>
            <tr>
                <th>Number of Floors</th>
                <td><input type="number" name="numberFloors">
                <p style="color: red">${error.floorNumber}</p>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                    <button>
                        <a href="services?action=services">Back</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
