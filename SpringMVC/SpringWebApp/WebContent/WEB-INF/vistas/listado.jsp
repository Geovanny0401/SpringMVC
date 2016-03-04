<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Usuario</title>
</head>
<body>
<h1>Listado Administradores</h1> 
<h3><a href='<c:url value="/admin"/>'>Adicionar Administadores</a></h3>  
 <c:if test="${!empty admins}">  
	<table align="left" border="1">
		<tr>
			<th>Admin ID</th>
			<th>Admin Nombre</th>
			<th>Admin Cargo</th>
			<th>Admin Fecha</th>
		</tr>	
		<c:forEach items="${admins}" var="admin">
			<tr>
				<td><c:out value="${admin.idAd}" /></td>
				<td><c:out value="${admin.nombre}" /></td>
				<td><c:out value="${admin.cargo}" /></td>
				<td><c:out value="${admin.fechaCreacion}" /></td>				
			</tr>
	</c:forEach>	
</table><br></c:if>		
</body>
</html>