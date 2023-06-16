 <?php
     header("Content-Type: application/json; charset=UTF-8");
     $func = json_decode($_POST["incluir"], false);

     $nome = $func->nome;
     $matr = $func->matricula;
     $funcao = $func->funcao;
     $senha = $func->senha;

    $conexao = new mysqli('Localhost','root','','faeterj3dawmanha');
    $sql = $sql = "INSERT INTO `usuario`(`nome`, `matricula`, `funcao`, `senha`) VALUES ('$nome', '$matr', '$funcao', '$senha')";
    mysqli_query($conexao, $sql);
    echo '<br>Funcionário ' . $nome . ' inserido com sucesso.';
    mysqli_close($conexao);
?>