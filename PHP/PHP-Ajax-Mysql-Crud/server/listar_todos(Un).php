<?php
    $conexao = new mysqli('Localhost','root','','faeterj3dawmanha');
    $sql = "select * from `onibus` order by `id`";

    $result = $conexao->query($sql);

    if($result) {
        echo "<tr><td> id </td>";
        echo "<td> marca </td>";
        echo "<td> modelo </td>";
        echo "<td> Total_Assentos </td>";
        echo "<td> Banheiro </td>";
        echo "<td> Ar_Condicionado </td>";
        echo "<td> Chassi </td>";
        echo "<td> Placa </td>";
        echo "</tr>";

        while ($info = mysqli_fetch_assoc($result)) {

            echo "<tr><td>" . $info['id'] . "</td>";
            echo "<td>" . $info['marca'] . "</td>";
            echo "<td>" . $info['modelo'] . "</td>";
            echo "<td>" . $info['qtdAssentos'] . "</td>";
            echo "<td>" . $info['temBanheiro'] . "</td>";
            echo "<td>" . $info['temArCondicionado'] . "</td>";
            echo "<td>" . $info['chassis'] . "</td>";
            echo "<td>" . $info['placa'] . "</td>";
            echo "</tr>";
        }
    }else{
        echo "Nao Tem conteudo no Banco.";
    }
    mysqli_close($conexao);
?>