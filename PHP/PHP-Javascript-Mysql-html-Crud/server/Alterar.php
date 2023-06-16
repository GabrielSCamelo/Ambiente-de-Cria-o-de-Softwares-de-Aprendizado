<?php
    header("Content-Type: application/json; charset=UTF-8");
    $func = json_decode($_POST["alterar"], false);
        $erro = false;

    $id = $func->id;
    $nome = $func->nome;
    $matr = $func->matricula;
    $funcao = $func->funcao;
    $senha = $func->senhaNova;


    $conexao = new mysqli('Localhost', 'root', '', 'faeterj3dawmanha');
    if ($senha == '') {
        $sql = "UPDATE `usuario` SET `nome`='$nome',`matricula`='$matr',`funcao`='$funcao' WHERE `id`='$id';";
    }
    else {
        $sql = "UPDATE `usuario` SET `nome`='$nome',`matricula`='$matr',`funcao`='$funcao',`senha`='$senha' WHERE `id`='$id';";
    }
    mysqli_close($conexao);
    echo '<br>Funcionário atualizado com sucesso';
?>