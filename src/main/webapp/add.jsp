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
		
		<!-- CSS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tablePen.css" />
		<link rel = "stylesheet" href ="${pageContext.request.contextPath}/css/bootstrap.css"/>
		
		<!-- JS -->
		<script type="text/javascript" src = "${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<script type="text/javascript" src = "${pageContext.request.contextPath}/js/add.js"></script>
		<script type="text/javascript" src = "https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	</head>
	<body>
		<div class = "container">
			<div class = "roomTable_container">
				<table class = "table">
					<thead class="thead-dark">
						<tr>
							<th >Room Number</th>
							<th >Type</th>
							<th >Availability</th>
							<th >Cleanliness</th>
							<th >Customer</th>
						</tr>
					  </thead>
					  <tbody>
						  <% 
						  	Hibernate_config hc = new Hibernate_config();
		
							ArrayList<Room> list =  (ArrayList<Room>) hc.getRoomList();
							
							for(Room r : list)
							{
						  %>
						 
						  	<tr>
						  	  <td><%=r.getRoomNumber()%></td>
						  	  <td><%=r.getType()%></td>
						  	  <td><%=r.getIsAvaible()%></td>
						  	  <td><%=r.getIsClean()%></td>
						  	  <%
						  	  	if(r.getCustomer() != null)
						  		  {
						  	  %>
						  	  		<td><%= r.getCustomer().getId()%></td>
						  	  	<%
						  		  }
						  	  		else
						  	  		{
						  	  		%> <td>Room is empty</td>
						  	  	<% } %>
						  		
						  	  
						  	</tr>
						  <% } %>
					  </tbody>
					</table>
				</div>
				<div class = "customerTable_container">
					<table class = "table">
						<thead class="thead-dark">
						<tr>
							<th >ID</th>
							<th >First Name</th>
							<th >Last Name</th>
							<th >Phone Number</th>
							<th >Email</th>
							<th>Country</th>
							<th>City</th>
							<th>Address</th>
						</tr>
					  </thead>
					  <tbody>
					  	
					  </tbody>
					</table>
				</div>
			</div>
	<!-- 		End of Container -->	
	</body>
</html>