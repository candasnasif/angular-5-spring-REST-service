<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="home/newOwner" method = "post">
		<h2>Owner Registration </h2>
		Username:<input type="text" name="owner_registration_username" style="margin-left: 5px;" > <br>
		Password: <input type="password" name="owner_registration_password" style="margin-left: 4px;"><br>
		<input type="submit" name = "owner_registration_signup" value="Sign Up" style="margin-top: 20px;">
</form>

</body>
</html>