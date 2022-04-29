<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/4/2022
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<form method="post">
    <table border="1" cellpadding="5">
        <caption><h3> Phòng trọ mới</h3></caption>
        <tr>
            <th>Tên người thuê trọ</th>
            <td><input type="text" name="name" size="50"></td>
        </tr>
        <tr>
            <th>Số điện thoại</th>
            <td><input type="text" name="phone" size="20"></td>
        </tr>
        <tr>
            <th>Ngày bắt đầu thuê trọ
            </th>
            <td><input type="date" name="date_start" > </td>
        </tr>
        <tr>
            <th>Hình thức thanh toán</th>
            <td>
                <select name="hinhThucThanhToanId">
                <c:forEach var="hinhThucThanhToan" items="${hinhThucThanhToans}">
                    <option value="${hinhThucThanhToan.hinhThucThanhToanId}">
                        ${hinhThucThanhToan.hinhThucThanhToan}
                    </option>
            </c:forEach>
                </select></td>
        </tr>
        <tr>
            <th>Ghi chú</th>
            <td><input type="text" name="note"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Save">
                <button>
                    <a href="phongtros?action=phongtros">Back</a>
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
