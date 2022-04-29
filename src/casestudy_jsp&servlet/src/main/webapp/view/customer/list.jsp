<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/4/2022
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
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
                        <a class="nav-link active" href="/customers">Customer <span class="sr-only">(current)</span></a>
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
    <div class="row" style="margin-left: 2%">
        <div id="customer-table">
           <h1 style="text-align: center">Customer List
               <c:if test="${message != null}">
                   <p id="message" style="color: green;">${message}</p>
               </c:if></h1>
            <button>
                <a href="customers?action=customers">Customer Home</a>
            </button>
            <button>
                <a href="/customers?action=create">Add</a>
            </button>
            <form method="get" action="/customers" style="margin: 8px auto 8px 60%; border: solid chocolate" >
                <input type="hidden" name="action" value="search">
                <button type="submit">Search</button>
                <select name="customerTypeId">
                    <option value="">Choose</option>
                    <c:forEach var="customerType" items="${typeCustomers}">
                        <option value="${customerType.customerTypeId}"> ${customerType.customerTypeName} </option>
                    </c:forEach></select>
                <input type="text" name="keyWordName" placeholder="name...">
                <input type="text" name="keyWordEmail" placeholder="email... ">
            </form>
            <table id="tableCustomer" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Customer Code</th>
                    <th>Customer Type</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>ID Card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td><c:out value="${customer.customerCode}"/></td>
                        <td><c:forEach var="customerType" items="${typeCustomers}">
                            <c:if test="${customer.customerTypeId == customerType.customerTypeId}">
                                ${customerType.customerTypeName}
                            </c:if>
                        </c:forEach></td>
                        <td><c:out value="${customer.customerName}"/></td>
                        <td><c:out value="${customer.customerBirthday}"/></td>
                        <td><c:if test="${customer.customerGender == false}">FeMale</c:if>
                            <c:if test="${customer.customerGender == true}">Male</c:if>
                        </td>
                        <td><c:out value="${customer.customerIdCard}"/></td>
                        <td><c:out value="${customer.customerPhone}"/></td>
                        <td><c:out value="${customer.customerEmail}"/></td>
                        <td><c:out value="${customer.customerAddress}"/></td>
                        <td>
                            <a href="/customers?action=edit&id=${customer.customerId}">Edit</a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                                    onclick="getId(${customer.customerId})">
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
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script>
    const timeout = document.getElementById('message');
    setTimeout(hideElement, 3000) //milliseconds until timeout//
    function hideElement() {
        timeout.style.display = 'none'
    }
</script>
</html>
