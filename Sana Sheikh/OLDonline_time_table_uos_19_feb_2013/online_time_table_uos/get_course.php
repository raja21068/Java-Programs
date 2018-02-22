    <option value="">Please select...</option>
<?php
$part = $_REQUEST['part'];
$semester = $_REQUEST['semester'];
require_once 'DatabaseManager.php';

    $course = DatabaseManager::getCourse($part, $semester);
	while($row = mysqli_fetch_array($course)){
		echo '<option value="'.$row['course_id'].'">'.$row['course_name'].'</option>';
	}
?>