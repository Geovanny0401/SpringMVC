<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<script type="text/javascript" src='<c:url value="/res/js/jquery.js" />'></script>
<script type="text/javascript">
jQuery(document).ready(function(){
     jQuery(".confirm").on("click",function(){
    	 return confirm("Eliminar el registro, desea Continuar?");
     	});
     });
</script>
</head>
<body>
	<h1>Admin.jsp</h1>
	<sf:form action="${pageContext.request.contextPath}/admin/save"
		method="POST" commandName="admin">
		<table>
            <tr>
            <c:if test="${admin.idAd ne 0}">
            	<td><sf:label path="idAd">Id</sf:label></td>
            	<td><sf:input path="idAd" type="text" value="${admin.idAd}" readonly="true" /></td>
            </c:if>
            </tr>     
			<tr>
				<td><sf:label path="nombre">Nombre</sf:label></td>
				<td><sf:input path="nombre" type="text" value="${admin.nombre}" /></td>
			</tr>
			<tr>
				<td><sf:label path="cargo">Cargo</sf:label></td>
				<td><sf:input path="cargo" type="text" value="${admin.cargo}"/></td>
			</tr>
			<tr>
			 <c:if test="${admin.idAd ne 0}">
				<td><sf:label path="fechaCreacion">Fecha Creacion</sf:label></td>
				<td><sf:input path="fechaCreacion" type="text" value="${admin.fechaCreacion}" 
				readonly="true"/></td>
				</c:if>
			</tr>		
			<tr>
				<td colspan="2"><input type="submit" value="Guardar" /></td>
			</tr>
		</table>
	</sf:form>
	  <c:if test="${!empty admins}">  
	<h2>Lista Administradores</h2>
	<table align="left" border="1">
		<tr>
			<th>Admin ID</th>
			<th>Admin Nombre</th>
			<th>Admin Cargo</th>
			<th>Admin Fecha</th>
			<th>Accion</th>
		</tr>
		<c:forEach items="${admins}" var="admin">
			<tr>
				<td><c:out value="${admin.idAd}" /></td>
				<td><c:out value="${admin.nombre}" /></td>
				<td><c:out value="${admin.cargo}" /></td>
				<td><c:out value="${admin.fechaCreacion}" /></td>
				<td align="center"><a
					href='<c:url value="/admin/${admin.idAd}/update"/>'>Actualizar</a>
					| <a class="confirm"
					href='<c:url value="/admin/${admin.idAd}/delete"/>'>Eliminar</a>
			</tr>
		</c:forEach>
	</table>
		<tr>
			<table align="left" border="0">
		<tr>
			<td>
			<c:out value="${resultado}"></c:out>
			</td>
		</tr>
			</table>
		</tr>
</c:if>
</body>
</html>