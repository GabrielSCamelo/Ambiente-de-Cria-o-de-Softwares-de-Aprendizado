<?php
function soma($v1,$v2){
    $Result = $v1 + $v2;
    return $Result;
}
function subtraction($v1,$v2){
    $Result = $v1 - $v2;
    return $Result;
}
function multiplic($v1,$v2){
    $Result = $v1 * $v2;
    return $Result;
}
function division($v1,$v2){
    $Result = $v1 / $v2;
    return $Result;
}
function exponencial($v1,$v2){
    $Result = $v1 ** $v2;
    return $Result;
}
function RestoDivi($v1,$v2){
    $Result = $v1 % $v2;
    return $Result;
}
function Calculator($operation,$vlr1,$vlr2){

    switch($operation)
    {
        case "*":{
            $Result = Multiplic($vlr1,$vlr2);
            break;
        }
        case "/":{
            $Result = Division($vlr1,$vlr2);
            break;
        }
        case "-":{
            $Result = Subtraction($vlr1,$vlr2);
            break;
        }
        case "%":{
            $Result = RestoDivi($vlr1,$vlr2);
            break;
        }
        case "**":{
            $Result = Exponencial($vlr1,$vlr2);
            break;
        }
        case "+":{
            $Result = Soma($vlr1,$vlr2);
        }
    }
    return $Result;
}
?>
<!DOCKTYPE HTML>
<html>
<head>
    <style>
        input{
            width: 80px;
        }
    </style>
</head>
<body>
<h1>3DAW</h1>
<form action="exer11.php" method="POST">
    <input type="number" id="vlr1" value="" name="vlr1">
    <select id="operation" name="operation">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="**">**</option>
        <option value="%">%</option>
        <option value="*">*</option>
    </select>
    <input type="number" id="vlr2" value="" name="vlr2">
     =  <?php echo Calculator($_POST["operation"],$_POST["vlr1"],$_POST["vlr2"]); ?>
    <br><br>
    <input type="submit" value="enviar">
</form>
</body>
</html>
