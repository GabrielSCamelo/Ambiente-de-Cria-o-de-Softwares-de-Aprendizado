<?php
$vlr1=$_GET["vlr1"];

$vlr2=$_GET["vlr2"];

$soma = $vlr1 + $vlr2;
?>
<!DOCKTYPE HTML>
<html>
<head>
</head>
<body>
<h1>3DAW</h1>
<form action="exer10.php" method="get">
    <input type="number" id="vlr1" value="<?php echo $vlr1; ?>" name="vlr1">
    +
    <input type="number" id="vlr2" value=<?php echo $vlr2; ?> name="vlr2">
     =  <?php echo $soma; ?>
    <br><br>
    <input type="submit" value="enviar">
</form>
</body>
</html>
