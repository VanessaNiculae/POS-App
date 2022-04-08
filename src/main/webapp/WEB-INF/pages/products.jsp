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
        <div>
            <button onclick="location.href='/ProiectSoftware/ViewCart'">View cart</button>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Unit</th>
                    <th>Quantity in store</th>
                    <th>Add to cart</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allProducts}" var="product">
                    <tr>
                        <td>${product.productName}</td>
                        <td>${product.price}</td>
                        <td>${product.unit}</td>
                        <td>${product.quantity}</td>
                        <td><input type="button" value="🛒" onclick="location.href = '/ProiectSoftware/AddToCart?productId=${product.id}'" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
