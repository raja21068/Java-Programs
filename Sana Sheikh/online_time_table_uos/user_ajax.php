<?php

require_once './DepartmentRequest.php';
require_once './DatabaseManager.php';

$requestType = $_REQUEST['request'];

if ($requestType == RequestType::$REQUEST_GET_USER_BEAN) {
    $userId = $_REQUEST['user_id'];
    $result = DatabaseManager::getUserBean($userId);
    if ($row = mysqli_fetch_array($result)) {
        echo json_encode($row);
    }
}

else if ($requestType == RequestType::$REQUEST_ADD_USER) {
    $name = $_REQUEST['name'];
    $fatherName = $_REQUEST['fathers_name'];
    $surname = $_REQUEST['surname'];
    $address = $_REQUEST['address'];
    $adminType = $_REQUEST['admin_type'];
    $username = $_REQUEST['username'];
    $password = $_REQUEST['password'];
    $deptId = $_REQUEST['department_dept_id'];
    $isSuperAdmin = $_REQUEST['is_super_admin'];
    $cellNo = $_REQUEST['cell_no'];
    $result = DatabaseManager::addUser($name, $fatherName, $surname, $address, $cellNo, $username, $password, $deptId,$adminType ,$isSuperAdmin);
    if ($result) {
        $resultMax = DatabaseManager::getMaxUserId();
        if ($row = mysqli_fetch_array($resultMax)) {
            echo json_encode($row);
        }
    }else{
        $resp = array();
        $resp["admin_id"] = -1;
        echo json_encode($resp);
    }
  
}
else if ($requestType == RequestType::$REQUEST_UPDATE_USER) {
    $userId = $_REQUEST['admin_id'];
    $name = $_REQUEST['name'];
    $fatherName = $_REQUEST['fathers_name'];
    $surname = $_REQUEST['surname'];
    $address = $_REQUEST['address'];
    $adminType = $_REQUEST['admin_type'];
    $username = $_REQUEST['username'];
    $password = $_REQUEST['password'];
    $deptId = $_REQUEST['department_dept_id'];
    $isSuperAdmin = $_REQUEST['is_super_admin'];
    $cellNo = $_REQUEST['cell_no'];
    $result = DatabaseManager::updateUser($userId,$name, $fatherName, $surname, $address, $cellNo, $username, $password, $deptId,$adminType,$isSuperAdmin);
    if ($result) {
        echo "OK";
    }else{
        echo "NOT OK";
    }
  
}

else if ($requestType == RequestType::$REQUEST_DELETE_USER) {
    $userId = $_REQUEST['admin_id'];
    $result = DatabaseManager::deleteUser($userId);
    if ($result) {
        echo "OK";
    }else{
        echo "NOT OK";
    }
  
}

?>
