<%-- 
    Document   : updatestudent
    Created on : Jul 11, 2012, 8:28:42 AM
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
        <h1>Update student info</h1>
        <form name="updatestudent" action="/Helloworld/updatesave.do">
          Student number:<input type="Text" value="${student.getId()}" name="number"/>
          Student name: <input type="Text" value="${student.getUser()}" name="name"/>
          Student psw: <input type="Text" value="${student.getPsw()}" name="psw"/>
          <input type="submit" value="Update"/>
        </form>
    </body>
</html>
