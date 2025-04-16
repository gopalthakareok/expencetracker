<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>State form</title>
</head>
<body>
  <h1>State</h1>
  <form action="savestate" method="post">
      StateName:<input type="text" name="statename"/><br><br>
      <input type="submit" value="Save State"/>
  </form>
</body>
</html>