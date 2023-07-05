<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Minha página com CSS</title>
	<style>
		body {
			font-family: Arial, Helvetica, sans-serif;
			background-color: #f0f0f0;
			font-family: Arial, sans-serif;
			font-size: 16px;
			line-height: 1.5;
			margin: 0;
			padding: 0;
		}
		h1 {
			font-size: 24px;
			margin-top: 20px;
			margin-bottom: 10px;
		}
		p {
			margin-bottom: 20px;
		}
		.container {
			max-width: 800px;
			margin: 0 auto;
			padding: 20px;
		}
		.texto {
			font-size: 18px;
			font-weight: bold;
			color: #333;
			margin-bottom: 10px;
		}
		.opcao {
			margin-left: 20px;
			color: #666;
		}
	</style>
</head>
<%
	String txt = (String) session.getAttribute("txt");
	String check[] =  (String[]) session.getAttribute("check");
%>
<body>
	<div class="container">
		<h1>Minha página com CSS</h1>
		<p class="texto">Seu texto é:</p>
		<p><%=txt %></p>
		<p class="texto">Suas opções são:</p>
		<ul>
			<% for(String i: check){ %>
				<li class="opcao"><%=i %></li>
			<%}%>
		</ul>
	</div>
</body>
</html>