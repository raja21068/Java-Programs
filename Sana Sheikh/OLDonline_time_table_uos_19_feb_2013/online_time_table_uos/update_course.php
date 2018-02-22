<?php
$course_id = $_REQUEST['course_id'];
$course_code = $_REQUEST['course_code'];
$course_name = $_REQUEST['course_name'];
$remarks = $_REQUEST['remarks'];

require_once 'DatabaseManager.php';
    DatabaseManager::updateCourse($course_id, $course_code, $course_name, $remarks);
?>