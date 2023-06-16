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
        <form action="Incluir.php" method="post"><br><br>
            Nome: <input type="text" name="Nome"><br>
            Codigo De Barra: <input type="text" name="CodB"><br>
            Descrição: <input type="text" name="Desc"><br>
            Valor: <input type="text" name="Valor"><br>
            Estoque: <input type="text" name="Estoque"><br>
            Peso: <input type="text" name="Peso"><br>
            URL-Imagem: <input type="text" name="Imagem"><br>
            <br>
            <input type="submit" value="Incluir">
        </form>
    <?php
    if($_SERVER["REQUEST_METHOD"] == "POST") {
        $nome = $_POST["Nome"];
        $CodB = $_POST["CodB"];
        $Desc = $_POST["Desc"];
        $Valor = $_POST["Valor"];
        $Estoque = $_POST["Estoque"];
        $Peso = $_POST["Peso"];
        $Imagem = $_POST["Imagem"];
        if (file_exists("Conteudo.txt")) {
            $arquivo = fopen("Conteudo.txt", "a");
            $id = uniqid();
            $Dados = $id . "," . $nome . "," . $CodB . "," . $Desc . "," . $Valor . "," . $Estoque . "," . $Peso . "," . $Imagem . "\n" ;
            fwrite($arquivo,$Dados);
        }else{
            echo "Arquivo Não Existe!  Criando Arquivo!";
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