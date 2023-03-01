<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bills</title>
</head>
<body>	
	<h2>All Bills</h2>
	<hr>
	<table border="1">
		<tr>
			<th>Id</th>
			
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Product</th>
			<th>Amount</th>
			<th>Mode</th>
			
		</tr>
		
		<c:forEach var="billing" items="${Billing}">
		<tr>
			<td>${billing.id}</td>
			<td><a href="getBillById?id=${billing.id}">${billing.firstName}</a></td>
			<td>${billing.lastName}</td>
			<td>${billing.email}</td>
			<td>${billing.Mobile}</td>
			<td>${billing.product}</td>
			<td>${billing.amount}</td>
			<td>${billing.mode}</td>
		</tr>
		
		</c:forEach>
		
	</table>
	

</body>
</html>