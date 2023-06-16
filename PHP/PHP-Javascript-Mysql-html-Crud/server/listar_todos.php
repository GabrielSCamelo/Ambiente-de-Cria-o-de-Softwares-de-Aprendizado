<?php

    $conexao = new mysqli('Localhost','root','','faeterj3dawmanha');
    $sql = "select * from `usuario` order by `id`";

    $result = $conexao->query($sql);

    $listaFunc = mysqli_fetch_all($result);

    echo json_encode($listaFunc);
    mysqli_close($conexao);
?>