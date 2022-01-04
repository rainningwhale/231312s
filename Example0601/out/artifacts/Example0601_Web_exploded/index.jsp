<%-- 
    Document   : index
    Created on : 2012-10-25, 13:11:34
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="./SimpleQueryServlet" method="post">
            <input type="text" name="city"/>
            <input type="submit" value="查询" />
            
        </form>
    </body>
</html>
