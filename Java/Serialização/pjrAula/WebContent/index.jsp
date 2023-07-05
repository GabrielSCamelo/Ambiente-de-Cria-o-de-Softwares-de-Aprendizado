<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="LoginServlet" method="post">
<input type="text" id="txt" name="txt">
<br/>

<input type="checkbox" id="vehicle" name="vehicle" value="Bike">
<label for="vehicle1"> I have a bike</label><br>
<input type="checkbox" id="vehicle" name="vehicle" value="Car">
<label for="vehicle2"> I have a car</label><br>
<input type="checkbox" id="vehicle" name="vehicle" value="Boat">
<label for="vehicle3"> I have a boat</label><br>
<input type="submit" value="Enviar">
</form>



</body>
</html>