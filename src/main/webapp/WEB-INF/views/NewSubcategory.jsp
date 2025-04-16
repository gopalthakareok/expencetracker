<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<h2>Sub Category form</h2>
	<form action="savesubcategory" method="post">

		SubcategoryName : <input type="text" name="subcategoryname" /><Br>
		<br> Category: <select name="categoryId">
			<option>Select Category</option>
			
			<c:forEach items="${categoryList}" var="c">

					<option value="${c.categoryId}">${c.categoryname }</option>
			
			</c:forEach>

		</select> <br>
		<br> <input type="submit" value="Save Subcategory" />

	</form>

</body>
</html>