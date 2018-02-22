    <option value="">Please select...</option>
<?php
$programs = $_REQUEST['prog_id'];
require_once 'DatabaseManager.php';

    $part = DatabaseManager::getpart($programs);
	while($row = mysqli_fetch_array($part)){
		echo '<option value="'.$row['part_id'].'">'.$row['part'].' '.$row['shift_name'].'</option>';
	}
?>