<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "controller.Owner" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> Welcome to Owner Page</h2>

<h3> Product Operations</h3>
<form action="OwnerPage" >
<input type="submit" name = "product" value="Go Product Page" name="go_product" style="margin-top: 5px;"><br>


<h3> Customer Operations</h3>
<input type="submit" value="Go Customer Page" name="go_customer" style="margin-top: 5px;"><br>




<h3> Order Operations</h3>
<input type="submit" name = "order" value="Go Order Page" name="go_order" style="margin-top: 5px;"><br>
</form>

</body>
</html>