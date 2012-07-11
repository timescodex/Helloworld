<%-- 
    Document   : addstudent
    Created on : Jul 11, 2012, 8:28:26 AM
    Author     : yang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add student</h1>
        <form name="saveform" action="/Helloworld/save.do" method="post">
            student number : <input type="text" name="number"/>
            student name : <input type="text" name="name"/>
            student psw : <input type="text" name="psw"/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
