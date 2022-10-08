<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<title>List Customers</title>
	
	<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<div id = "wrapper">
		<div id="header">
			<h2> CRM  - customer relationship manager </h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add customer button: -->
			<input type = "button" value="Add customer" onclick="window.location.href='showFormForAdd'; return false;"
									class="add-button"/>
		
		
			<!--  html table here -->
			
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop and print customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<!--  make "update" link with custy id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<!-- make "delete" link with custy id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
						
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td>
							<!--  display the update and delete link --> 
							<a href="${updateLink}">update</a>
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you wanna delete?'))) return false">delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


</body>

</html>