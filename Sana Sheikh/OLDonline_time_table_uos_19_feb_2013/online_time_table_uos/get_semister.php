    <option value="">Please select...</option>
<?php
$batch = $_REQUEST['batch'];
require_once 'DatabaseManager.php';

    $semisters = DatabaseManager::getSemesters($batch);
	while($row = mysqli_fetch_array($semisters)){
		echo '<option value="'.$row['semester_id'].'">'.$row['semester'].'</option>';
	}
?>