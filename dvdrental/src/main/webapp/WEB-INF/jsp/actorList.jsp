<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actor List</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
</head>
<body>
	<center>
		<b>Actor List</b>
		<table border="1">
			<tr>
				<td class="heading">Actor Id</td>
				<td class="heading">First Name</td>
				<td class="heading">Last Name</td>
				<td class="heading">Last Modified</td>
				<td class="heading">Edit</td>
				<td class="heading">Delete</td>
			</tr>
			<c:forEach var="actor" items="${actorlist}">
				<tr>
					<td>${actor.id}</td>
					<td>${actor.firstName}</td>
					<td>${actor.lastName}</td>
					<td>${actor.lastModified}</td>
					<td><a href="editactorPage.html?id=${actor.id}">Edit</a></td>
					<td><a href="deleteactor.html?id=${actor.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7"><a href="addActorsPage.html">Add New User</a></td>
			</tr>
		</table>

	</center>
</body>
</html>