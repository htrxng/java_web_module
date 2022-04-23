<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/4/2022
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="birthday" id="birthday"/>
                </td>
            </tr>
            <tr>
                <th>ID Card</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="20"/>
                    <p style="color: red">${error.idCard}</p>
                </td>
            </tr>
            <tr>
                <th>Salary</th>
                <td><input type="text" name="salary" id="salary" size="20">
                    <p style="color: red">${error.salary}</p>
                </td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>
                    <input type="text" name="phone" id="phone" size="20"/>
                    <p style="color: red">${error.phone}</p>
                </td>

            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="20"/>
                </td>
                <p style="color: red">${error.email}</p>

            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="20"/>
                </td>
            </tr>
            <tr>
                <th>Position</th>
                <td>
                    <select name="positionId"><c:forEach var="position" items="${positions}">
                        <option value="${position.positionId}"> ${position.positionName} </option>
                    </c:forEach></select>
                </td>
            </tr>
            <tr>
                <th>Education Degree</th>
                <td><select name="educationDegreeId">
                    <c:forEach var="educationDegree" items="${educationDegrees}">
                        <option value="${educationDegree.educationDegreeId}"> ${educationDegree.educationDegreeName}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <th>Division</th>
                <td><select name="divisionId">
                    <c:forEach var="division" items="${divisions}">
                        <option value="${division.divisionId}"> ${division.divisionName}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                    <button>
                        <a href="employees?action=employees">Back</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
