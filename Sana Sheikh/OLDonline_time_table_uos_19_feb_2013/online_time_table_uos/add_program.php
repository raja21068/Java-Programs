<?php
$dept_id = $_REQUEST['dept_id'];
$program_tittle=$_REQUEST['program_tittle'];
$degree_tittle=$_REQUEST['degree_tittle'];

require_once 'DatabaseManager.php';
    DatabaseManager::addProgram($dept_id,$program_tittle,$degree_tittle);
	header("Location: admin.php#programs");
?>