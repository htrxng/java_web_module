<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/4/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <h1 class="text-center">Product Management</h1>
            <div class="justify-content-center">
                <a href="/product?action=create">
                    <button class="btn btn-primary">ADD</button>
                </a>
            </div>
            <div>
                <form method="get" action="/product" class="form-inline">
                    <input type="hidden" name="action" value="search">
                    <input type="text" name="name" class="form-control mr-sm-2" placeholder="Name's Product"
                           aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">No</th>
                <%--            <th scope="col">ID</th>--%>
                <th scope="col">Product's Name</th>
                <th scope="col">Price</th>
                <th scope="col">Description</th>
                <th scope="col">Manufacturer</th>
                <th colspan="3">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}" varStatus="no">
                <tr>
                    <th>${no.count}</th>
                    <td>${product.getNameProduct()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getDescription()}</td>
                    <td>${product.getManufacturer()}</td>
                    <td><a href="/product?action=update&id=${product.getId()}">
                        <button class="btn btn-warning" style="color: white">Update</button>
                    </a></td>
                    <td>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                                onclick="getId(${product.getId()})">
                            Remove
                        </button>
                    </td>
                        <%--            <td><a href="/product?action=remove&id=${product.getId()}">Remove</a></td>--%>
                    <td><a href="/product?action=detail&id=${product.getId()}">
                        <button class="btn btn-info" style="color: white">Detail</button>
                    </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get">
                <div class="modal-body">
                    Are you sure?
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="id" id="toDelete">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete!</button>
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
