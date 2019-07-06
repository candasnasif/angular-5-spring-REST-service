<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/home"  method ="post">
<h2>Login Page </h2>
	    Username:<input type="text" name="user_username" style="margin-left: 5px;" > <br>
		Password: <input type="password" name="user_password" style="margin-left: 5px;"><br>
		<input type="submit" name="Login" value="Login" style="margin-top: 20px;">

</form>	
<form action="register"  method ="post">	
		<input type="submit" name = "CustomerRegister" value="Register as Customer" style="margin-top: 20px;">
		<input type="submit" name = "OwnerRegister" value="Register as Owner" style="margin-top: 20px;">
</form>

</body>
</html>