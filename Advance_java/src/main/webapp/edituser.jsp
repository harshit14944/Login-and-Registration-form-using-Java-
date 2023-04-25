<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@page import="java.UserDao"%>
   <jsp:usejava id="u" class="java.User"></jsp:usejava>
   <jsp:setProperty property="*" name="u"/>
   <%
   int i=UserDao.update(u);
   response.sendRedirect("viewStudent.jsp");
   %>