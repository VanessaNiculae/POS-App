
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <form action="/ProiectSoftware/EditProduct" method="get">
            <input type="text" value="${product.id}" name="productId" style="visibility: collapse; position: absolute" />
            <div>
                <label>Product name:</label>
                <input type="text" value="${product.productName}" name="productName" />
            </div>
            <div>
                <label>Price:</label>
                <input type="number" value="${product.price}" step="0.1" name="price" />
            </div>
            <div>
                <label>Unit:</label>
                <select name="unit" value="${product.unit}" id="unit" >
                    <option value="litru">Litru</option>
                    <option value="kilogram">Kilogram</option>
                    <option value="bucata">Bucata</option>
                </select>
            </div>
            <div>
                <label>Quantity: </label>
                <input type="number" value="${product.quantity}" name="quantity" />
            </div>
             <div>
                <input type="submit" value="Editeaza!" />
            </div>
        </form> 
    </body>
    </body>
</html>
