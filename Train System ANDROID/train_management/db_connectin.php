<?php
    $con=mysqli_connect("localhost","root","root","train_reservation");
    	// Check connection
    	if (mysqli_connect_errno($con)){
		header("Location: error_page.php?message=Failded%20to%20connect%20Database");
    	}
?>