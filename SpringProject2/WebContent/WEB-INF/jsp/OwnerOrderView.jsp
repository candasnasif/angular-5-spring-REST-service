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

<h1> Owner Order Page </h1>
	
<form action="OwnerPage/ViewOrder" method="post">
		<h2>View Orders Status </h2> 
		<input type="submit" value="View Orders Status" name= "view_status_order" style="margin-top: 20px;"><br> 
</form>
 <table border="1px" bordercolor="solid black">
    
      <TH>Username</th>
      <TH >OrderID</th>
      <TH>Address</th>
      <TH>productName</th>
      <TH>Number Of Pieces</th>
      <TH>Status</th>
   
<c:forEach items="${orders}" var="order" >
	
    <tr>
        
        <td>${order.customer.username}</td>
        <td>${order.orderID}</td>
        <td>${order.customer.address}</td>
        <td>${order.product.productName}</td>
        <td>${order.number_of_pieces}</td>
        <td>${order.status}</td>
    </tr>
    
</c:forEach>

</table>
<form action="OwnerPage/UpdateStatus" method = "post">
		<h2>Update Order Status </h2>
		Order ID:<input type="text" name="order_update_id" style="margin-left: 5px;"> <br>
		Username:<input type="text" name="order_update_username" style="margin-left: 5px;"> <br>
		New Status :<input type="text" name="order_update_newstatus" style="margin-left: 5px;"> <br>
		<input type="submit" value="Update Order Status"  name= update_status_order style="margin-top: 5px;"> <br>
</form>		
		


</body>
</html>