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
	<h2>List of mappings</h2>
	</br>
	<table>
		<c:forEach items="${mappings}" var="mappings">
			<tr>
			<td><a href="<c:url value='${mappings}'/>">${mappings}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>