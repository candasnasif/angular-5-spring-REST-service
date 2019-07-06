
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


<h2> Welcome to Customer Page</h2>


<form action="CustomerPage">

<h3> Order Operations</h3>
<input type="submit" name = "order_status" value="Go Order Operations" style="margin-top: 5px;"><br>



<h3> Update Account Operations</h3>
<input type="submit" name="update" value="Go Update Information Page" name="go_update_information" style="margin-top: 5px;"><br>

</form>


</body>
</html>