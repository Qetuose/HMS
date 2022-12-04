<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<%@ page import = "lt.baltrimas.lukas.HMS.Entities.*" %>
<%@ page import = "lt.baltrimas.lukas.HMS.Hibernate.*" %>
<%@ page import = "java.util.ArrayList"%>
<html>
<head>
	
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Data Tables</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" ></script>

    <script
  src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" ></script>
</head>
<body>
	<div style="display: inline-flex;">
		<div style="margin: 5px">
			<table  id="roomTable">
				<thead>
					 <tr>
						<th>Room Number</th>
						<th>Type</th>
						<th>Availability</th>
						<th>Cleanliness</th>
						<th>Customer</th>
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
		<div style="margin: 5px">
			<table id = "customerTable" >
				<thead>
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
			  <%
					ArrayList<Customer> cList = (ArrayList<Customer>) hc.getCustomerList();
					for (Customer c : cList)
					{
				%>
				
				<tr>
					<td> <%= c.getId() %> </td>
					<td> <%= c.getFirst_name() %> </td>
					<td> <%= c.getLast_name() %> </td>
					<td> <%= c.getPhone() %> </td>
					<td> <%= c.getEmail() %> </td>
					<td> <%= c.getCountry() %> </td>
					<td> <%= c.getCity() %> </td>
					<td> <%= c.getAdress() %> </td>
				</tr>
		
				<% }%> 
			  </tbody>
			</table>
		</div>				
	</div>

<script>
    $(document).ready( function () {
    $('#roomTable').DataTable();
} );
    $(document).ready( function () {
        $('#customerTable').DataTable();
    } );
    </script>
</body>
</html>