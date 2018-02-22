<?php

class DatabaseManager {
    /*     * *****************Teacher******************** */

    public static $SUPER_ADMIN = 1;
    public static $USER = 0;

    public static function getTeachers($dept_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM teacher WHERE dept_id = $dept_id ORDER BY name";
//	echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getTeacher($deptCode, $teacherName) {
        include("db_connectin.php");
        $query = "SELECT * FROM teacher t
		INNER JOIN department d ON d.dept_id = t.dept_id 
		WHERE d.code='$deptCode' AND name='$teacherName'";
        //	echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getMaxTeacherId() {
        include("db_connectin.php");
        $query = "SELECT MAX(teacher_id) as teacher_id FROM teacher";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function addTeacher($dept_id, $name, $fname, $surname, $nic, $mobile_no, $password, $pay_scill, $email, $name_code) {
        include("db_connectin.php");
        $query = "INSERT INTO teacher (dept_id,name,fname,surname,nic,mobile_no,password,pay_scill,email,name_code) VALUES ($dept_id,'$name','$fname','$surname','$nic','$mobile_no','$password','$pay_scill','$email','$name_code')";
        //echo $query;
        return mysqli_query($con, $query);
    }

    public static function updateTeacher($teacher_id, $name, $fname, $surname, $nic, $mobile_no, $password, $pay_scill, $email, $name_code) {
        include("db_connectin.php");
        $query = "UPDATE teacher set name = '$name',									fname = '$fname',
			surname = '$surname',									nic = '$nic',
			mobile_no = '$mobile_no',
                        password = '$password',
			pay_scill = '$pay_scill',
			email = '$email',
			name_code = '$name_code' 
			WHERE teacher_id = $teacher_id";
        return mysqli_query($con, $query);
    }

    public static function deleteTeacher($teacher_id) {
        include("db_connectin.php");
        $query = "DELETE FROM teacher WHERE teacher_id = $teacher_id";
        return mysqli_query($con, $query);
    }

    public static function get_teacher_data($teacher_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM teacher WHERE teacher_id = $teacher_id";
//	echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    /*     * ****************Teacher end*********** */
    /*     * ************************************** */



    /*     * ****************Programs************** */

    public static function get_prog_data($prog_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM program WHERE prog_id = $prog_id";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getPrograms($dept_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM program WHERE dept_id = $dept_id";
        //echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getMaxProgramId() {
        include("db_connectin.php");
        $query = "SELECT MAX(prog_id) as prog_id FROM program ";
        //echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function addProgram($dept_id, $program_tittle, $degree_tittle) {
        include("db_connectin.php");
        $query = "INSERT INTO program (dept_id,prog_tittle,degree_tittle) VALUES ($dept_id,'$program_tittle','$degree_tittle')";
        //echo $query;
        return mysqli_query($con, $query);
    }

    public static function updateProgram($prog_id, $prog_tittle, $degree_tittle) {
        include("db_connectin.php");
        $query = "UPDATE program set prog_tittle = '$prog_tittle', degree_tittle = '$degree_tittle' 
				WHERE prog_id = $prog_id";
        return mysqli_query($con, $query);
    }

    public static function deleteProgram($prog_id) {
        include("db_connectin.php");
        $query = "DELETE FROM program WHERE prog_id = $prog_id";

        return mysqli_query($con, $query);
    }

    /*     * ***************Programs end*********** */
    /*     * ************************************** */



    /*     * ****************Courses*************** */

    public static function getCourse($part, $semester) {
        include("db_connectin.php");
        $query = "SELECT * FROM courses WHERE part_id = $part AND semister = $semester";
        //echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }
    
    public static function getMaxCourseId() {
        include("db_connectin.php");
        $query = "SELECT MAX(course_id) FROM courses";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function addCourse($part_id, $course_code, $course_name, $remarks, $semester) {
        include("db_connectin.php");
        $query = "INSERT INTO courses (part_id,course_code,course_name, remarks, semister) VALUES ($part_id,'$course_code','$course_name', '$remarks', $semester)";
        //echo $query;
        return mysqli_query($con, $query);
    }

    public static function get_course_data($course_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM courses WHERE course_id = $course_id";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function deleteCourse($course_id) {
        include("db_connectin.php");
        $query = "DELETE FROM courses WHERE course_id = $course_id";
        return mysqli_query($con, $query);
    }

    public static function updateCourse($course_id, $course_code, $course_name, $remarks) {
        include("db_connectin.php");
        $query = "UPDATE courses set course_code = '$course_code', course_name = '$course_name',  remarks = '$remarks' 
				WHERE course_id = $course_id";
        //		echo $query;
        return mysqli_query($con, $query);
    }

    /*     * ***************Courses end************ */
    /*     * ************************************** */



    /*     * ****************parts*************** */

    public static function getpart($programs) {
        include("db_connectin.php");
        $query = "SELECT * FROM part p, shift s WHERE p.prog_id = $programs AND s.shift_id = p.shift";
        //echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getPartByShift($programs,$shift_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM part p, shift s WHERE p.prog_id = $programs AND s.shift_id = p.shift AND s.shift_id=".$shift_id;
        echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }
    
    public static function get_part_data($part_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM part WHERE part_id = $part_id";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getMaxPartId() {
        include("db_connectin.php");
        $query = "SELECT MAX(part_id) as part_id FROM part";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function addpart($prog_id, $part, $shift, $remarks, $group_desc) {
        include("db_connectin.php");
        $query = "INSERT INTO part (prog_id, part, shift, remarks, group_desc) VALUES ($prog_id, '$part', $shift, '$remarks', '$group_desc')";
        //echo $query;
        return mysqli_query($con, $query);
    }

    public static function deletepart($part_id) {
        include("db_connectin.php");
        $query = "DELETE FROM part WHERE part_id = $part_id";
        return mysqli_query($con, $query);
    }

    public static function updatepart($part_id, $part, $shift, $remarks, $group_desc) {
        include("db_connectin.php");
        $query = "UPDATE part set part = '$part', shift = $shift,  remarks = '$remarks', group_desc = '$group_desc'  
				WHERE part_id = $part_id";
        return mysqli_query($con, $query);
    }

    /*     * ***************partes end************ */
    /*     * ************************************** */




    /*     * ***************Semester*************** */

    public static function getSemesters($part) {
        include("db_connectin.php");
        $query = "SELECT * FROM semester WHERE part_id = $part";
        echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function get_semester_data($semester_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM semester WHERE semester_id = $semester_id";
        //echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function addSemester($part_id, $semester, $remarks) {
        include("db_connectin.php");
        $query = "INSERT INTO semester (part_id, semester, remarks) VALUES ($part_id, '$semester', '$remarks')";
//	echo $query;
        return mysqli_query($con, $query);
    }

    public static function deleteSemester($semester_id) {
        include("db_connectin.php");
        $query = "DELETE FROM semester WHERE semester_id = $semester_id";
//	echo $query;
        return mysqli_query($con, $query);
    }

    public static function updateSemester($semester_id, $semester, $remarks) {
        include("db_connectin.php");
        $query = "UPDATE semester set semester = '$semester',  remarks = '$remarks'  
				WHERE semester_id = $semester_id";
        //		echo $query;
        return mysqli_query($con, $query);
    }

    /*     * ***************Semester end*********** */
    /*     * ************************************** */




    /*     * ******************Days*************** */

    public static function getDays() {
        include("db_connectin.php");
        $query = "SELECT * FROM days";
//	echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    /*     * ***************Days end*********** */
    /*     * ************************************** */





    /*     * ******************Time*************** */

    public static function getTimes($department_id, $part) {
        include("db_connectin.php");
        $query = "SELECT * FROM time t, shift s, part p WHERE s.shift_id = t.shift_id AND t.department_id = $department_id AND s.shift_id = p.shift AND p.part_id = $part";
        //echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getTimesByShift($department_id, $shift) {
        include("db_connectin.php");
        $query = "SELECT * FROM time WHERE department_id = $department_id AND shift_id = $shift";
        //echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function updateTimes($time_id, $time) {
        include("db_connectin.php");
        $query = "UPDATE time set time = '$time'  
				WHERE time_id = $time_id";
        return mysqli_query($con, $query);
    }

    /*     * ***************Time end*********** */
    /*     * ************************************** */





    /*     * ***************Time_Table*********** */

    public static function getTimeTable($part, $semester, $teacher) {
        include("db_connectin.php");
        $query = "SELECT t.name_code,t.name, d.days_name, tm.time_id, c.course_code, c.course_name, r.room_name
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
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function updateTimeTable($time_table_id, $teacher_id, $day_id, $time_id, $course_id, $part_id) {
        include("db_connectin.php");
        $query = "UPDATE time_table set teacher_id = '$teacher_id',  day_id = '$day_id', time_id = $time_id, course_id = $course_id, part_id = $part_id  
				WHERE time_table_id = $time_table_id";
        //		echo $query;
        return mysqli_query($con, $query);
    }

    public static function addTimeTable($teacher_id, $day_id, $time_id, $course_id, $part_id, $room) {
        include("db_connectin.php");
        $query = "INSERT INTO time_table (teacher_id, days_id, time_id, course_id, part_id, room_id) VALUES ($teacher_id, $day_id, $time_id, $course_id, $part_id, $room)";
        //echo $query;
        return mysqli_query($con, $query);
    }

    /*     * ***************Time_Table end*********** */
    /*     * ************************************** */



    /*     * *****************Room******************** */

    public static function getRooms($dept_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM rooms WHERE dept_id = $dept_id ORDER BY room_name";
        echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function addRoom($dept_id, $room_name) {
        include("db_connectin.php");
        $query = "INSERT INTO rooms (dept_id,room_name) VALUES ($dept_id,'$room_name')";
        return mysqli_query($con, $query);
    }

    public static function updateRoom($room_id, $room_name) {
        include("db_connectin.php");
        $query = "UPDATE rooms set 	room_name = '$room_name'
				WHERE room_id = $room_id";
        return mysqli_query($con, $query);
    }

    public static function deleteRoom($room_id) {
        include("db_connectin.php");
        $query = "DELETE FROM rooms WHERE room_id = $room_id";
        return mysqli_query($con, $query);
    }

    public static function get_room_data($room_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM rooms WHERE room_id = $room_id";
        $result = mysqli_query($con, $query);
        return $result;
    }
    public static function getMaxRoomId() {
        include("db_connectin.php");
        $query = "SELECT MAX(room_id) as room_id FROM rooms";
        $result = mysqli_query($con, $query);
        return $result;
    }
    
    /*     * ****************Room end*********** */
    /*     * ************************************** */


    public static function getAllShift(){
        include("db_connectin.php");
        $query = "SELECT * FROM shift";
        $result = mysqli_query($con, $query);
        return $result;
    }


    /*     * ****************Department*********** */

    public static function getDepartments() {
        include("db_connectin.php");
        $query = "SELECT * FROM department ORDER BY dept_name";
        $result = mysqli_query($con, $query);
        return $result;
    }

    /*     * ****************Department end*********** */
    /*     * ************************************** */

    public static function getAdmin($user_name, $password) {
        include("db_connectin.php");
        $query = "SELECT * FROM admin	WHERE username = '$user_name' AND password = '$password'";
//	echo $query;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getUserInfo($user_id) {
        include("db_connectin.php");
        $query = "SELECT * FROM admin	WHERE admin_id = $user_id";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getTimeTableAdmin($program, $day, $time) {
        include("db_connectin.php");
        $query = "SELECT t.name, d.days_name, tm.time_id, c.course_code, c.course_name, r.room_name
				FROM time_table tt, part p, teacher t, days d, time tm, courses c, rooms r, program pr, shift s 
				WHERE p.part_id = tt.part_id  AND p.shift = s.shift_id AND 
				pr.prog_id = p.prog_id AND pr.degree_tittle = $program 
				AND t.teacher_id = tt.teacher_id AND tt.days_id = d.days_id AND d.remarks = $day 
				AND tm.time_id = tt.time_id AND tm._from <= '$time' AND tm._to >= '$time' AND  
				c.course_id = tt.course_id AND r.room_id = tt.room_id ";

        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getDepartment_id($program) {
        include("db_connectin.php");
        $query = "SELECT d.dept_id FROM department d, program p WHERE d.dept_id = p.dept_id AND p.degree_tittle = $program";
        $result = mysqli_query($con, $query);
        if ($row = mysqli_fetch_array($result)) {
            return $row['dept_id'];
        }
        return -1;
    }

    public static function getTimeTableMobile($program, $part, $shift, $day, $teacherId, $group) {
        include("db_connectin.php");
        $query = "SELECT d.days_name, tm.time, teach.name_code, c.course_code,r.room_name,p.group_desc,dept.code  FROM time_table tt
				INNER JOIN part p     ON p.part_id = tt.part_id
				INNER JOIN days d     ON d.days_id = tt.days_id
				INNER JOIN online_time_table_uos.time tm ON tm.time_id=tt.time_id
				INNER JOIN courses c  ON c.course_id = tt.course_id
				INNER JOIN rooms r    ON r.room_id = tt.room_id
				INNER JOIN program pr ON pr.prog_id = p.prog_id
				INNER JOIN shift s    ON p.shift = s.shift_id
				INNER JOIN teacher teach ON teach.teacher_id = tt.teacher_id
				INNER JOIN department dept ON dept.dept_id = teach.dept_id
				WHERE d.days_name like '$day' ";
        // if($dept != ""){
        // $query.=" AND dept.code like '".$dept."' ";
        // }
        if ($program != "") {
            $query.=" AND pr.degree_tittle = '" . $program . "' ";
        }
        if ($part != "") {
            $query.=" AND p.part=$part ";
        }
        if ($shift != "") {
            $query.=" AND s.shift_name like '" . $shift . "%' ";
        }
        if ($teacher != "") {
            $query.=" AND teach.teacher_id=" . $teacherId . " ";
        }
        if ($group != "") {
            $query.=" AND p.group_desc like '" . $group . "' ";
        }
//        echo $query."<br/>";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getDepartment($deptId) {
        include("db_connectin.php");
        $query = "SELECT * FROM department WHERE dept_id=$deptId";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function addDepartment($dep_name, $code, $remarks) {
        include("db_connectin.php");
        $query = "Insert into department (dept_name, code, remarks) values ('" . $dep_name . "','" . $code . "','" . $remarks . "')";
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function updateDepartment($dept_id, $dep_name, $code, $remarks) {
        include("db_connectin.php");
        $query = "UPDATE department SET dept_name = '" . $dep_name . "', code = '" . $code . "', remarks = '" . $remarks . "' WHERE dept_id =" . $dept_id;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function deleteDepartment($dep_id) {
        include("db_connectin.php");
        $query = "DELETE from department WHERE dept_id =" . $dep_id;
        $result = mysqli_query($con, $query);
        return $result;
    }

    public static function getMaxDepartmentId() {
        include("db_connectin.php");
        $query = "SELECT MAX(dept_id) as dep_id from department ";
        $result = mysqli_query($con, $query);
        if ($row = mysqli_fetch_array($result)) {
            return $row[0];
        }
    }

    public static function getUsers() {
        include("db_connectin.php");
        $query = "SELECT * FROM admin";
        return mysqli_query($con, $query);
    }

    public static function getUserBean($admin_Id) {
        include("db_connectin.php");
        $query = "SELECT * FROM admin WHERE admin_id = $admin_Id";
        return mysqli_query($con, $query);
    }

    public static function getMaxUserId() {
        include("db_connectin.php");
        $query = "SELECT MAX(admin_id) as admin_id FROM admin";
        return mysqli_query($con, $query);
    }

    public static function addUser($name, $fathers_name, $surname, $address, $cell_no, $username, $password, $department_dept_id, $adminType, $isSuper) {
        include("db_connectin.php");
        $query = "INSERT INTO admin (name, fathers_name, surname, address,cell_no, username, password, department_dept_id,admin_type,is_super_admin) VALUES ('$name','$fathers_name', '$surname', '$address','$cell_no', '$username', '$password', $department_dept_id,$adminType,$isSuper)";
        return mysqli_query($con, $query);
    }

    public static function deleteUser($admin_id) {
        include("db_connectin.php");
        $query = "DELETE FROM admin WHERE admin_id = $admin_id";
        return mysqli_query($con, $query);
    }

    public static function updateUser($admin_id, $name, $fathers_name, $surname, $address, $cell_no, $username, $password, $department_dept_id, $adminType, $issuper) {
        include("db_connectin.php");
//        $query = "UPDATE FROM ADMIN  SET(name='$name', fathers_name='$fathers_name', surname='$surname', address='$address',cell_no='$cell_no', username='$username', password='password', admin_type=$adminType, is_super_admin=$issuper ,department_dept_id=$department_dept_id WHERE admin_id=$admin_id";
        $query = "UPDATE admin SET name = '" . $name . "', fathers_name = '" . $fathers_name . "', surname = '" . $surname . "', address = '" . $address . "', cell_no = '" . $cell_no . "', admin_type = '" . $adminType . "', username = '" . $username . "', password = '" . $password . "', department_dept_id = '" . $department_dept_id . "', is_super_admin = '" . $issuper . "' WHERE admin_id =" . $admin_id;
        return mysqli_query($con, $query);
    }

}

?>