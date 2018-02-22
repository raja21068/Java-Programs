<?php
$user_name = $_REQUEST['uname'];
$password = $_REQUEST['pass'];
require_once 'DatabaseManager.php';
    $user = DatabaseManager::getAdmin($user_name, $password);
	if(mysqli_num_rows($user) > 0){
		if($row = mysqli_fetch_array($user)){
			setcookie("user", $row['admin_id'], time()+3600);
			header("Location: admin.php?error=1");
		}
	}
	else{
		header("Location: index.php?error=1");
	}
?>