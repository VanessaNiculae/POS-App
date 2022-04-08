<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="style/addproductstyle.css">

    </head>
    <body>
        <form action="/ProiectSoftware/AddProduct" method="get">
            <div>
                <label>Product name:</label>
                <input type="text" name="productName" />
            </div>
            <div>
                <label>Price:</label>
                <input type="number" step="0.1" name="price" />
            </div>
            <div>
                <label>Unit:</label>
                <select name="unit" id="unit" >
                    <option value="litru">Litru</option>
                    <option value="kilogram">Kilogram</option>
                    <option value="bucata">Bucata</option>
                </select>
            </div>
            <div>
                <label>Quantity: </label>
                <input type="number" name="quantity" />
            </div>
             <div>
                <input type="submit" value="Adauga!" />
            </div>
        </form> 
    </body>
</html>
