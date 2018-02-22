<?php
require 'DatabaseManager.php';
$times = $_REQUEST['time'];
foreach($times as $i=>$data){
	echo "id: " . $i . " value: " . $data . "<br>";
    DatabaseManager::updateTimes($i, $data);
}
	header("Location: admin.php");
?>