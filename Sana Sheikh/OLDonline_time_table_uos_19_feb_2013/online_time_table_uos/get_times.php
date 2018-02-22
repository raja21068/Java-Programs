    <option value="">Please select...</option>
<?php
$part = $_REQUEST['part'];
$dept_id = $_REQUEST['dept_id'];
require_once 'DatabaseManager.php';

    $course = DatabaseManager::getTimes($dept_id, $part);
	while($row = mysqli_fetch_array($course)){
		echo '<option value="'.$row['time_id'].'">'.$row['time'].'</option>';
	}
?>