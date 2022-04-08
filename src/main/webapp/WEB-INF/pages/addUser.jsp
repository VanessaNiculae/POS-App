<%-- 
    Document   : addUser
    Created on : Jan 16, 2022, 3:08:16 PM
    Author     : frati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/ProiectSoftware/AddUser" method="post" >
            <div>
                <label>Username: </label>
                <input type="text" name="username">
            </div>
            <div>
                <label>Password: </label>
                <input type="password" name="password">
            </div>
            <div>
                <label>Retype password: </label>
                <input type="password" name="retypePassword">
            </div>
            <div>
                <label>Type: </label>
                <select name="userType" id="userType" >
                    <option value="CASHIER">Cashier</option>
                    <option value="DIRECTOR">Director</option>
                    <option value="ADMIN">Admin</option>
                </select>
            </div>
            <div>
                <input type="submit" value="Add!" />
            </div>
        </form>
    </body>
</html>
