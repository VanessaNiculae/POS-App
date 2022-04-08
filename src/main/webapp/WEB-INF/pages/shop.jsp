<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link type="text/css" rel="stylesheet" href="style/shopstyle.css">
    </head>
    <body>
        <table>
            <thead>
                <th>Nume produs</th>
                <th>Pret</th>
            </thead>
            <tbody>
                 <c:forEach items="${allProducts}" var="product">
                     <tr>
                         <td>${product.productName}</td>
                         <td>${product.price}</td>
                     </tr>
                 </c:forEach>
            </tbody>
            
        </table>
       
      
    </body>
</html>
