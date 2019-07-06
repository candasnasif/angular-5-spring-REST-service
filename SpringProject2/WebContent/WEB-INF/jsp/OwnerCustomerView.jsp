<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "controller.Owner" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%
Owner owner =(Owner) request.getSession().getAttribute("account");
out.println();
out.println("Username : "+owner.getUsername()+" |Owner|");
%> --%>
<form action="OwnerPage/CustomerView" method="post">
	
		<h2>Create Customer </h2>
		Customer Username:<input type="text" name="customer_username" style="margin-left: 5px;" > <br>
		Customer Password: <input type="password" name="customer_password" style="margin-left: 5px;"><br>
		Customer Name:<input type="text" name="customer_name" style="margin-left: 5px;" > <br>
		Customer Surname: <input type="text" name="customer_surname" style="margin-left: 5px;"><br>
		Customer Address: <input type="text" name="customer_address" style="margin-left: 5px;"><br>
		<input type="submit" name="create customer"  value="Create Customer" style="margin-top: 20px;">
		
		<h2>Edit Customer </h2>
		Enter Customer Username: <input type="text" name="edit_username" style="margin-left: 5px;"><br>
		New Password: <input type="password" name="new_password" style="margin-left: 5px;"><br>
		New Name:<input type="text" name="new_name" style="margin-left: 5px;" > <br>
		New Surname: <input type="text" name="new_surname" style="margin-left: 5px;"><br>
		New Address: <input type="text" name="new_address" style="margin-left: 5px;"><br>
		<input type="submit" name="edit customer" value="Edit Customer" style="margin-top: 20px;"><br> 
		
		<h2>List Customer </h2>
		<input type="submit" name="list customer" value="List Customer" style="margin-top: 20px;"><br> 
</form>
	
</body>
 <table border="1px" bordercolor="solid black">
      <TH >Username</th>
      <TH>Password</th>
      <TH>Name</th>
      <TH>Surname</th>
      <TH>Address</th>
   
<c:forEach items="${customers}" var="listMapview" >
    <tr>
        <td>${listMapview.username}</td>
        <td>${listMapview.password}</td>
        <td>${listMapview.name}</td>
        <td>${listMapview.surname}</td>
        <td>${listMapview.address}</td>
        
    </tr>
</c:forEach>

</table>
</html>