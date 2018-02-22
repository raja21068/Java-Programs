<?php
$prog_id=$_REQUEST['prog_id'];
$prog_tittle=$_REQUEST['prog_tittle'];
$degree_tittle=$_REQUEST['degree_tittle'];
require_once 'DatabaseManager.php';
    DatabaseManager::updateProgram($prog_id,$prog_tittle,$degree_tittle);
?>