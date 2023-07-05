<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste</title>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
    }
    form {
        margin: auto;
        width: 50%;
        border: 1px solid #ccc;
        padding: 20px;
        border-radius: 10px;
    }
    label {
        display: block;
        margin-bottom: 10px;
    }
    input[type=text], input[type=checkbox] {
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
        width: 100%;
        margin-bottom: 20px;
    }
    input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type=submit]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <form action="LoginServer" method="post">
        <label for="txt">Insira Algo:</label>
        <input type="text" id="txt" name="txt"><br>
        <label>Escolha uma opção:</label>
        <input type="checkbox" id="check1" name="check" value="Opcao 1">
        <label for="check1">Opção 1</label>
        <input type="checkbox" id="check2" name="check" value="Opcao 2">
        <label for="check2">Opção 2</label>
        <input type="checkbox" id="check3" name="check" value="Opcao 3">
        <label for="check3">Opção 3</label><br>
        <input type="submit" value="Enviar" name="botao">
    </form>
</body>
</html>
