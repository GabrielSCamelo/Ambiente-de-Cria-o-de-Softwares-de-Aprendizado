<?php

    $conexao = new mysqli('Localhost', 'root', '', 'faeterj3dawmanha');

    $id = $_POST['id'];
    $marca = $_POST['marca'];
    $modelo = $_POST['modelo'];
    $qtdassentos = $_POST['qtdAssentos'];
    $temBanheiro = $_POST['temBanheiro'];
    $temArcondicionado = $_POST['temArcondicionado'];
    $chassi = $_POST['chassi'];
    $placa = $_POST['placa'];

    $sql = "INSERT INTO `onibus` (marca, modelo, qtdAssentos, temBanheiro,
                                    temArCondicionado, chassis, placa) 
                          VALUES('" . $marca . "', '" . $modelo . "', '" . $qtdassentos . "',
                                 '" . $temBanheiro . "', '" . $temArcondicionado . "',
                                 '" . $chassi . "', '" . $placa . "')";


    $sql = "UPDATE `usuario` WHERE id = $id SET `marca`='$marca',`modelo`='$modelo',`qtdassentos`='$qtdassentos',
    `temBanheiro`='$temBanheiro',`temArcondicionado`='$temArcondicionado',`chassi`='$chassi',`placa`='$placa'";

    $result = $conexao->query($sql);

    mysqli_close($conexao);
?>