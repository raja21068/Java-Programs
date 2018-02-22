    <option value="">Please select...</option>
<?php
$dept_id = $_REQUEST['departments'];
require_once 'DatabaseManager.php';

    $programs = DatabaseManager::getPrograms($dept_id);
	while($row = mysqli_fetch_array($programs)){
		echo '<option value="'.$row['prog_id'].'">'.$row['prog_tittle'].'</option>';
	}
?>