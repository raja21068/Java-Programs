<?php

require_once './DepartmentRequest.php';
require_once './DatabaseManager.php';

$requestType = $_REQUEST['request'];

if ($requestType == RequestType::$REQUEST_GET_ALL_PART) {
    $prog_id = $_REQUEST['prog_id'];
    if (isset($_REQUEST['shift_id'])) {
        $shift_id = $_REQUEST['shift_id'];
        $courses = DatabaseManager::getPartByShift($prog_id,$shift_id);
    } else {
        $courses = DatabaseManager::getpart($prog_id);
    }
    while ($row = mysqli_fetch_array($courses)) {
        echo '<option value="' . $row['part_id'] . '">' . $row['part'] . '-' . $row['group_desc'] . '</option>';
    }
} else if ($requestType == RequestType::$REQUEST_GET_PART_BEAN) {
    $part_id = $_REQUEST['part_id'];
    $course_data = DatabaseManager::get_part_data($part_id);
    if ($row = mysqli_fetch_array($course_data)) {
        echo json_encode($row);
    }
} else if ($requestType == RequestType::$REQUEST_ADD_PART) {
    $prog_id = $_REQUEST['program_part'];
    $part = $_REQUEST['part'];
    $shift = $_REQUEST['shift'];
    $remarks = $_REQUEST['remarks'];
    $group_desc = $_REQUEST['group_desc'];
    $result = DatabaseManager::addpart($prog_id, $part, $shift, $remarks, $group_desc);
    if ($result) {
        $resultMax = DatabaseManager::getMaxPartId();
        if ($row = mysqli_fetch_array($resultMax)) {
            echo json_encode($row);
        }
    } else {
        $response['part_id'] = -1;
        echo json_encode($response);
    }
} else if ($requestType == RequestType::$REQUEST_DELETE_PART) {
    $part_id = $_REQUEST['part_id'];
    $result = DatabaseManager::deletepart($part_id);
    if ($result) {
        echo "OK";
    } else {
        echo "NOT OK";
    }
} else if ($requestType == RequestType::$REQUEST_UPDATE_PART) {
    $part_id = $_REQUEST['part_id'];
    $part = $_REQUEST['part'];
    $shift = $_REQUEST['shift'];
    $remarks = $_REQUEST['remarks'];
    $group_desc = $_REQUEST['group_desc'];
    $result = DatabaseManager::updatepart($part_id, $part, $shift, $remarks, $group_desc);
    if ($result) {
        echo "OK";
    } else {
        echo $result;
    }
}
?>