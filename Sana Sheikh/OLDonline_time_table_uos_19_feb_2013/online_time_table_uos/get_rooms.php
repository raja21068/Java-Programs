    <option value="">Please select...</option>
<?php
$dept_id = $_REQUEST['departments'];
require_once 'DatabaseManager.php';

    $rooms = DatabaseManager::getRooms($dept_id);
	while($row = mysqli_fetch_array($rooms)){
		echo '<option value="'.$row['room_id'].'">'.$row['room_name'].'</option>';
	}
?>