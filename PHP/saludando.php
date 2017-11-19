<?php
 $redis = new Redis();
 $redis -> pconnect("localhost");
 if(!isset($_POST['nombre'])) :
?>
<form method="POST" action="saludando.php">
 <p>
  Dime tu nombre: 
  <input type="text" name="nombre"/> 
  <input type="submit" name="submit" value="Go"/> 
 </p>
</form>
<?php endif ?>
<?php if(isset($_POST['nombre'])) :
  $nombre = $_POST['nombre'];
  if(!$redis->sismember("n3:setNombres",$nombre)){
    $redis->sadd("n3:setNombres",$nombre);
    $respuesta = " te saludo por primera vez";
  }
  else {
    $cont = $redis -> get("n3:incrNombres:$nombre") + 1;
    $respuesta = " son " . $cont . " veces que te he saludado";
  }
  $redis->incr("n3:incrNombres:$nombre");
?>
 <p>
   <b>Hola <?= $nombre ?></b>
   <i><?= $respuesta ?></i>
 </p>
<?php endif ?>

