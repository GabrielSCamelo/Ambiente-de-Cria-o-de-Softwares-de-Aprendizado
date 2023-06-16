<?php
    $id = $_POST['id'];

    $conexao = new mysqli('Localhost', 'root', '', 'faeterj3dawmanha');

    $sql = "DELETE FROM `usuario` WHERE `id` = '$id'";

    $result = $conexao->query($sql);

    mysqli_close($conexao);
?>
