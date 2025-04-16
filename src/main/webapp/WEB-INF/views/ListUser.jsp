<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
</head>
<body>
<table border="1">
				<tr>
					<th>User Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Contact Number</th>
					<th>Email Address</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>Role Id</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.userId}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.gender}</td>
						<td>${user.contactNumber}</td>
						<td>${user.email}</td>
						<td>${user.address}</td>
						<td>${user.city}</td>
						<td>${user.state}</td>
						<td>${user.roleId}</td>
						<td><a href="deleteuser?userId=${user.userId}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
<br>
<a href="newuser">Add User</a>
</body>
</html>