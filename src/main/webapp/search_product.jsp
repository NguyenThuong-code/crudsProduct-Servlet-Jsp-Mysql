<%@ page import="com.example.manageproduct.dao.ProductDAOImpl" %>
<%@ page import="com.example.manageproduct.dbconnect.DBConnect" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27/09/2022
  Time: 10:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
<div class="container">
    <h2 class="text-center text-primary">PRODUCT LIST</h2>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Describe</th>
            <th>Vendor</th>
            <th>Image</th>
            <th>Menu</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productLists}">
            <tr>
                <td>${product.id}</td>
                <td>${product.nameProduct}</td>
                <td>${product.priceProduct}</td>
                <th>${product.describe}</th>
                <th>${product.vendor}</th>
                <th><img src="${product.image}" style="width: 100px; height: 150px"></th>
                <td><a class="btn btn-warning" href="edit?id=${product.id}">Edit</a>
                    <a class="btn btn-danger" href="delete?id=${product.id}"
                       onclick="return confirm('Do you want to delete this product?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
