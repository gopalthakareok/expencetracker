<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List State</title>
</head>
<body>
<h2>List State</h2>
<table border="1">

		<c:forEach items="${stateList}" var="s">

			<tr>
				<td>${s.stateName }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>