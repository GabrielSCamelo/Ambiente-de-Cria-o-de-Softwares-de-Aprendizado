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
    <form action="Alterar.php" method="post">
        ID do Produto: <input type="text" name="numero"><br><br>
        Inserir novas informações do Produto:<br>
        Nome: <input type="text" name="Nome"><br>
        Codigo De Barra: <input type="text" name="CodB"><br>
        Descrição: <input type="text" name="Desc"><br>
        Valor: <input type="text" name="Valor"><br>
        Estoque: <input type="text" name="Estoque"><br>
        Peso: <input type="text" name="Peso"><br>
        URL-Imagem: <input type="text" name="Imagem"><br><br>
        <input type="submit" value="Alterar">
    </form>
    <br>
    <?php
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $numero = $_POST["numero"];
        if (file_exists("Conteudo.txt")) {
            $temp = fopen("Temp.txt", "w") or die ("Erro Na Criação de Arquivo Temporario.");
            $arquivo = fopen("Conteudo.txt", "r") or die ("Falha Na Abertura Do Arquivo.");
            while (list($Id, $Nome, $CodB, $Desc, $Valor, $Estoque, $Peso, $imagem) = fgetcsv($arquivo, 1000, ",")) {
                if ($Id != $numero) {
                    $Dados = $Id . "," . $Nome . "," . $CodB . "," . $Desc . "," . $Valor . "," . $Estoque . "," . $Peso . "," . $imagem . "\n" ;
                    fwrite($temp,$Dados);
                }
            }
            //inserindo depois de cabeçalho
            $Nome = $_POST["Nome"];
            $CodB = $_POST["CodB"];
            $Desc = $_POST["Desc"];
            $Valor = $_POST["Valor"];
            $Estoque = $_POST["Estoque"];
            $Peso = $_POST["Peso"];
            $imagem = $_POST["Imagem"];

            $Dados = $numero . "," . $Nome . "," . $CodB . "," . $Desc . "," . $Valor . "," . $Estoque . "," . $Peso . "," . $imagem . "\n" ;
            fwrite($temp,$Dados);
            fclose($temp);
            fclose($arquivo);

            $arquivo = fopen("Conteudo.txt", "w") or die ("Falha Na Abertura Do Arquivo.");
            $temp = fopen("temp.txt", "r") or die ("Falha Na Abertura Do Arquivo.");
            while (!feof($temp)) {
                fwrite($arquivo, fgets($temp));
            }
        } else {
            echo "<br><br> Arquivo Não Existe!  Criando Arquivo!";
            $arquivo = fopen("Conteudo.txt", "w");
            $Dados = "id,Nome,Codigo de Barras,Descricao,Valor,Estoque,Peso,URL Imagem\n";
            fwrite($arquivo,$Dados);
        }
        fclose($temp);
        fclose($arquivo);
        unlink("temp.txt");
    }
    ?>
</table>
</body>
</html>