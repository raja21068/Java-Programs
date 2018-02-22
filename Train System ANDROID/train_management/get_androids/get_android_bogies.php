<?php
require 'class.DatabaseManager.php';
    $trains = DatabaseManager::getTrains();
    $train = array();
    $train_id = array();
    $remarks = array();
    for($i=0;$row = mysqli_fetch_array($trains);$i++){
        $response["a$i"] = $row;
    }
    echo json_encode($response);
?>