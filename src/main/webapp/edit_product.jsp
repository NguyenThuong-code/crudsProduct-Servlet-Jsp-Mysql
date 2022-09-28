<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/09/2022
  Time: 10:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Product Management</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<br>
<div class="container col=md-6">
    <div class="card">
        <div class="card-body">
            <form action="/update" method="post">
                <h2 class="text-center text-primary">EDIT PRODUCT</h2>
                <input type="hidden" name="id" value="${product.id}">

            <fieldset class="form-group">
                <label>Name</label>
                <input class="form-control" type="text" value="${product.nameProduct}" name="nameProduct" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Price</label>
                <input class="form-control" type="text" value="${product.priceProduct}" name="priceProduct" required="required">
            </fieldset>
            <fieldset class="form-group">
                <label>Describe</label>
                <input class="form-control" type="text" value="${product.describe}" name="describe" required="required">
            </fieldset>
            <fieldset class="form-group">
                <label>Vendor</label>
                <input class="form-control" type="text" value="${product.vendor}" name="vendor" required="required">
            </fieldset>
            <fieldset class="form-group">
                <label>Image</label>
                <input class="form-control" type="text" value="${product.describe}" name="image" required="required">
            </fieldset>
            <div class="col text-center mt-3">
                <button type="submit" class="btn btn-success">EDIT</button>
            </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>
