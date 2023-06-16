<?php
    if($_SERVER["REQUEST_METHOD"] == "POST")
    {
        $matricula = $_POST["Matricula"];
        $nome = $_POST["Nome"];
        $idade = $_POST["Idade"];
        $email = $_POST["Email"];

        if(!file_exists("Alunos.txt")) {
            $arquivoAluno = fopen("Alunos.txt", "w");
            $cabecalho = "matricula ; nome ; idade ; email\n";
            fwrite($arquivoAluno, $cabecalho);
            fclose($arquivoAluno);
        }
        else {
            $arquivoAluno = fopen("Alunos.txt", "r") or die ("Arquivo Com Problema");
            while (!feof($arquivoAluno)) {
                echo fgets($arquivoAluno) . "<br>";
            }
            fclose($arquivoAluno);

            $arquivoAluno = fopen("Alunos.txt", "a");
            $linha = $matricula . " ; " . $nome . " ; " . $idade . " ; " . $email;
            fwrite($arquivoAluno, $linha);
            fclose($arquivoAluno);

            $arquivoAluno = fopen("Alunos.txt", "r") or die ("Arquivo Com Problema");
            $arquivoP = fopen("Copia.txt", "w") or die ("Arquivo Com Problema");
            while (!feof($arquivoAluno)) {
                fwrite($arquivoP, fgets($arquivoAluno));;
            }
            fclose($arquivoAluno);
            fclose($arquivoP);
        }
    }
?>
<!DOCKTYPE HTML>
<html>
<head>
    <style>
        body
        {
            text-align: center;
        }
    </style>
    <meta charset="UTF-8">
</head>
<body>
    <h1>3DAW - Incluir Aluno</h1>
    <form action="Exer14.php" method="post"><br>
        Matricula: <input type="string" name="Matricula"><br>
        Nome: <input type="text" name="Nome"><br>
        Idade: <input type="number" name="Idade"><br>
        Email: <input type="email" name="Email">
        <br><br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>