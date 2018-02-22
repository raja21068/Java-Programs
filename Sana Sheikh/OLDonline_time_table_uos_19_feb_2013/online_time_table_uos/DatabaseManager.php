<?php

class DatabaseManager{

/*******************Teacher*********************/

    public static function getTeachers($dept_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM teacher WHERE dept_id = $dept_id ORDER BY name" ;
//	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function addTeacher($dept_id,$name,$fname,$surname,$nic,$mobile_no,$password,$pay_scill,$email,$name_code){
	include("db_connectin.php");
	$query  = "INSERT INTO teacher (dept_id,name,fname,surname,nic,mobile_no,password,pay_scill,email,name_code) VALUES ($dept_id,'$name','$fname','$surname','$nic','$mobile_no','$password','$pay_scill','$email','$name_code')";
	//echo $query;
	mysqli_query($con,$query);
    }
    public static function updateTeacher($teacher_id,$name,$fname,$surname,$nic,$mobile_no,$password,$pay_scill,$email,$name_code){
	include("db_connectin.php");
	$query  = "UPDATE teacher set 	name = '$name',
									fname = '$fname',
									surname = '$surname',
									nic = '$nic',
									mobile_no = '$mobile_no',
									password = '$password',
									pay_scill = '$pay_scill',
									email = '$email',
									name_code = '$name_code' 
				WHERE teacher_id = $teacher_id";
	mysqli_query($con,$query);
    }
    public static function deleteTeacher($teacher_id){
	include("db_connectin.php");
	$query  = "DELETE FROM teacher WHERE teacher_id = $teacher_id";
	mysqli_query($con,$query);
    }
    public static function get_teacher_data($teacher_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM teacher WHERE teacher_id = $teacher_id";
//	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
	
/******************Teacher end************/
/*****************************************/
	

	
/******************Programs***************/
	
    public static function get_prog_data($prog_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM program WHERE prog_id = $prog_id";
//	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function getPrograms($dept_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM program WHERE dept_id = $dept_id";
	//echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function addProgram($dept_id,$program_tittle,$degree_tittle){
	include("db_connectin.php");
	$query  = "INSERT INTO program (dept_id,prog_tittle,degree_tittle) VALUES ($dept_id,'$program_tittle','$degree_tittle')";
	//echo $query;
	mysqli_query($con,$query);
    }
    public static function updateProgram($prog_id,$prog_tittle,$degree_tittle){
	include("db_connectin.php");
	$query  = "UPDATE program set prog_tittle = '$prog_tittle', degree_tittle = '$degree_tittle' 
				WHERE prog_id = $prog_id";
				echo $query;
	mysqli_query($con,$query);
    }
    public static function deleteProgram($prog_id){
	include("db_connectin.php");
	$query  = "DELETE FROM program WHERE prog_id = $prog_id";
	echo $query;
	mysqli_query($con,$query);
    }
	
/*****************Programs end************/
/*****************************************/
	

	
/******************Courses****************/
	
    public static function getCourse($part, $semester){
	include("db_connectin.php");
	$query  = "SELECT * FROM courses WHERE part_id = $part AND semister = $semester";
	//echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function addCourse($part_id,$course_code,$course_name, $remarks, $semester){
	include("db_connectin.php");
	$query  = "INSERT INTO courses (part_id,course_code,course_name, remarks, semister) VALUES ($part_id,'$course_code','$course_name', '$remarks', $semester)";
	//echo $query;
	mysqli_query($con,$query);
    }
    public static function get_course_data($course_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM courses WHERE course_id = $course_id";
//	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function deleteCourse($course_id){
	include("db_connectin.php");
	$query  = "DELETE FROM courses WHERE course_id = $course_id";
//	echo $query;
	mysqli_query($con,$query);
    }
    public static function updateCourse($course_id, $course_code, $course_name, $remarks){
	include("db_connectin.php");
	$query  = "UPDATE courses set course_code = '$course_code', course_name = '$course_name',  remarks = '$remarks' 
				WHERE course_id = $course_id";
		//		echo $query;
	mysqli_query($con,$query);
    }

/*****************Courses end*************/
/*****************************************/
	

	
/******************parts****************/
	
    public static function getpart($programs){
	include("db_connectin.php");
	$query  = "SELECT * FROM part p, shift s WHERE p.prog_id = $programs AND s.shift_id = p.shift";
	//echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function get_part_data($part_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM part WHERE part_id = $part_id";
//	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function addpart($prog_id,$part,$shift, $remarks, $group_desc){
	include("db_connectin.php");
	$query  = "INSERT INTO part (prog_id, part, shift, remarks, group_desc) VALUES ($prog_id, '$part', $shift, '$remarks', '$group_desc')";
	//echo $query;
	mysqli_query($con,$query);
    }
    public static function deletepart($part_id){
	include("db_connectin.php");
	$query  = "DELETE FROM part WHERE part_id = $part_id";
	echo $query;
	mysqli_query($con,$query);
    }
    public static function updatepart($part_id, $part, $shift, $remarks, $group_desc){
	include("db_connectin.php");
	$query  = "UPDATE part set part = '$part', shift = $shift,  remarks = '$remarks', group_desc = '$group_desc'  
				WHERE part_id = $part_id";
				echo $query;
	mysqli_query($con,$query);
    }
	
/*****************partes end*************/
/*****************************************/




/*****************Semester****************/

    public static function getSemesters($part){
	include("db_connectin.php");
	$query  = "SELECT * FROM semester WHERE part_id = $part";
	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function get_semester_data($semester_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM semester WHERE semester_id = $semester_id";
	//echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function addSemester($part_id, $semester, $remarks){
	include("db_connectin.php");
	$query  = "INSERT INTO semester (part_id, semester, remarks) VALUES ($part_id, '$semester', '$remarks')";
//	echo $query;
	mysqli_query($con,$query);
    }
    public static function deleteSemester($semester_id){
	include("db_connectin.php");
	$query  = "DELETE FROM semester WHERE semester_id = $semester_id";
//	echo $query;
	mysqli_query($con,$query);
    }
    public static function updateSemester($semester_id, $semester, $remarks){
	include("db_connectin.php");
	$query  = "UPDATE semester set semester = '$semester',  remarks = '$remarks'  
				WHERE semester_id = $semester_id";
		//		echo $query;
	mysqli_query($con,$query);
    }

/*****************Semester end************/
/*****************************************/




/********************Days****************/

    public static function getDays(){
	include("db_connectin.php");
	$query  = "SELECT * FROM days" ;
//	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }


/*****************Days end************/
/*****************************************/





/********************Time****************/

    public static function getTimes($department_id, $part){
	include("db_connectin.php");
	$query  = "SELECT * FROM time t, shift s, part p WHERE s.shift_id = t.shift_id AND t.department_id = $department_id AND s.shift_id = p.shift AND p.part_id = $part" ;
	//echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function getTimesByShift($department_id, $shift){
	include("db_connectin.php");
	$query  = "SELECT * FROM time WHERE department_id = $department_id AND shift_id = $shift" ;
	//echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function updateTimes($time_id, $time){
	include("db_connectin.php");
	$query  = "UPDATE time set time = '$time'  
				WHERE time_id = $time_id";
	mysqli_query($con,$query);
    }


/*****************Time end************/
/*****************************************/





/*****************Time_Table************/

    public static function getTimeTable($part, $semester, $teacher){
	include("db_connectin.php");
	$query  = "SELECT t.name_code, d.days_name, tm.time_id, c.course_code, c.course_name, r.room_name
FROM 
part p, time_table tt, teacher t, days d, time tm, courses c, rooms r
WHERE 
p.part_id = tt.part_id AND p.part_id = $part 
AND 
t.teacher_id = tt.teacher_id AND t.teacher_id = $teacher
AND 
tt.days_id = d.days_id
AND 
tm.time_id = tt.time_id
AND 
c.course_id = tt.course_id
AND 
r.room_id = tt.room_id
	";
	//echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }

	
    public static function updateTimeTable($time_table_id, $teacher_id, $day_id, $time_id, $course_id, $part_id){
	include("db_connectin.php");
	$query  = "UPDATE time_table set teacher_id = '$teacher_id',  day_id = '$day_id', time_id = $time_id, course_id = $course_id, part_id = $part_id  
				WHERE time_table_id = $time_table_id";
		//		echo $query;
	mysqli_query($con,$query);
    }

	
    public static function addTimeTable($teacher_id, $day_id, $time_id, $course_id, $part_id, $room){
	include("db_connectin.php");
	$query  = "INSERT INTO time_table (teacher_id, days_id, time_id, course_id, part_id, room_id) VALUES ($teacher_id, $day_id, $time_id, $course_id, $part_id, $room)";
	//echo $query;
	mysqli_query($con,$query);
    }
	
/*****************Time_Table end************/
/*****************************************/



/*******************Room*********************/

    public static function getRooms($dept_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM rooms WHERE dept_id = $dept_id ORDER BY room_name" ;
//	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function addRoom($dept_id,$room_name){
	include("db_connectin.php");
	$query  = "INSERT INTO rooms (dept_id,room_name) VALUES ($dept_id,'$room_name')";
	echo $query;
	mysqli_query($con,$query);
    }
    public static function updateRoom($room_id,$room_name){
	include("db_connectin.php");
	$query  = "UPDATE rooms set 	room_name = '$room_name'
				WHERE room_id = $room_id";
	mysqli_query($con,$query);
    }
    public static function deleteRoom($room_id){
	include("db_connectin.php");
	$query  = "DELETE FROM rooms WHERE room_id = $room_id";
	mysqli_query($con,$query);
    }
    public static function get_room_data($room_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM rooms WHERE room_id = $room_id";
	//echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
	
/******************Room end************/
/*****************************************/




/******************Department************/

    public static function getDepartments(){
	include("db_connectin.php");
	$query  = "SELECT * FROM department";
	$result = mysqli_query($con,$query);
	return $result;
    }

/******************Department end************/
/*****************************************/
	
    public static function getAdmin($user_name, $password){
	include("db_connectin.php");
	$query  = "SELECT * FROM admin	WHERE username = '$user_name' AND password = '$password'";
//	echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function getUserInfo($user_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM admin	WHERE admin_id = $user_id";
	$result = mysqli_query($con,$query);
	return $result;
    }
}
?>