<?php
$user_name = $_REQUEST['uname'];
$password = $_REQUEST['pass'];
require_once 'DatabaseManager.php';
    $user = DatabaseManager::getAdmin($user_name, $password);
	if(mysqli_num_rows($user) > 0){
		if($row = mysqli_fetch_array($user)){
			$type = $row['is_super_admin'];
			$dept = $row['department_dept_id'];
                        setcookie("user", $row['admin_id'], time()+3600);
			setcookie("user_type", $type);
			setcookie("dept",$dept);
                        $result = DatabaseManager::getDepartment($dept);
                        if($deptBean = mysqli_fetch_array($result)){
                            $depName = $deptBean['dept_name'];
                            setcookie("deptName", $depName);
                        }
                        if($type == DatabaseManager::$SUPER_ADMIN){
				header("Location: super_admin.php?error=1");
			}else{
				header("Location: admin.php?error=0&deptName=".$depName);
			}
		}
	}
	else{
		header("Location: index.php?error=1");
	}
?>