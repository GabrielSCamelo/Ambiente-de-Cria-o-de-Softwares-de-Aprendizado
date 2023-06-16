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
        <form action="Incluir.php" method="post"><br><br>
            Nome: <input type="text" name="Nome"><br>
            funcao: <input type="text" name="funcao"><br>
            senha: <input type="text" name="senha"><br>
            matricula: <input type="text" name="matricula"><br><br>
            <input type="submit" value="Incluir">
        </form>
        <br>
    <?php
    if($_SERVER["REQUEST_METHOD"] == "POST") {
        $erro = false;
        $result = false;
        $nome = $_POST["Nome"];
        $funcao = $_POST["funcao"];
        $matricula = $_POST["matricula"];
        $senha = $_POST["senha"];

        if(empty($nome))
        {
            $erro = "<br>o Campo Nome esta vazio";
        }
        if(empty($funcao) && !$erro)
        {
            $erro = "<br>o Campo funcao esta vazio";
        }
        if(empty($senha) && !$erro){
            $erro = "<br>o Campo senha esta vazio";
        }
        if(empty($matricula) && !$erro){
            $erro = "<br>o Campo matricula esta vazio";
        }
        if($erro)
        {
            echo $erro;
        }
        else {
            $conexao = new mysqli('Localhost','root','','faeterj3dawmanha');
            $sql = "SELECT * FROM usuario where id";
            $result = $conexao->query($sql);
            if($result) {
                $sql = "INSERT INTO `usuario`(nome, matricula, funcao, senha) VALUES ('$nome','$matricula','$funcao','$senha')";
            }

                if (mysqli_query($conexao, $sql)) {
                    echo "Dados Inseridos Com Sucesso";
                } else {
                    echo "Falha Ao Inserir Dados";
                }
        }
        mysqli_close($conexao);
    }
    ?>
    </table>
</body>
</html>