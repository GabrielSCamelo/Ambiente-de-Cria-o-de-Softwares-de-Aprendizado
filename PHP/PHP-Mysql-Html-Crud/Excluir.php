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
        <form action="Excluir.php" method="post">
            id: <input type="text" name="numero"><br><br>
            <input type="submit" value="Excluir">
        </form>
        <br>
        <?php
        if($_SERVER["REQUEST_METHOD"] == "POST" ) {
            $numero = $_POST["numero"];
            $erro = false;
            if (empty($numero))
            {
                $erro = "<br>Campo Matricula esta Vazio.";
            }
            if($erro)
            {
                echo $erro;
            }
            else {
                $conexao = new mysqli('Localhost', 'root', '', 'faeterj3dawmanha');
                $sql = "DELETE FROM `usuario` WHERE `id` = '$numero'";
                if(mysqli_query($conexao, $sql))
                {
                    echo "<br> Dados excluidos Com Sucesso";
                }
                else
                {
                    echo "<br> falha na exclusão dos dados";
                }
            }
            mysqli_close($conexao);
        }
        ?>
    </table>
</body>
</html>