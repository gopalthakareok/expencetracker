<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New state</title>
</head>
<body>
<h2>State Name</h2>

<form action="savestate" method="post">
		StateName: <input type="text" name="stateName"/><br><br>
		
		<input type="submit" value="Save State" />
	</form>
<br><br>
</body>
</html>