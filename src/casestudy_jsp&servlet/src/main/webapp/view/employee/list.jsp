<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/4/2022
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Employee List</title>
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
                        <a class="nav-link active" href="/employees">Employee <span class="sr-only">(current)</span></a>
                        <a class="nav-link" href="/customers">Customer </a>
                        <a class="nav-link" href="/services">Service</a>
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
    <div class="row" style="margin-left: 0.1%">
        <div id="employee-table">
            <h1 style="text-align: center">Employee List</h1>
            <button>
                <a href="employees?action=employees">Employee Home</a>
            </button>
            <button>
                <a href="/employees?action=create">Add</a>
            </button>
            <form method="get" action="/employees" style="margin: 8px auto 8px 60%; border: solid chocolate" >
                <input type="hidden" name="action" value="search">
                <button type="submit">Search</button>
                <select name="positionId">
                    <option value="">Choose</option>
                    <c:forEach var="position" items="${positions}">
                        <option value="${position.positionId}"> ${position.positionName} </option>
                    </c:forEach></select>
                <input type="text" name="keyWordName" placeholder="name...">
                <select name="divisionId">
                    <option value="">Choose</option>
                    <c:forEach var="division" items="${divisions}">
                        <option value="${division.divisionId}"> ${division.divisionName} </option>
                    </c:forEach></select>
            </form>
            <table id="tableEmployee" class="table table-striped table-bordered" style="width: 100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>ID Card</th>
                        <th>Salary</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Position</th>
                        <th>Education Degree</th>
                        <th>Division</th>
                        <th>Username</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td><c:out value="${employee.employeeId}"/></td>
                            <td><c:out value="${employee.employeeName}"/></td>
                            <td><c:out value="${employee.employeeBirthday}"/></td>
                            <td><c:out value="${employee.employeeIdCard}"/></td>
<%--                            value="<fmt:formatNumber>${employee.salary}</fmt:formatNumber>">--%>
                            <td><fmt:formatNumber>${employee.salary}</fmt:formatNumber></td>
                            <td><c:out value="${employee.employeePhone}"/></td>
                            <td><c:out value="${employee.employeeEmail}"/></td>
                            <td><c:out value="${employee.employeeAddress}"/></td>
                            <td><c:forEach var="position" items="${positions}">
                                <c:if test="${employee.positionId == position.positionId}">
                                    ${position.positionName}
                                </c:if>
                            </c:forEach></td>
                            <td><c:forEach var="educationDegree" items="${educationDegrees}">
                                <c:if test="${employee.educationDegreeId == educationDegree.educationDegreeId}">
                                    ${educationDegree.educationDegreeName}
                                </c:if>
                            </c:forEach></td>
                            <td><c:forEach var="division" items="${divisions}">
                                <c:if test="${employee.divisionId == division.divisionId}">
                                    ${division.divisionName}
                                </c:if>
                            </c:forEach></td>
                            <td><c:out value="${employee.username}"/></td>
                            <td>
                                <a href="/employees?action=edit&id=${employee.employeeId}">Edit</a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                                        onclick="getId(${employee.employeeId})">
                                    Delete
                                </button>
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
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Do you want delete it?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get">
                <div class="modal-body">
                    This action cannot be undone.
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
        document.getElementById("toDelete").value = +id;
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
<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>
