<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Temperatura por Latitude e Longitude</title>
	<style>
		body {
			background-color: #1A1388;
			font-family: Arial, sans-serif;
		}
		h1 {
			text-align: center;
		}
		form {
			display: flex;
			flex-direction: column;
			align-items: center;
			margin-top: 50px;
		}
		label {
			margin-bottom: 10px;
		}
		input {
			padding: 10px;
			margin-bottom: 20px;
			border-radius: 5px;
			border: none;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
			font-size: 16px;
			width: 100%;
			max-width: 400px;
			box-sizing: border-box;
		}
		button {
			padding: 10px 20px;
			border: none;
			background-color: #4CAF50;
			color: white;
			border-radius: 5px;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
			font-size: 16px;
			cursor: pointer;
			transition: background-color 0.3s ease;
		}
		button:hover {
			background-color: #3E8E41;
		}
		p {
			margin-top: 20px;
			font-size: 24px;
			font-weight: bold;
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Temperatura por Latitude e Longitude</h1>
	<form method="post" action="/temperatura">
		<label for="latitude">Latitude:</label>
		<input type="text" id="latitude" name="latitude" placeholder="Insira a latitude..." required>
		<label for="longitude">Longitude:</label>
		<input type="text" id="longitude" name="longitude" placeholder="Insira a longitude..." required>
		<button type="submit">Buscar temperatura</button>
	</form>
	<p></p>
</body>
</html>