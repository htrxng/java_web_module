<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/4/2022
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Service List</title>
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
                        <a class="nav-link active" href="/services">Service <span class="sr-only">(current)</span></a>
                        <a class="nav-link" href="/contracts">Contract</a>
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
    <div id="service-table">
        <h1 style="text-align: center">Service List</h1>
        <button>
            <a href="services?action=services">Service Home</a>
        </button>
        <button>
            <a href="/services?action=create">Add</a>
        </button>
        <table id="tableService" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Service Code</th>
                <th>Name</th>
                <th>Area</th>
                <th>Cost</th>
                <th>Capacity</th>
                <th>Rent Type</th>
                <th>Service Type</th>
                <th>Standard Room</th>
                <th>Other Convenience</th>
                <th>Pool Area</th>
                <th>Number of floors</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="service" items="${services}">
                <tr>
                    <td><c:out value="${service.serviceCode}"></c:out></td>
                    <td><c:out value="${service.serviceName}"></c:out></td>
                    <td><c:out value="${service.serviceArea}"></c:out></td>
                    <td><fmt:formatNumber>${service.serviceCost}</fmt:formatNumber></td>
<%--                    <td><c:out value="${service.serviceCost}"></c:out></td>--%>
                    <td><c:out value="${service.serviceMaxPeople}"></c:out></td>
                    <td><c:forEach var="rentType" items="${rentTypes}">
                        <c:if test="${service.rentTypeId == rentType.rentTypeId}">
                            ${rentType.rentTypeName}
                        </c:if>
                    </c:forEach></td>
                    <td><c:forEach var="serviceType" items="${serviceTypes}">
                        <c:if test="${service.serviceTypeId == serviceType.serviceTypeId}">
                            ${serviceType.serviceTypeName}
                        </c:if>
                    </c:forEach></td>
                    <td><c:out value="${service.standardRoom}"></c:out></td>
                    <td><c:out value="${service.descriptionOtherConvenience}"></c:out></td>
                    <td><c:out value="${service.poolArea}"></c:out></td>
                    <td><c:out value="${service.numberOfFloors}"></c:out></td>
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
        $('#tableService').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>
