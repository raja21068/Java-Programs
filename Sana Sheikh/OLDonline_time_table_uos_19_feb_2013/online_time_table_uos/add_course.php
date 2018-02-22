<?php
$part_id = $_REQUEST['course_part_list'];
$semester = $_REQUEST['semester'];
$course_code = $_REQUEST['course_code'];
$course_name=$_REQUEST['course_name'];
$remarks=$_REQUEST['remarks'];

require_once 'DatabaseManager.php';
    DatabaseManager::addCourse($part_id,$course_code,$course_name, $remarks, $semester);
	header("Location: admin.php#course");
?>