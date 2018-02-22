<?php
$teacher_id = $_REQUEST['teacher_id'];
require_once 'DatabaseManager.php';
    DatabaseManager::deleteTeacher($teacher_id);
?>