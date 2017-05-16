<html>
    <p>
	<?php
	// Create an array and push on the names
    // of your closest family and friends
    $arr = array();
    array_push($arr,"bb");
    array_push($arr,"aa");
    array_push($arr,"c");
    array_push($arr,"d");
	// Sort the list
    sort($arr);
	// Randomly select a winner!
    $r = rand(0,count($arr));
	// Print the winner's name in ALL CAPS
	echo strtoupper($arr[$r]);
	?>
	</p>
</html>