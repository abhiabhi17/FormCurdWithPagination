<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css"> -->
<!-- <style>

.error {
	color: #FF0000
}
</style> -->


	


<!-- <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script> -->

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>

$(document).ready(function() {
    $('#example').DataTable();
   
    
} );


function confirmDelete() {
	var status = confirm("Are you sure, you want to delete?");
	if (status) {
		return true;
	} else {
		return false;
	}
}
</script>
</head>
<body>

<a href="registerUser">Add User</a>
	<table border=1>
	
	<thead>
	<tr>
	<th>S.no</th>
		<th>UserName</th>
		<th>Email</th>
		<th>PhonoNumber</th>
		<th>Country</th>
		<th>Action</th>
		
		</tr>
	
	</thead>
	
	<tbody>
	<c:forEach items="${userList}" var="user" varStatus="index">
	<tr>
	    <td>${index.count}</td>
	    <td>${user.username }</td>
	       
	    <td>${user.email }</td>
	       <td>${user.phno }</td>
	          <td>${user.country }</td>
	          <td><a href="deleteUser?userId=${user.userId}" onclick="return confirmDelete()">Delete</a>
	                   <td><a href="editUser?userId=${user.userId}" >Edit</a></td>
		
	</c:forEach>
	
   </tbody>
	</table>
	
	<c:if test="${cp>1}">
	<a href="viewUsers?pn=${cp-1}">Previous</a>
	
	</c:if>
	
	
	 <c:forEach begin="1" end="${tp}" var="i">
        <c:choose>
                   <c:when test="${cp==i }">
        
                            <c:out value="${i}"/>
                  </c:when>
                  
                  <c:otherwise>
                        <a href="viewUsers?pn=${i}">
                         <c:out value="${i}"/></a>
                  </c:otherwise>
        
        
        
        </c:choose>
	 </c:forEach> 
	 
	 
	 <c:if test="${cp<tp}">
	<a href="viewUsers?pn=${cp+1}">Next</a>
	
	</c:if>
	<%--  
	  <c:forEach begin="1" end="${tp}" var="i">
	 <a href="viewUsers?pn=${i}">
                         <c:out value="${i}"/></a>
	  
	  </c:forEach>
	   --%>
	  
	
</body>
</html>