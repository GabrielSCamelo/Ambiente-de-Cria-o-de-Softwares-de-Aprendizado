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
        <form action="ListaUm.php" method="post">
            Inserir id: <input type="text" name="id"><br><br>
            <input type="submit" value="Visualizar">
        </form>
        <br>
        <?php
        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $erro = false;
            $numero = $_POST["id"];
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
                $sql = "SELECT * FROM `usuario` where id = '$numero'";
                $result = $conexao->query($sql);

                echo "<br><tr><td> id </td>";
                echo "<td> nome </td>";
                echo "<td> matricula </td>";
                echo "<td> funcao </td>";
                echo "<td> senha </td>";
                echo "</tr>";

                if ($result) {
                    while ($info = mysqli_fetch_assoc($result)) {
                            echo "<tr><td>" . $info['id'] . "</td>";
                            echo "<td>" . $info['nome'] . "</td>";
                            echo "<td>" . $info ['matricula'] . "</td>";
                            echo "<td>" . $info ['funcao'] . "</td>";
                            echo "<td>" . $info ['senha'] . "</td>";
                            echo "</tr>";
                    }
                    } else {
                    echo "Erro na Captura de dados";
                }
            }
            mysqli_close($conexao);
        }
        ?>
    </table>
</body>
</html>
