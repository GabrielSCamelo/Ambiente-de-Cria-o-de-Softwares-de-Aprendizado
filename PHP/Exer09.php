<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <?php
            echo "<h1>3DAW</h1>";
            echo "<h2>Exercício 09 - Math</h2>";

            $variavel = 8;
            echo "<br>";

            var_dump(is_int($variavel));
            echo "<br>";

            echo pi();
            echo "<br><br>";

            $inteiros = array(14,18,20,35,44,53,65,70);

            echo "Maior valor é: " . max($inteiros);
            echo "<br><br>";

            echo "Menor valor é: " . min($inteiros);
            echo "<br><br>";
        ?>
    </body>
</html>
