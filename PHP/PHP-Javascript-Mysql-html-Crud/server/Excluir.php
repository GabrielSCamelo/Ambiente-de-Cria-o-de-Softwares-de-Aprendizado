<?php
    header("Content-Type: application/json; charset=UTF-8");
    $func = json_decode($_POST["excluir"], false);

    $matr = $func->matricula;

    $conexao = new mysqli('Localhost', 'root', '', 'faeterj3dawmanha');
    $sql = "DELETE FROM `usuario` WHERE `matricula` = '$matr'";
    mysqli_close($conexao);
    echo '<br>Funcionário excluído com sucesso.';
?>
