<%-- 
    Document   : cashier
    Created on : Jan 15, 2022, 10:27:21 PM
    Author     : frati
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div>
            <button onclick="location.href='/ProiectSoftware/SelectCartType?type=sale'">Sale!</button>
        </div>
        <div>
            <button onclick="location.href='/ProiectSoftware/SelectCartType?type=rental'">Rental!</button>
        </div>
        <div>
            <button onclick="location.href='/ProiectSoftware/SelectCartType?type=return'">Return!</button>
        </div>
       
    </body>
</html>
