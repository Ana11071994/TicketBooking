<%@page import="bookingEntity.BookingEntity"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body class="bg-light">
	<header>
		<nav class="navbar navbar-dark bg-dark">
			<div class=container>
				<div class="text-center">
					<div class="navbar-brand fs-3 fw-bold">Movie Ticket Booking</div>
				</div>
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/"
						class="nav-link fs-3 fw-bold">User</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of User</h3>
			<hr>
			<div class="container">
				<a href="<%=request.getContextPath()%>/booking" class="btn btn-primary">Add new user</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr class="text-center">
						<th>NAME</th>
						<th>ROW</th>
						<th>SEAT</th>
						<th>MOVIE NAME</th>
						<th>PHONE NO</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				
				<%
				List<BookingEntity> bookingEntityList= (List<BookingEntity>)request.getAttribute("alldata");
				for(BookingEntity booking:bookingEntityList){ 
				%>
				<tr>
                    <td><%=booking.getName() %></td>
                    <td><%=booking.getRow() %></td>
                    <td><%=booking.getSeatNo() %></td>
                    <td><%=booking.getMovieName() %></td>
                    <td><%=booking.getPhoneNo() %></td>
                    <td class="text-center"><a href="<%=request.getContextPath() %>/edit?id=<%=booking.getId()%>"class="btn btn-primary me-3">Edit</a>
						<a href="<%=request.getContextPath() %>/delete?id=<%=booking.getId()%>"class="btn btn-primary me-3">Delete</a></td>
                </tr>
				<%
				}
				%>  
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>