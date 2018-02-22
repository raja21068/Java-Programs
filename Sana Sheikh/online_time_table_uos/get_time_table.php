    <option value="">Please select...</option>
<?php
//      $teacher= $_REQUEST['teacher'];
//		$course= $_REQUEST['course'];
//		$semester= $_REQUEST['semester'];
        $teacher= 10;
		$course= 73;
		$semester= 9;
		
require_once 'DatabaseManager.php';

    $response = DatabaseManager::getTimeTable($teacher, $course, $semester);
	while($row = mysqli_fetch_array($response)){
	}
?>