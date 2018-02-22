<?php
$prog_id = $_REQUEST['prog_id'];
require_once 'DatabaseManager.php';
    DatabaseManager::deleteProgram($prog_id);
?>