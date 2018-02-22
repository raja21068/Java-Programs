<?php
$prog_id = $_REQUEST['program_part'];
$part = $_REQUEST['part'];
$shift=$_REQUEST['shift'];
$remarks=$_REQUEST['remarks'];
$group_desc=$_REQUEST['group_desc'];

require_once 'DatabaseManager.php';
    DatabaseManager::addpart($prog_id,$part,$shift, $remarks, $group_desc);
	header("Location: admin.php#part");
?>