<html>
  <head>
    <title>I am the King of Arrays!</title>
  </head>
  <body>
    <p>
      <?php
      // On the line below, create your own associative array:
        $myArray = array('a'=>1,
                        'b'=>2,
                        'c'=>3);

      // On the line below, output one of the values to the page:
     echo $myArray['a'];
     echo "<br>";
          
      // On the line below, loop through the array and output
      // *all* of the values to the page:
        foreach($myArray as $k=>$v){
            echo $k." = ".$v;
            echo"<br>";
        }
     
      ?>
    </p>
  </body>
</html>