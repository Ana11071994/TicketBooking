<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="margin0-auto">
        <div class="heading">Ticket Booking</div>
        <div class="sec-part ">
            <div class="margin0-auto wd-80 form1">
                <form action="<%=request.getContextPath() %>/insert" method="post">
                    <label for="uname">name :</label><br>
                    <input type="text" name="name" placeholder="enter a name"><br><br>
                    <label for="row">Row A-Z :</label><br>
                    <input type="text" name="row"><br><br>
                    <label for="seatNO">Seat No:</label><br>
                    <input type="text" name="seat"><br><br>
                    <label for="Class">Movie Name:</label><br>
                    <input type="text" name="movie"><br><br>
                    <label for="phoneNo">phone No:</label><br>
                    <input type="text" name="phone"><br><br>
                    <button type="submit" value="submit">submit</button>
                </form>
            </div>
        </div>     
    </div>
</body>
</html>