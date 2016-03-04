<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<!-- http://docs.spring.io/spring/docs/current/spring-framework-reference/html/view.html -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
     <h1>Index.jsp</h1>
     
     <a href='<c:url value="/about"/>'>Acerca</a>
     <br/>
     <a href='<c:url value="/admin"/>'>Admin</a>
     <br/>
     <a href='<c:url value="/listado"/>'>Listado</a>
     <br/>
      <c:out value="${adminform}"></c:out>
      
      
</body>
</html>