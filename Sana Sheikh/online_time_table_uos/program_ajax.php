<?php

require_once './DepartmentRequest.php';
require_once './DatabaseManager.php';

$requestType = $_REQUEST['request'];

if ($requestType == RequestType::$REQUEST_GET_ALL_PROGRAMS) {
    $department_id = $_REQUEST['department_id'];
    $prog_data = DatabaseManager::getPrograms($department_id);
    while ($row = mysqli_fetch_array($prog_data)) {
        echo "<option value='".$row['prog_id']."'>".$row['prog_tittle']."</option>";
    }
}
else if ($requestType == RequestType::$REQUEST_GET_PROGRAMS_BEAN) {
    $prog_id = $_REQUEST['prog_id'];
    $prog_data = DatabaseManager::get_prog_data($prog_id);
    if ($row = mysqli_fetch_array($prog_data)) {
        echo json_encode($row);
    }
} else if ($requestType == RequestType::$REQUEST_ADD_PROGRAMS) {
    
    $dept_id = $_REQUEST['dept_id'];
    $program_tittle = $_REQUEST['program_tittle'];
    $degree_tittle = $_REQUEST['degree_tittle'];
    $result = DatabaseManager::addProgram($dept_id, $program_tittle, $degree_tittle);
    if ($result) {
        $resultMax = DatabaseManager::getMaxProgramId();
        if ($row = mysqli_fetch_array($resultMax)) {
            echo json_encode($row);
        }
    }
} else if ($requestType == RequestType::$REQUEST_DELETE_PROGRAMS) {
    $prog_id = $_REQUEST['prog_id'];
    $result = DatabaseManager::deleteProgram($prog_id);
    if ($result) {
        echo "OK";
    } else {
        echo "NOT OK";
    }
} else if ($requestType == RequestType::$REQUEST_UPDATE_PROGRAMS) {
    $prog_id = $_REQUEST['prog_id'];
    $prog_tittle = $_REQUEST['prog_tittle'];
    $degree_tittle = $_REQUEST['degree_tittle'];

    $result = DatabaseManager::updateProgram($prog_id, $prog_tittle, $degree_tittle);
    if ($result) {
        echo "OK";
    } else {
        echo $result;
    }
}
?>