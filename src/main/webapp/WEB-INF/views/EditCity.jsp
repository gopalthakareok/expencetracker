<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<h2>Edit City</h2>
	<form action="editcity" method="post">

		CityName : <input type="text" name="cityname" /><Br>
		<br> State: <select name="stateId">
			<option>Select State</option>
			
			<c:forEach items="${stateList}" var="s">

					<option value="${s.stateId}">${s.statename }</option>
			
			</c:forEach>

		</select> <br>
		<button type="submit" class="btn btn-primary">Update City</button>
        <a href="listcity" class="btn btn-secondary">Cancel</a>

	</form>

</body>
</html>