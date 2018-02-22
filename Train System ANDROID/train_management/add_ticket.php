
<?php

 $no_of_seat = $_POST['no_of_seat'];
 $from = $_POST['from_rout_id_edit'];
 $to = $_POST['to_rout_id_edit'];
 $bogie_id = $_POST['bogie_id_edit'];
 $detail_id = $_POST['detail_id'];
 $seat_type = $_POST['seat_birth'];
 $pessanger = $_POST['pessanger_edit'];
 $qdate = $_POST['date'];
 $train_id = $_POST['train_id'];

// echo "
//no_of_seat: $no_of_seat <br>
//from: $from <br>
//to: $to <br>
//bogie: $bogie_id <br>
//detail_id: $detail_id <br>
//seat_birth $seat_type <br>
//passanger $pessanger <br>
//qdate: $qdate <br>
//train_id: $train_id <br> ";
 
 
require "class.DatabaseManager.php";
$from_to = DatabaseManager::get_from_to_routes($from, $to, $train_id);
//$reserved = DatabaseManager::getReservedTicketsByDetail_id($detail_id);
//$i=0;
//while($row = mysqli_fetch_array($reserved)){
  //  $reserved_array[$i] = $row;
    //$i++;
//}

//$tickets = DatabaseManager::getReservedTickets($train_id,$qdate);
//$tickets = DatabaseManager::getTicketsForAdding($detail_id, $seat_type);
$tickets = DatabaseManager::getTotalBydetailAll($train_id,$qdate,$bogie_id, $detail_id);
        $ticket = array();
        $count = 0;
        while($row = mysqli_fetch_array($tickets)){
            $ticket[$count] = $row;
            $count++;
        }
        $cities = DatabaseManager::getcitiesGo($train_id, $from, $to);
        $reserved_tickets = DatabaseManager::getReservedTicketsAll($train_id,$qdate);
        $reserved = array();
        $count = 0;
        while($row = mysqli_fetch_array($reserved_tickets)){
            $reserved[$count] = $row;
            $count++;
        }
        $added = 0;
        ?>
<table border =1 ><?php
        while($city = mysqli_fetch_array($cities)){
            foreach($ticket as $i => $row){
                                            $color="black";
                foreach($reserved as $i => $reserved_ticket){

//                    if($row['detail_id'] == $reserved_ticket['detail_id'] && $row['seat_type'] == $reserved_ticket['seat_type']
                    if($row['seat_id'] == $reserved_ticket['seat_id']
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
//                        $row[5] = $row[5] - $reserved_ticket['count'];
//                        continue;
                        $color="red";
                    }
                }
            if($color == "black" && $row['seat_type'] == $seat_type && $added<$no_of_seat){
                $added++;
                DatabaseManager::addTicket($from_to['from'], $from_to['to'], $detail_id, $row['seat_id'], $pessanger);
            ?>
                <tr class="pg-row" style="">
                    <td data-column-name="train_name" style="" class="foreign-key sortable"><?php echo $row['train_name']; ?></td>
                    <td data-column-name="date_of_train" style="" class="foreign-key sortable"><?php echo $row['date_of_train']; ?></td>
                    <td data-column-name="bogie_name" style="" class="foreign-key sortable"><?php echo $row['bogie_name']; ?></td>
                    <td data-column-name="detail_id" style="" class="foreign-key sortable"><?php echo $row['detail_id']; ?></td>
                    <td data-column-name="seat_id" style="" class="foreign-key sortable"><?php echo "<font color=$color>"; echo $row['seat_id']; echo "</font>";?></td>
                    <td data-column-name="From" style="" class="foreign-key sortable"><?php echo $city['city_from']; ?></td>
                    <td data-column-name="TO" style="" class="foreign-key sortable"><?php echo $city['city_to']; ?></td>
                    <td data-column-name="seats_available" style="" class="foreign-key sortable"><?php echo $row['seat_type']; ?></td>
                </tr>
            <?php
            
            }
            }
        }
?>
</table>