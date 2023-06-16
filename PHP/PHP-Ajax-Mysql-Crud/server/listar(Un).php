<?php
    $id = $_POST['id'];

    $conexao = new mysqli('Localhost', 'root', '', 'faeterj3dawmanha');

    $sql = "select * from `usuario` where `id`='$id'";
    $result = $conexao->query($sql);

    if($result)
    {
        $info = mysqli_fetch_assoc($result);
        echo json_encode(["MSG"=>"<table><tr><td>"
                . $info['id'] . "</td><td>"
                . $info['marca'] . "</td><td>"
                . $info['modelo'] . "</td><tb>"
                . $info['qtdAssentos'] . "</td><td>"
                . $info['temBanheiro'] . "</td><td>"
                . $info['temArCondicionado'] . "</td><td>"
                . $info['chassis'] . "</td><td>"
                . $info['placa'] .
                "</td><td></table>"]);
    }else{
        echo json_encode(["MSG"=>"Nao tem Dados Para se exibir"]);
    }
    mysqli_close($conexao);
?>

