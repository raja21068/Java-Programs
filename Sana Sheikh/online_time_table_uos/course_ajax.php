<?php

require_once './DepartmentRequest.php';
require_once './DatabaseManager.php';

$requestType = $_REQUEST['request'];

if ($requestType == RequestType::$REQUEST_GET_ALL_COURSE) {
    $part_id = $_REQUEST['part_id'];
    $semester = $_REQUEST['semester'];
    $courses = DatabaseManager::getcourse($part_id, $semester);
    while ($row = mysqli_fetch_array($courses)) {
        echo '<option value="' . $row['course_id'] . '">' . $row['course_name'] . '</option>';
    }
} else if ($requestType == RequestType::$REQUEST_GET_COURSE_BEAN) {
    $course_id = $_POST['course_id'];
    $course_data = DatabaseManager::get_course_data($course_id);
    if ($row = mysqli_fetch_array($course_data)) {
        echo json_encode($row);
    }
} else if ($requestType == RequestType::$REQUEST_ADD_COURSE) {
    $part_id = $_REQUEST['course_part_list'];
    $semester = $_REQUEST['semester'];
    $course_code = $_REQUEST['course_code'];
    $course_name = $_REQUEST['course_name'];
    $remarks = $_REQUEST['remarks'];
    $result = DatabaseManager::addCourse($part_id, $course_code, $course_name, $remarks, $semester);
    if ($result) {
        $resultMax = DatabaseManager::getMaxCourseId();
        if ($row = mysqli_fetch_array($resultMax)) {
            echo json_encode($row);
        }
    } else {
        $response['course_id'] = -1;
        echo json_encode($response);
    }
} else if ($requestType == RequestType::$REQUEST_DELETE_COURSE) {
    $course_id = $_REQUEST['course_id'];
    $result = DatabaseManager::deleteCourse($course_id);
    if ($result) {
        echo "OK";
    } else {
        echo "NOT OK";
    }
} else if ($requestType == RequestType::$REQUEST_UPDATE_COURSE) {
    $course_id = $_REQUEST['course_id'];
    $course_code = $_REQUEST['course_code'];
    $course_name = $_REQUEST['course_name'];
    $remarks = $_REQUEST['remarks'];

    $result = DatabaseManager::updateCourse($course_id, $course_code, $course_name, $remarks);
    if ($result) {
        echo "OK";
    } else {
        echo $result;
    }
}
?>