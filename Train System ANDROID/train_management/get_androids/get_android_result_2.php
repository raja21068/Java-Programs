<?php 
        $bogie_name = "";
        $json = array();
require_once '../class.DatabaseManager.php';
if(isset($_REQUEST['train_id'])){ $train_id = $_REQUEST['train_id']; }else{$train_id = 1;}
        if(isset($_REQUEST['date'])){$qdate = $_REQUEST['date'];}else{$qdate = date("Y-m-d");}
        if(isset($_REQUEST['bogie_id'])){$bogie_id = $_REQUEST['bogie_id'];}else{$bogie_id = "b.bogies_id";}
        if(isset($_REQUEST['from'])){$from = $_REQUEST['from'];}else{$from = "_from" ;}
        if(isset($_REQUEST['to'])){$to = $_REQUEST['to'];}else{$to = "_to" ;}
        $tickets = DatabaseManager::getTotalByBogieType($train_id,$qdate,$bogie_id);
        $cities = DatabaseManager::getcitiesGo($train_id, $from, $to);
        $ticket = array();
        $count = 0;
        while($row = mysqli_fetch_array($tickets, MYSQL_NUM)){
            $ticket[$count] = $row;
            $count++;
        }
        $reserved_tickets = DatabaseManager::getReservedTickets($train_id,$qdate);
        $reserved = array();
        $count = 0;
        $color = "blue";
        $json_index = 0;
        while($row = mysqli_fetch_array($reserved_tickets)){
            $reserved[$count] = $row;
            $count++;
        }
        while($city = mysqli_fetch_array($cities)){
            foreach($ticket as $i => $row){
                foreach($reserved as $i => $reserved_ticket){
                    if($row[3] == $reserved_ticket['detail_id'] 
                            &&
(                            ($city['_from'] <= $reserved_ticket['_from'] && $city['_from'] < $reserved_ticket['_to'] && $city['_to'] > $reserved_ticket['_from'] && $city['_to'] <= $reserved_ticket['_to'])
||
                            ($city['_from'] <= $reserved_ticket['_from'] && $city['_from'] < $reserved_ticket['_to'] && $city['_to'] > $reserved_ticket['_from'] && $city['_to'] > $reserved_ticket['_to'])
||
                            ($city['_from'] > $reserved_ticket['_from'] && $city['_from'] > $reserved_ticket['_to'] && $city['_to'] > $reserved_ticket['_from'] && $city['_to'] == $reserved_ticket['_to'])
||
                            ($city['_to'] >= $reserved_ticket['_to'] && $city['_from'] <= $reserved_ticket['_from'])
                            ||
                            ($city['_to'] <= $reserved_ticket['_to'] && $city['_from'] >= $reserved_ticket['_from'])
                            ||
                            ($city['_to'] <= $reserved_ticket['_from'] && $city['_from'] >= $reserved_ticket['_from'])
                            ||
                            ($city['_to'] == $reserved_ticket['_to'])
                            ||
                            ($city['_from'] == $reserved_ticket['_from'])
                            ||
                            ($city['_from'] > $reserved_ticket['_from'] && $city['_from'] < $reserved_ticket['_to']))
                            ){
                        $row[5] = $row[5] - $reserved_ticket['count'];
                    }
                }
                if(!($row[2] == $bogie_name)){
                    $json_index++;
                }
                $bogie_name = $row[2];
                $my_row['bogie_name'] = $row[2];
                $my_row['from'] = $city['city_from'];
                $my_row['to'] = $city['city_to'];
                $my_row[$row[4]] = $row[5];
                $json["a$json_index"] = $my_row;
            }
        }
                echo json_encode($json);
        ?>