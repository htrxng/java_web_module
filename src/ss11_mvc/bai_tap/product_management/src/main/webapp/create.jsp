<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/4/2022
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="col-8 mx-auto">
    <div class="mx-auto shadow-lg p-3 mb-5 bg-white rounded-lg">
        <form method="post">
            <fieldset class="w-75 mx-auto">
                <legend class="text-center my-4"><span
                        class="text-secondary">Add new product</span>
                </legend>
                <div class="col-sm-12">
                    <label class="form-label" for="name">Name of Product</label>
                    <input class="form-control" type="text" id="name" name="name"> <br>
                    <span style="color:red;">${error.get("name")}</span>
                </div>
                <div class="col-sm-12">
                    <label class="form-label" for="price">Price</label>
                    <input type="number" class="form-control" id="price" name="price"> <br>
                </div>
                <div class="col-sm-12">
                    <label class="form-label" for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description">
                </div>
                <div class="col-sm-12">
                    <label class="form-label" for="manufacturer">Manufacturer</label>
                    <input type="text" class="form-control" id="manufacturer" name="manufacturer">
                </div>
            </fieldset>
            <div class="text-center">
                <button type="submit" class="btn btn-primary mt-4 mx-2">Add</button>
                <a href="/product">
                    <button class="btn btn-secondary mt-4 mx-2" type="button"> Back</button>
                </a>
            </div>
        </form>
    </div>
</div>
</body>
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
