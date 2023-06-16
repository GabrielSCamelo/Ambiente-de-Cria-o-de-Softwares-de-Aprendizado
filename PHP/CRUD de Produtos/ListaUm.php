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
        <br><br>
        <form action="ListaUm.php" method="post">
            ID do Produto: <input type="text" name="numero"><br><br>
            <input type="submit" value="Visualizar">
        </form>
        <br>
        <?php
        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $numero = $_POST["numero"];
            if (file_exists("Conteudo.txt")) {
                $arquivo = fopen("Conteudo.txt", "r") or die ("Falha Na Abertura Do Arquivo");
                $cont=0;//contador visual para mostrar cabeçalho e fechar loop de repetição antecipadamente quando encontrada informação
                while (list($Id, $Nome, $CodB, $Desc, $Valor, $Estoque, $Peso, $imagem) = fgetcsv($arquivo, 1000, ",")) {
                    if ($Id == $numero || $Id == "id") {
                        echo "<tr><td>" . $Id . "</td>";
                        echo "<td>" . $Nome . "</td>";
                        echo "<td>" . $CodB . "</td>";
                        echo "<td>" . $Desc . "</td>";
                        echo "<td>" . $Valor . "</td>";
                        echo "<td>" . $Estoque . "</td>";
                        echo "<td>" . $Peso . "</td>";
                        echo "<td>" . $imagem . "</td>";
                        echo "</tr>";
                        echo "<br>";
                        $cont++;

                        if($cont==2)
                        {
                            break;
                        }
                    }
                }
            } else {
                echo "<br><br> Arquivo Não Existe!  Criando Arquivo!";
                $arquivo = fopen("Conteudo.txt", "w");
                $Dados = "id,Nome,Codigo de Barras,Descricao,Valor,Estoque,Peso,URL Imagem\n";
                fwrite($arquivo,$Dados);
            }
            fclose($arquivo);
        }
        ?>
    </table>
</body>
</html>
