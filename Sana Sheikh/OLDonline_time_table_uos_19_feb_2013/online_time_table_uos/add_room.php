<?php
$dept_id = $_REQUEST['dept_id'];
$room_name=$_REQUEST['room_name'];

require_once 'DatabaseManager.php';

    DatabaseManager::addRoom($dept_id,$room_name);
	//header("Location: admin.php");
?>