<?php

require_once './DepartmentRequest.php';
require_once './DatabaseManager.php';

$requestType = $_REQUEST['request'];

if ($requestType == RequestType::$REQUEST_GET_ALL_TEACHER) {
    $department_id = $_POST['departments'];
    $teachers = DatabaseManager::getTeachers($department_id);
    while ($row = mysqli_fetch_array($teachers)) {
        echo '<option value="' . $row['teacher_id'] . '">' . $row['name'] . '</option>';
    }
} else if ($requestType == RequestType::$REQUEST_GET_TEACHER_BEAN) {
    $teacher_id = $_POST['teacher_id'];
    $result = DatabaseManager::get_teacher_data($teacher_id);
    if ($row = mysqli_fetch_array($result)) {
        echo json_encode($row);
    }
} else if ($requestType == RequestType::$REQUEST_ADD_TEACHER) {
    $dept_id = $_REQUEST['dept_id'];
    $name = $_REQUEST['name'];
    $fname = $_REQUEST['fname'];
    $surname = $_REQUEST['surname'];
    $nic = $_REQUEST['nic'];
    $mobile_no = $_REQUEST['mobile_no'];
    $password = $_REQUEST['password'];
    $pay_scill = $_REQUEST['pay_scill'];
    $email = $_REQUEST['email'];
    $name_code = $_REQUEST['name_code'];
    $result = DatabaseManager::addTeacher($dept_id, $name, $fname, $surname, $nic, $mobile_no, $password, $pay_scill, $email, $name_code);
    if ($result) {
        $resultMax = DatabaseManager::getMaxTeacherId();
        if ($row = mysqli_fetch_array($resultMax)) {
            echo json_encode($row);
        }
    }
} else if ($requestType == RequestType::$REQUEST_DELETE_TEACHER) {
    $teacher_id = $_REQUEST['teacher_id'];
    $result = DatabaseManager::deleteTeacher($teacher_id);
    if ($result) {
        echo "OK";
    } else {
        echo "NOT OK";
    }
} else if ($requestType == RequestType::$REQUEST_UPDATE_TEACHER) {
    $teacher_id = $_REQUEST['teacher_id'];
    $name = $_REQUEST['name'];
    $fname = $_REQUEST['fname'];
    $surname = $_REQUEST['surname'];
    $nic = $_REQUEST['nic'];
    $mobile_no = $_REQUEST['mobile_no'];
    $password = $_REQUEST['password'];
    $pay_scill = $_REQUEST['pay_scill'];
    $email = $_REQUEST['email'];
    $name_code = $_REQUEST['name_code'];
    $result = DatabaseManager::updateTeacher($teacher_id, $name, $fname, $surname, $nic, $mobile_no, $password, $pay_scill, $email, $name_code);
    if ($result) {
        echo "OK";
    } else {
        echo $result;
    }
}
?>