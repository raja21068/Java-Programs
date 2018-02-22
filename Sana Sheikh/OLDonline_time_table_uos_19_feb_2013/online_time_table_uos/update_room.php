<?php
$room_id = $_REQUEST['room_id'];
$room_name=$_REQUEST['room_name'];

require_once 'DatabaseManager.php';

    DatabaseManager::updateRoom($room_id,$room_name);
?>