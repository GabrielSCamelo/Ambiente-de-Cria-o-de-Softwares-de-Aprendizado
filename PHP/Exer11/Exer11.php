<?php
$vlr1 = "0";
$vlr2 = "0";
$soma = "0";

if($_SERVER['REQUEST_METHOD'] == "POST")
{
    $vlr1=$_POST["vlr1"];
    $vlr2=$_POST["vlr2"];
    $soma = $vlr1 + $vlr2;
}

?>
<!DOCKTYPE HTML>
<html>
<head>
</head>
<body>
<h1>3DAW</h1>
<form action="exer11.php" method="POST">
    <input type="number" id="vlr1" value="<?php if($soma != 0) echo $vlr1; ?>" name="vlr1">
    +
    <input type="number" id="vlr2" value="<?php if($soma != 0) echo $vlr2; ?>" name="vlr2">
     =  <?php if($soma != 0) echo $soma; ?>
    <br><br>
    <input type="submit" value="enviar">
</form>
</body>
</html>
