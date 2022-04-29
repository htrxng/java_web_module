<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/4/2022
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div>
    <h1 style="text-align: center">Product
        <c:if test="${message != null}">
            <p id="message" style="color: green">${message}</p>
        </c:if>
    </h1>
    <button>
        <a href="/products?action=create">Add</a>
    </button>
    <p></p>
    <table id="tableProduct" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.productId}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><fmt:formatNumber>${product.price}</fmt:formatNumber></td>
<%--                <td><c:out value="${product.price}"/></td>--%>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:forEach var="color" items="${colors}">
                    <c:if test="${product.colorId == color.colorId}">
                        ${color.colorName}
                    </c:if>
                </c:forEach></td>
                <td><c:forEach var="category" items="${categories}">
                    <c:if test="${product.categoryId == category.categoryId}">
                        ${category.categoryName}
                    </c:if>
                </c:forEach></td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                            onclick="getId(${product.productId})">
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
            <form action="">
                <div class="modal-body">
                    This action can not be undone.
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="id" id="toDelete">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete it</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        $('#tableProduct').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
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
</html>
