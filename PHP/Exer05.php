<!DOCKTYPE HTML>
<html>
    <head>
    </head>
    <body>
        <h1>3DAW</h1>
            <?php
                echo "<h2>Exercicio string</h2>" ; //variaveis e seus tipos

                $variavel = "esta e uma string";
                echo $variavel;
                echo "<br>";
                echo "quantidade de caracteres: " . strlen($variavel);
                echo "<br>";
                echo "quantidade de palavras: " . str_word_count($variavel);
                echo "<br>";
                echo "frase invertida: " . strrev($variavel);
                echo "<br>";
            ?>
    </body>
</html>
