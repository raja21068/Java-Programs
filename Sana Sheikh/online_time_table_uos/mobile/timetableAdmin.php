
<?php
require_once "../DatabaseManager.php";
$timezone = date_default_timezone_get();
date_default_timezone_set('Asia/Karachi');
$time = date('h:i', time());
	$program = "";
	$part = "";
	$shift = "";
	$day = "";
	$teacher = "";
	$cell_no="1234567890";
	if(isset($_REQUEST['program'])){ $program = "'".$_REQUEST['program']."'"; } else{ $program = "pr.degree_tittle";}
	if(isset($_REQUEST['day'])){ $day = "'".$_REQUEST['day']."'"; } else{ $day = "d.days_name";}
	if(isset($_REQUEST['cell_no'])){ $cell_no = $_REQUEST['cell_no']; } else{return;}
	

$department_id = DatabaseManager::getDepartment_id($program);

	$time_table = DatabaseManager::getTimeTableAdmin($program, $day, $time);
	$response["cell_no"] = "$cell_no";
	$message = "";
while($row=mysqli_fetch_array($time_table))  {
	$message = $message .  $row['name'] . ": \t";
	$message = $message .  $row['room_name'] . "\n";
}
	$response['message'] = $message;
    echo json_encode($response);
?>
