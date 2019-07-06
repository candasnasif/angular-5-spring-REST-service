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

<form action="OwnerPage/ProductCreate" method="post">
		<h2>Create Product </h2>
		Product Name: <input type="text" name="product_name" style="margin-left: 5px;"><br>
		<input type="submit" value="Create Product" name="create_product" style="margin-top: 20px;">
</form>		
<form action="OwnerPage/ProductDelete" method="post">
		<h2>Delete Product </h2>
		Product ID:<input type="text" name="product_delete_id"> <br>
		<input type="submit" value="Delete Product" name="delete_product" style="margin-top: 20px;"><br> 
</form>		
<form action="OwnerPage/ProductUpdate" method="post">
		<h2>Update Product </h2> 
		Product ID:<input type="text" name="product_update_id" style="margin-left: 5px;"> <br>
		Product Name: <input type="text" name="product_update_name" style="margin-left: 5px;"><br>
		<input type="submit" value="Update Product" name="update_product" style="margin-top: 20px;"><br> 
</form>	
<form action="OwnerPage/ProductList" method="post">		
		<h2>List Product </h2>
		<input type="submit" value="List Product" name="list_product" style="margin-top: 5px;"><br>
</form>	
	


</body>
<table border="1px" bordercolor="solid black">
      <TH>ID</th>
      <TH>Product</th>
   
<c:forEach items="${products}" var="listMapview" >
    <tr>
        <td>${listMapview.id}</td>
        <td>${listMapview.productName}</td>
    </tr>
</c:forEach>

</table>
</html>