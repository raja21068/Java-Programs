<?php

require_once './DepartmentRequest.php';
require_once './DatabaseManager.php';

$requestType = $_REQUEST['request'];

if ($requestType == RequestType::$REQUEST_GET_ALL_ROOM) {
    $dept_id = $_REQUEST['dept_id'];
    $rooms = DatabaseManager::getRooms($dept_id);
    while ($row = mysqli_fetch_array($rooms)) {
        echo '<option value="' . $row['room_id'] . '">' . $row['room_name'] . '</option>';
    }
} else if ($requestType == RequestType::$REQUEST_GET_ROOM_BEAN) {
    $room_id = $_REQUEST['room_id'];
    $room_data = DatabaseManager::get_room_data($room_id);
    if ($row = mysqli_fetch_array($room_data)) {
        echo json_encode($row);
    }
} else if ($requestType == RequestType::$REQUEST_ADD_ROOM) {
    $dept_id = $_REQUEST['dept_id'];
    $room_name = $_REQUEST['room_name'];
    $result = DatabaseManager::addRoom($dept_id, $room_name);
    if ($result) {
        $resultMax = DatabaseManager::getMaxRoomId();
        if ($row = mysqli_fetch_array($resultMax)) {
            echo json_encode($row);
        }
    } else {
        $response['course_id'] = -1;
        echo json_encode($response);
    }
} else if ($requestType == RequestType::$REQUEST_DELETE_ROOM) {
    $room_id = $_REQUEST['room_id'];
    $result = DatabaseManager::deleteRoom($room_id);
    if ($result) {
        echo "OK";
    } else {
        echo "NOT OK";
    }
} else if ($requestType == RequestType::$REQUEST_UPDATE_ROOM) {
    $room_id = $_REQUEST['room_id'];
    $room_name = $_REQUEST['room_name'];
    $result = DatabaseManager::updateRoom($room_id, $room_name);
    if ($result) {
        echo "OK";
    } else {
        echo $result;
    }
}
?>