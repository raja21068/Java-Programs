<?php
$course_id = $_REQUEST['course_id'];
require_once 'DatabaseManager.php';
    DatabaseManager::deleteCourse($course_id);
?>