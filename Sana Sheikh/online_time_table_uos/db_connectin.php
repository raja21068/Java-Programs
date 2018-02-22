<?php
    $con=mysqli_connect("localhost","root","root","online_time_table_uos");
    	// Check connection
    	if (mysqli_connect_errno($con)){
		header("Location: error_page.php?message=Failded%20to%20connect%20Database");
    	}
?>