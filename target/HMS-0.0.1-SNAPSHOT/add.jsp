<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<%@ page import = "lt.baltrimas.lukas.HMS.Entities.*" %>
<%@ page import = "lt.baltrimas.lukas.HMS.Hibernate.*" %>
<%@ page import = "java.util.ArrayList"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello world</title>
<link rel = "stylesheet" href = "css/bootstrap.css"></link>
</head>
<body>
	
	<%
		Hibernate_config hc = new Hibernate_config();
		ArrayList<Room> list = (ArrayList<Room>) hc.getRoomList();
			
		for(Room r : list)
		{
			
	%>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Room number</th>
				<th>Type</th>
				<th>Availability</th>
				<th>Cleanliness</th>
				<th>Customer</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th><%= r.getRoomNumber() %></th>
				<th><%= r.getType() %></th>
				<th><%= r.getIsAvaible() %></th>
				<th><%= r.getIsClean() %></th>
				<th><%= r.getCustomer() %></th>
			</tr>
		</tbody>
	</table>
	
	<% } %>
</body>
</html>