<%-- 
    Document   : showstudent
    Created on : Jul 11, 2012, 8:28:09 AM
    Author     : yang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page language="java" import="java.util.*" %>   
<%@page import="com.mvc.entity.Student"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<Student> st= (List<Student>)request.getAttribute("users");
%>
    <body>
        <h1>show the student data:</h1>
        <form name="searchform" action="/Helloworld/zhujie/search.do" method="post">
            <input type="text" placeholder="search content" name="search_sid"/>
            <input type="submit" value="search"/>
        </form>
        <form name="addform" action="/Helloworld/zhujie/add.do" method="post">
             <input type="submit" value="Add student">
        </form>
        <table>
           <tr>
               <td>number
               </td>
               <td>name
               </td>
               <td>password
               </td>
           </tr>
           <% for(Student s: st){ %>
   				<tr>
   					<td><%=s.getId()%></td>
   					<td><%=s.getUser() %></td>
   					<td><%=s.getPsw() %></td>
   				</tr>
   	  <% } %>
       <table>
           
       <form name="updateform" action="/Helloworld/zhujie/update.do" method="post">
           update number : <input type="Text" name="sid"/>
           <input type="submit" value="Update">
       </form>
       <form name="deleteform" action="/Helloworld/zhujie/delete.do" method="post">
           delete number : <input type="Text" name="sid"/>
           <input type="submit" value="Delete">
       </form> 
    </body>
</html>
