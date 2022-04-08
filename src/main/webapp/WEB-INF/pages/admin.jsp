<%-- 
    Document   : admin
    Created on : Jan 15, 2022, 10:27:01 PM
    Author     : frati
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet">
    </head>
    <body>
        <button onclick="location.href = '/ProiectSoftware/AddProduct'">Add product</button>
        <div style="position: absolute; right: 10%">
            <button onclick="location.href = '/ProiectSoftware/Logout'">Logout</button>
        </div>
        <table>
            <thead>
            <th>Product Name</th>
            <th>Price</th>
            <th>Unit</th>
            <th>Quantity in store</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>
            <c:forEach items="${allProducts}" var="product">
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.unit}</td>
                    <td>${product.quantity}</td>
                    <td><input type="button" value="✏" onclick="location.href = '/ProiectSoftware/EditProduct?productId=${product.id}'" /></td>
                    <td><input type="button" value="❌" onclick="if (confirm('Are you sure you want to delete?'))
                                location.href = '/ProiectSoftware/DeleteProduct?productId=${product.id}'" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <table>
        <thead>
        <th>Transaction Date </th>
        <th>Id Cashier</th>
        <th>Id Type</th>
        <th>Value</th>
    </thead>
    <tbody>
        <c:forEach items="${allTransactions}" var="transaction">
            <tr>
                <td>${transaction.transactionDate}</td>
                <td>${transaction.idCashier.getUsername()}</td>
                <td>${transaction.idType.getType()}</td>
                <td>${transaction.value}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<button onclick="location.href = '/ProiectSoftware/AddUser'">Register User</button>
<table>
    <thead>
    <th>Username</th>
    <th>Id User Type</th>
    <th>Edit</th>
    <th>Delete</th>
</thead>
<tbody>
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.idUserType.getType()}</td>
            <td><input type="button" value="✏" onclick="location.href = '/ProiectSoftware/EditUser?userId=${user.id}'" /></td>
            <td><input type="button" value="❌" onclick="if (confirm('Are you sure you want to delete?'))
                        location.href = '/ProiectSoftware/DeleteUser?userId=${user.id}'" /></td>

        </tr>
    </c:forEach>
</tbody>
</table>
</body>
</html>
