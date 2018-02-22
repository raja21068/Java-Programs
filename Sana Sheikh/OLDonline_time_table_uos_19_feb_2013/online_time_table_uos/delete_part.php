<?php
$part_id = $_REQUEST['part_id'];
require_once 'DatabaseManager.php';
    DatabaseManager::deletepart($part_id);
?>