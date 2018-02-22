<?php
$teacher_id = $_REQUEST['teacher_id'];
$day_id = $_REQUEST['day_id'];
$time_id = $_REQUEST['time_id'];
$course_id = $_REQUEST['course_id'];
$part_id = $_REQUEST['part_id'];
$room = $_REQUEST['room'];
 
require_once 'DatabaseManager.php';

//	$time_table = DatabaseManager::getTimeTable();
	//if($row = mysqli_fetch_array($time_table)){
		//DatabaseManager::updateTimeTable($row['time_table_id'], $teacher_id, $day_id, $time_id, $course_id, $part_id);
//	}
	//else{
    DatabaseManager::addTimeTable($teacher_id, $day_id, $time_id, $course_id, $part_id, $room);
//	}
?>