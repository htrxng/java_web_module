<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/4/2022
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Employee</h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="${employee.employeeId}">
            </c:if>
            <tr>
                <th>Name:</th>
                <td><input type="text" name="name" size="45"
                           value="${employee.employeeName}"></td>
            </tr>
            <tr>
                <th>Birthday</th>
                <td><input type="date" name="birthday" size="30"
                           value="${employee.employeeBirthday}"></td>
            </tr>
            <tr>
                <th>ID Card</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="${employee.employeeIdCard}"/>
                    <p style="color: red">${error.idCard}</p>

                </td>
            </tr>
            <tr>
                <th>Salary</th>
                <td><input type="text" name="salary" size="50"
                           value="${employee.salary}">
                    <p style="color: red">${error.salary}</p>
                </td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>
                    <input type="text" name="phone" size="15"
                           value="${employee.employeePhone}"
                    />
                    <p style="color: red">${error.phone}</p>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="email" size="35"
                           value="${employee.employeeEmail}"
                    />
                    <p style="color: red">${error.email}</p>
                </td>
            </tr>
            <tr>
                <th>Address</th>
                <td>
                    <input type="text" name="address" size="50"
                           value="${employee.employeeAddress}"
                    />
                </td>
            </tr>

            <tr>
                <th>Position:</th>
                <td>
                    <select name="positionId">
                        <c:forEach var="position" items="${positions}">
                            <c:if test="${employee.positionId == position.positionId}">
                                <option selected
                                        value="${position.positionId}">${position.positionName}</option>
                            </c:if>

                            <c:if test="${employee.positionId != position.positionId}">
                                <option value="${position.positionId}">${position.positionName}</option>
                            </c:if> </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Education Degree</th>
                <td>
                    <select name="educationDegreeId">
                        <c:forEach var="educationDegree" items="${educationDegrees}">
                            <c:if test="${employee.educationDegreeId==educationDegree.educationDegreeId}">
                                <option selected
                                        value="${employee.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                            </c:if>
                            <c:if test="${employee.educationDegreeId != educationDegree.educationDegreeId}">
                                <option value="${employee.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Division</th>
                <td>
                    <select name="divisionId">
                        <c:forEach var="division" items="${divisions}">
                            <c:if test="${employee.divisionId==division.divisionId}">
                                <option selected
                                        value="${employee.divisionId}">${division.divisionName}</option>
                            </c:if>
                            <c:if test="${employee.divisionId != division.divisionId}">
                                <option value="${employee.divisionId}">${division.divisionName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
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
