<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW ALL STUDENT</title>
</head>
<body>

<%@page import= "java.UserDao,java.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Users List</h1>

<%
List<User> list=UserDao.getAllRecords();
request.setAttribute("list",list);
%>

<table border="1" color = "green" width="90%">
<tr><th>Id</th>
<th>Name</th>
<th>Sex</th>
<th>Country</th>
<th>Edit</th>
<th>Delete</th></tr>
<c:forEach items="${list}" var="u">

<tr><td>${u.getId()}</td>

<td>${u.getName()}</td>

<td>${u.getPassword()}</td>

<td>${u.getSex()}</td>

<td>${u.getCountry()}</td>

<td><a href="edituser.jsp?id=$(u.getId()}">Edit</a></td>
</c:forEach>c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>



</body>
</html>