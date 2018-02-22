<?php
    require_once './DepartmentRequest.php';
    require_once './DatabaseManager.php';

    $requestType = $_REQUEST['request'];
    
    if($requestType == RequestType::$REQUEST_GET_DEPARTMENT_BEAN){
        $departmentId = $_REQUEST['dept_id'];
        $result = DatabaseManager::getDepartment($departmentId);
        if($row = mysqli_fetch_array($result)){
            echo json_encode($row);
        }
    }
    
    else if($requestType == RequestType::$REQUEST_ADD_DEPARTMENT){
        $name = $_REQUEST['dept_name'];
        $code = $_REQUEST['code'];
        $remarks = $_REQUEST['remarks'];
        $result = DatabaseManager::addDepartment($name, $code, $remarks);
        if($result){
            echo DatabaseManager::getMaxDepartmentId();
        }
    }
    
    else if($requestType == RequestType::$REQUEST_DELETE_DEPARTMENT){
        $departmentId = $_REQUEST['dept_id'];
        $result = DatabaseManager::deleteDepartment($departmentId);
        if($result){
            echo "OK";
        }
    }
    
    else if($requestType == RequestType::$REQUEST_UPDATE_DEPARTMENT){
        $departmentId = $_REQUEST['dept_id'];
        $name = $_REQUEST['dept_name'];
        $code = $_REQUEST['code'];
        $remarks = $_REQUEST['remarks'];
        $result = DatabaseManager::updateDepartment($departmentId, $name, $code, $remarks);
        if($result){
            echo "OK";
        }else{
            echo "NOT OK";
        }
    }
?>
