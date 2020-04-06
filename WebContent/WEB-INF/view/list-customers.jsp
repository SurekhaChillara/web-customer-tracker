<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>

<!--  Link CSS here -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />


</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM- Customer Relationship Management!!</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		
		<!-- adding a new button here -->
		<input type="button" value="Add Customer"
		onclick="window.location.href='showFormForAdd';return false;"
		class="add-button"/>
		
		
			<!-- Add out HTML table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<!-- Loop over and printout the Customers  -->
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>