<?php
	require_once "../DatabaseManager.php";
	$dept = "";
	$program = "";
	$part = "";
	$shift = "";
	$day = "";
	$teacher = "";
	$cell_no="1234567890";
	$group = "";
	
	if(isset($_REQUEST['dept'])){ $dept = $_REQUEST['dept']; }
	if(isset($_REQUEST['group'])){ $group = $_REQUEST['group']; } 
	if(isset($_REQUEST['program'])){ $program = $_REQUEST['program']; } 
	if(isset($_REQUEST['part'])){ $part = $_REQUEST['part']; }
	if(isset($_REQUEST['shift'])){ $shift = $_REQUEST['shift']; }
	if(isset($_REQUEST['day'])){ $day = $_REQUEST['day']; } 
	if(isset($_REQUEST['teacher'])){ $teacher = $_REQUEST['teacher']; }
	if(isset($_REQUEST['cell_no'])){ $cell_no = $_REQUEST['cell_no']; }
	
	if( $teacher != ""){
		DatabaseManager::getTeacher($dept,$teacher);
		if($row=mysqli_fetch_array($time_table)){
			$teacher = $row['teacher_id'];
		}
	}
	
	$time_table = DatabaseManager::getTimeTableMobile($program, $part, $shift, $day, $teacher, $group);
	$index = 0;
	$response["cell_no"] = "$cell_no";
	$message = "";
	while($row=mysqli_fetch_array($time_table))  {
		$message = $message . $row['time']." ( " ; 
		$message = $message . $row['course_code']. " at";
		$message = $message . " " . $row['code'] . " ";	
		$message = $message . " in " . $row['room_name'] . " ";
		if($teacher == ""){
			$message = $message . "by: " . $row['name_code'] . " ";
		}
		$message = $message . ")\n";
	}
	
	$response['message'] = $message;
    echo json_encode($response);
	
 //test query.................
 //http://localhost/TimeTable/Mobile/timetable.php?batch_year=2010%20IT%20&department_code=SUMC&semester=1&shift=MORNING&days_name=MONDAY
 //select ti.time as timee,s.semester as semester,c.course_name as course_name,b.batch_year as batch_year ,teach.name as teacher_name,teach.name_code as teacher_code,day.days_name as day_name,c.course_name as course_name from time_table tt,semester s,batch b,program p, department d, courses c ,days day, time ti,teacher teach WHERE tt.semester_id=s.semester_id AND s.batch_id=b.batch_id AND b.prog_id=p.prog_id AND p.dept_id=d.dept_id AND tt.days_id=day.days_id AND tt.time_id=ti.time_id AND tt.course_id=c.course_id AND tt.teacher_id=teach.teacher_id AND d.code='SUMC' AND s.semester=1 AND b.batch_year='2010 IT ' AND b.shift='MORNING' AND day.days_name='MONDAY 
 
?>