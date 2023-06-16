<?php
    header("Content-Type: application/json; charset=UTF-8");
    $obj = json_decode($_GET["matr"], false);

    $matr = $obj->matricula;

    $conexao = new mysqli('Localhost', 'root', '', 'faeterj3dawmanha');


    $sql = "select * from `usuario` where `matricula` = '$matr' order by `id`";
    $result = $conexao->query($sql);

    if(!$result)
    {
        echo "Funcionário não cadastrado.";
    }else{
        $listaFunc = mysqli_fetch_all($result);

        echo json_encode($listaFunc);
    }
    mysqli_close($conexao);
?>

