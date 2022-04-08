

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Unit</th>
                    <th>Quantity in store</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
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
                <tr>
                    <th>Username</th>
                    <th>Id User Type</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allUsers}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.idUserType.getType()}</td>
                        <c:if test="${user.idUserType.getType() != 'PENDING'}" > 
                            <td><input type="button" value="✏" onclick="location.href = '/ProiectSoftware/EditUser?userId=${user.id}'" /></td>
                        </c:if>
                        <c:if test="${user.idUserType.getType() == 'PENDING'}" > 
                            <td><input type="button" value="✔" onclick="location.href = '/ProiectSoftware/AcceptUser?userId=${user.id}'" /></td>
                        </c:if>
                        <td><input type="button" value="❌" onclick="if (confirm('Are you sure you want to delete?'))
                                    location.href = '/ProiectSoftware/DeleteUser?userId=${user.id}'" /></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
