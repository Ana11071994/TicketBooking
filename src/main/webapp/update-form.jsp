<%@page import="bookingEntity.BookingEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<div class="margin0-auto">
        <div class="heading">update details</div>
        <div class="sec-part ">
            <div class="margin0-auto wd-80 form1">
          
                <form action="<%=request.getContextPath() %>/update" method="post">
                  <%
            BookingEntity var=(BookingEntity) request.getAttribute("ticketlist");
       
            %>
                    <label for="uname">Enter a name :</label><br>
                 <input type="text" name="id" value="<%=var.getId()%>"><br><br>
                    <input type="text" name="name" value="<%=var.getName()%>"><br><br>
                    <label for="row">Row A-Z :</label><br>
                    <input type="text" name="row" value="<%=var.getRow()%>"><br><br>
                    <label for="seatNO">Seat No:</label><br>
                    <input type="text" name="seat" value="<%=var.getSeatNo()%>"><br><br>
                    <label for="Class">Movie Name:</label><br>
                    <input type="text" name="movie" value="<%=var.getMovieName()%>"><br><br>
                    <label for="phoneNo">phone No:</label><br>
                    <input type="text" name="phone" value="<%=var.getPhoneNo()%>"><br><br>
                    <button type="submit" value="submit">update</button>
              
                </form>
            </div>
        </div>     
    </div>

</body>
</html>