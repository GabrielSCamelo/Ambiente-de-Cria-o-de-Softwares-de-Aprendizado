<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        td{
            text-align: center;
            border-color: white;
        }
    </style>
</head>
<body class="w3-bar w3-black">
<a href="Incluir.php" class="w3-bar-item w3-button">Incluir</a>
<a href="Excluir.php" class="w3-bar-item w3-button">Excluir</a>
<a href="Alterar.php" class="w3-bar-item w3-button">Alterar</a>
<a href="ListarTodos.php" class="w3-bar-item w3-button">Lista Todos</a>
<a href="ListaUm.php" class="w3-bar-item w3-button">Lista Um</a>
<table border=1 width='100%' >
    <br><br>
    <form action="Alterar.php" method="post">
        id: <input type="text" name="id"><br><br>
        Inserir novas informações do Usuario:<br>
        Nome: <input type="text" name="Nome"><br>
        funcao: <input type="text" name="funcao"><br>
        senha: <input type="text" name="senha"><br><br>
        <input type="submit" value="Alterar">
    </form>
    <br>
    <?php
    if($_SERVER["REQUEST_METHOD"] == "POST") {
        $erro = false;
        $nome = $_POST["Nome"];
        $funcao = $_POST["funcao"];
        $senha = $_POST["senha"];
        $numero = $_POST["id"];

        if(empty ($numero))
        {
            $erro = "<br>Campo id Esta Vazio";
        }
        if(empty ($nome) && !$erro)
        {
            $erro = "<br>Campo Nome Esta Vazio";
        }
        if(empty($funcao) && !$erro)
        {
            $erro = "<br>Campo funcao Esta Vazio";
        }
        if(empty($senha) && !$erro)
        {
            $erro = "<br>Campo senha Esta Vazio";
        }
        if($erro){
            echo $erro;
        }
        else {
            $conexao = new mysqli('Localhost', 'root', '', 'faeterj3dawmanha');
            $sql = "UPDATE `Usuario` SET `funcao`= '$funcao', `senha`= '$senha',`nome`= '$nome' WHERE id = '$numero'";
            if(mysqli_query($conexao, $sql))
            {
                echo "<br> Dados Alterados Com Sucesso";
            }
            else{
                echo "<br> falha Dados nao Alterados";
            }
        }
        mysqli_close($conexao);
    }
    ?>
</table>
</body>
</html>