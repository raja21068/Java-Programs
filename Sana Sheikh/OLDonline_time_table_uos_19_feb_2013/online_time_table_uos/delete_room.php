<?php
$room_id = $_REQUEST['room_id'];
require_once 'DatabaseManager.php';
    DatabaseManager::deleteRoom($room_id);
?>