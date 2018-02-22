<?php
require '../class.DatabaseManager.php';
    $train_id = $_POST['train_id'];
    $from = $_POST['city_from'];
    $cities = DatabaseManager::getCitiesGoTo($train_id, $from);
    for($i=0;$row = mysqli_fetch_array($cities);$i++){
        $response["a$i"] = $row;
    }
    echo json_encode($response);
?>