<?php
$part_id = $_REQUEST['part_id'];
$part = $_REQUEST['part'];
$shift = $_REQUEST['shift'];
$remarks = $_REQUEST['remarks'];
$group_desc = $_REQUEST['group_desc'];

require_once 'DatabaseManager.php';
    DatabaseManager::updatepart($part_id, $part, $shift, $remarks, $group_desc);
?>