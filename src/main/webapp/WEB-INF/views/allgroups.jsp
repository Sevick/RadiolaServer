<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>University Enrollments</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of RadioGroups</h2>
	<table>
		<tr>
			<td>ID</td><td>Title</td><td></td>
		</tr>
		<c:forEach items="${radiogroups}" var="radiogroup">
			<tr>
			<td><a href="<c:url value='/groupedit-${radiogroup.id}-radiogroup' />">${radiogroup.id}</a></td>
			<td><a href="<c:url value='/groupedit-${radiogroup.id}-radiogroup' />">${radiogroup.name}</a></td>
			<td><a href="<c:url value='/groupdelete-${employee.ssn}-radiogroup' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newGroup' />">Add New RadioGroup</a>
</body>
</html>