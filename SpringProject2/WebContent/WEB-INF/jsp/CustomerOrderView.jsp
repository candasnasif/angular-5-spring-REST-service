<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "controller.Customer" %>
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
Customer customer =(Customer) request.getSession().getAttribute("account");
out.println();
out.println("Username : "+customer.getUsername()+" |Customer|");
out.println("Name : "+customer.getName() + "	Surname : "+customer.getSurname());
%> --%>
<h1> Customer Order Page </h1>
<form action="CustomerPage/AllProductList" method = "post">

<input type="submit" name = "list_products" value="List All Product Types"  style="margin-top: 20px;">

</form>
<table border="1px" bordercolor="solid black">
	<TH>id</th>
      <TH>ProductName</th>
     
   
   
<c:forEach items="${products}" var="listMapview" >
    <tr>
        <td>${listMapview.id}</td>
        <td>${listMapview.productName}</td>
        
      
    </tr>
</c:forEach>
</table>
<form action="CustomerPage/OrderCreate" method="post">

		<h2>Create Order </h2>
		Product ID: <input type="text" name="order_product_id" style="margin-left: 5px;"><br>
		Number of Pieces: <input type="text" name="order_number_of_pieces" style="margin-left: 5px;"><br>
		<input type="submit" name = "create_order" value="Create Order"  style="margin-top: 20px;">
</form>

<form action="CustomerPage/AllOrders" method = "post">

		<h2>List all customer orders </h2>
		<input type="submit" name = "list_all_orders" value="List All Orders" name = check_status style="margin-top: 20px;"><br> 

</form>	

<table border="1px" bordercolor="solid black">
      <TH>OrderID</th>
      <TH>ProdocutName</th>
      <TH>Number Of Piece</th>
         <TH>Status</th>
   
   
<c:forEach items="${orders}" var="listMapview" >
    <tr>
        <td>${listMapview.orderID}</td>
        <td>${listMapview.product.productName}</td>
        <td>${listMapview.number_of_pieces}</td>
        <td>${listMapview.status}</td>
      
    </tr>
</c:forEach>

</table>


<form action="CustomerPage/CheckStatus" method = "post">

		<h2>Check Status Order </h2>
		Order ID:<input type="text" name="order_status_id" style="margin-left: 5px;" > 
		<input type="submit" name = "check_status" value="Check Status" name = check_status style="margin-top: 20px;"><br> 

</form>	
		
${status}	
<table border="1px" bordercolor="solid black">
      <TH>status</th>
      <TH>ProdocutName</th>
      <TH>Number Of Piece</th>
   
   
<c:forEach items="${status}" var="listMapview" >
    <tr>
        <td>${listMapview.status}</td>
        <td>${listMapview.product.productName}</td>
        <td>${listMapview.number_of_pieces}</td>
      
    </tr>
</c:forEach>

</table>



</body>
</html>