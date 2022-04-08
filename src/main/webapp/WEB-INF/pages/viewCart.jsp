<%-- 
    Document   : viewCart
    Created on : Jan 16, 2022, 7:00:57 PM
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
        <button onclick="location.href='/ProiectSoftware/SelectCartType'">I want more products!</button>
        <table>
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Unit</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productsInCart}" var="product">
                    <tr>
                        <td>${product.productName}</td>
                        <td>${product.price}</td>
                        <td>${product.unit}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        Total value is: ${totalValue}.
        
        <button onclick="location.href='/ProiectSoftware/Finish'">Proceed to finish payment!</button>
        
    </body>
</html>
