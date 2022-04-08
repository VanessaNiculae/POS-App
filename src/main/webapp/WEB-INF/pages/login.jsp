<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
        <link type="text/css" rel="stylesheet" href="style/loginstyle.css">
    </head>
    <body>
        <div>
        <form method="post" action="/ProiectSoftware/Login" >
            <div>
                <label>Username: </label>
                <input type="text" name="username" placeholder="Username" required/>
                
            </div>
            <div>
                <c:if test="${error_message != null}">
                    ${error_message}
                </c:if>
            </div>
            <div>
                <label>Password: </label>
                <input type="password" name="password" placeholder="Password" required/>
            </div>
            <div>
                <input class="buton" type="submit" value="Log in!"/>
            </div>
        </form>
        </div>
    </body>
</html>
