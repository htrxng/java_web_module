<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/4/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div>
    <h1 style="text-align: center">Product Manager
        <c:if test="${message != null}"><p style="color: green" id="message"> ${message} </p></c:if>
    </h1>
    <button>
        <a href="/phongtros?action=create">Add</a>
    </button>
    <button>
        <a href="phongtros?action=phongtros"> Home</a>
    </button>
    <form action="/phongtros">
        <input type="hidden" name="action" value="search">
        <button type="submit">Search</button>
        <input type="number" name="maPhongTro" placeholder="mã phòng trọ...">
        <input type="text" name="ten" placeholder="tên người thuê">
        <input type="number" name="soDienThoai" placeholder="số điện thoại">
    </form>
    <table id="tablePhongTro" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Mã Phòng Trọ</th>
            <th>Tên người thuê</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Hình Thức Thanh Toán</th>
            <th>Ghi chú</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="phongtro" items="${phongtros}">
            <tr>
                <td>${phongtro.phongTroId}</td>
                <td>${phongtro.tenNguoiThueTro}</td>
                <td>${phongtro.soDienThoai}</td>
                <td>${phongtro.ngayBatDauThueTro}</td>
                <td><c:forEach var="hinhThucThanhToans" items="${hinhThucThanhToans}">
                    <c:if test="${phongtro.hinhThucThanhToanId ==  hinhThucThanhToans.hinhThucThanhToanId}">
                        ${hinhThucThanhToans.hinhThucThanhToan}
                    </c:if>
                </c:forEach></td>
                <td>${phongtro.ghiChu}</td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                            onclick="getId(${phongtro.phongTroId})">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post">
                <div class="modal-body">
                    This action can not be undone.
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="id" id="toDelete">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    function getId(id) {
        document.getElementById("toDelete").value = id;
    }
</script>
<script>
    const timeout = document.getElementById('message');
    setTimeout(hideElement, 3000) //milliseconds until timeout//
    function hideElement() {
        timeout.style.display = 'none'
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
</html>
