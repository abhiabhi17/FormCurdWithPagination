<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.error {
	color: #FF0000
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				username : 'required',
				password : 'required',
				email : {
					required : true,
					email : true
				},
				phno : 'required',
				country:'required'
			},
			messages : {
				username : 'Please enter username',
				password : 'please enter password',
				email : 'Please enter valid email',
				phno : 'please enter phone number',
				country:'please enter country'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
	<font color='green'>${succMsg}</font>

	<h2>Edit And Update Form</h2>
	<form:form action="updateUser?userId=${user.userId}" method="POST" modelAttribute="user"
		id="userRegForm">
		<table>
			<tr>
				<td>Username</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="phno" /></td>
			</tr>
			
			
			<tr>
			<td>Country</td>
			<td>
			<form:select  path="country">
   <form:option value="NONE" label="--- Select ---"/>
   <form:options items="${countryList}" />
</form:select>
</td>
			</tr>
			
			
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
</table>
	<a href="viewUsers">Go to users List</a>
	</form:form>
	
	
</body>
</html>