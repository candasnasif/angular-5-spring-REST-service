<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "controller.Customer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%
Customer customer =(Customer) request.getSession().getAttribute("account");
out.println();
out.println("Username : "+customer.getUsername()+" |Customer|");
out.println("Name : "+customer.getName() + "	Surname : "+customer.getSurname());
%> --%>
	<h2>Update Informations </h2>
	<form action="CustomerPage/UpdateInformation" method = "post">
		Change Password:<input type="password" name="change_password" style="margin-left: 5px;" > 
		Change Name <input type="text" name="change_name" style="margin-left: 5px;"><br>
		Change Surname <input type="text" name="change_surname" style="margin-left: 5px;"><br>
		Change Address <input type="text" name="change_address" style="margin-left: 5px;"><br>
		<input type="submit" value="Update Information" name="update_information" style="margin-top: 20px;">
		</form>
	
</body>
</html>