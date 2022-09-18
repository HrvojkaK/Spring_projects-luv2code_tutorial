<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<title>Student registrartion form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName"/>
	
	<br><br>
	
	Last name: <form:input path="lastName"/>
	
	<br><br>
	
	Country:
	
	<form:select path="country">
	
	<form:option value="Brazil" label="Brazil"/>
	<form:option value="France" label="France"/>
	<form:option value="UK" label="UK"/>
	
	</form:select>
	
	<br><br>
	
	Operating systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	MS Win <form:checkbox path="operatingSystems" value="MS Win"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
	
	<br><br>
	
	<input type="submit" value="Submit"/>
	
	</form:form>


</body>

</html>