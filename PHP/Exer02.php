<!DOCKTYPE HTML>
<html>
<head>
</head>
<body>
<h1>3DAW</h1>
<?php
echo "<h2>Exercicio tipos</h2>" ; //variaveis e seus tipos

$variavel = "está é uma string";
var_dump($variavel); //saber o tipo de dado que tem dentro do codigo

$variavelint = 7;
var_dump($variavelint);

$variavelfloat = 5.789;
var_dump($variavelfloat);

$variavelBoo= true;
var_dump($variavelBoo);


echo "<br>";
echo $variavel;
echo "<br>";
echo "variavel tipo int: " . $variavelint;
echo "<br>";
echo "variavel tipo float: " . $variavelfloat;
echo "<br>";
echo "variavel tipo Boolean: " . $variavelBoo;

if ($variavelBoo){
    echo "<br>";
    echo "variavel tipo Boolean: True";
}
else{
    echo "<br>";
    echo "variavel tipo Boolean: false";
}

?>
</body>
</html>
