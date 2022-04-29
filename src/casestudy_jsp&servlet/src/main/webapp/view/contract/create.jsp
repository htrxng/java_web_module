<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/4/2022
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Contract</title>
</head>
<body>
<div align="center">
<form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add new</h2>
            </caption>
            <tr>
                <th>StartDate</th>
                <td> <input type="datetime-local" name="startDate"></td>
            </tr>
            <tr>
                <th>EndDate</th>
                <td> <input type="datetime-local" name="endDate"></td>
            </tr>
            <tr>
                <th>Deposit</th>
                <td>  <input type="text" name="deposit"></td>
            </tr>
            <tr>
                <th>Total</th>
                <td>  <input type="text" name="total"></td>
            </tr>
            <tr>
                <th>EmployeeId</th>
                <td>   <input type="text" name="employeeId"></td>
            </tr>
            <tr>
                <th>CustomerId</th>
                <td>  <input type="text" name="customerId"></td>
            </tr>
            <tr>
                <th>ServiceId</th>
                <td>  <input type="text" name="serviceId"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                    <button>
                        <a href="contracts?action=contracts">Back</a>
                    </button>
                </td>
            </tr>
        </table>
</form>
</div>
</body>
</html>
