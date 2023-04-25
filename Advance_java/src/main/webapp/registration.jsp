<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@page import="java.UserDao"%>
  <jsp:useBean id="u" class= java.User></jsp:useBean>
    <jsp:setProperty property="*" name="u"/>
    
    <%
    int i=UserDao.save(u);
    if (i>0){
    response.sendRedirect("registration-success.jsp");
    }else{
    response.sendRedirect("registrtion-error.jsp");
    }
    %>