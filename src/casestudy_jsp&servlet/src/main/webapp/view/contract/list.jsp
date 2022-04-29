<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/4/2022
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contract List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <style>
        #header {
            background-color: teal;
            /*position: fixed;*/
        }

        #nav-bar {
            background-color: cornflowerblue;
            /*position: absolute;*/
        }

        #content {
            float: left;
        }

        #footer {
            background-color: brown;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container-fluid p-0">
    <div id="head">
        <div class="row" id="header">
            <div class="col-6 col-md-4"><img
                    src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                    width="25%" alt=""></div>
            <div class="col-md-6"><h1 id="title">Furama Manager</h1></div>
            <div class="col-md-2">huu trung</div>
        </div>
        <div class="row" id="nav-bar">
            <nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-center w-100">
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link" href="index.jsp">Home</a>
                        <a class="nav-link" href="/employees">Employee</a>
                        <a class="nav-link" href="/customers">Customer</a>
                        <a class="nav-link " href="/services">Service </a>
                        <a class="nav-link active" href="/contracts">Contract <span class="sr-only">(current)</span></a>
                    </div>
                </div>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </nav>
        </div>
    </div>
</div>
<div class="row" style="margin-left: 2%">
    <div id="contract-table">
        <h1 style="text-align: center">Contract List</h1>
        <button>
            <a href="contracts?action=contracts">Contract Home</a>
        </button>
        <button>
            <a href="/contracts?action=create">Add</a>
        </button>
        <table id="tableContract" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Contract ID</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Deposit</th>
                <th>Total Money</th>
                <th>EmployeeId</th>
                <th>CustomerId</th>
                <th>ServiceId</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="contract" items="${contracts}">
                    <tr>
                        <td><c:out value="${contract.contractId}"></c:out></td>
                        <td><c:out value="${contract.contractStartDate}"></c:out></td>
                        <td><c:out value="${contract.contractEndDate}"></c:out></td>
                        <td><c:out value="${contract.contractDeposit}"></c:out></td>
                        <td><c:out value="${contract.contractTotalMoney}"></c:out></td>
                        <td><c:forEach var="employee" items="${employees}">
                            <c:if test="${contract.employeeId == employee.employeeId}">
                                ${employee.employeeName}
                            </c:if>
                        </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="customer" items="${customers}">
                                <c:if test="${contract.customerId == customer.customerId}">
                                    ${customer.customerName}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="service" items="${services}">
                                <c:if test="${contract.serviceId == service.serviceId}">
                                    ${service.serviceName}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row" id="footer">
    <div class="col-12">huutrung@2022</div>
</div>
</body>
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
<script>
    $(document).ready(function () {
        $('#tableContract').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>
