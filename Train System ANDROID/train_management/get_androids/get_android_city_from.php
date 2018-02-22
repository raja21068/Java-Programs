<?php
require '../class.DatabaseManager.php';
    $train_id = $_POST['train_id'];
//    $train_id = 1;
    $cities = DatabaseManager::getCitiesGoFrom($train_id);
    for($i=0;$row = mysqli_fetch_array($cities);$i++){
        $response["a$i"] = $row;
    }
    echo json_encode($response);
?>