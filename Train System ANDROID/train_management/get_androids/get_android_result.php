<?php 
require_once './class.DatabaseManager.php';

$train_id = $_POST['train_id'];
$qdate = $_POST['date'];
$bogie_id = $_POST['bogie_id'];
$detail_id = $_POST['detail_id'];
$tickets = DatabaseManager::getTotalBydetail($train_id,$qdate,$bogie_id, $detail_id);

                    $ticket = array();
        $count = 0;
        while($row = mysqli_fetch_array($tickets, MYSQL_NUM)){
            $ticket[$count] = $row;
            $count++;
        }
        $cities = DatabaseManager::getcitiesGo($train_id, $_POST['from'], $_POST['to']);
        $reserved_tickets = DatabaseManager::getReservedTickets($train_id,$qdate);
        $reserved = array();
        $count = 0;
        while($row = mysqli_fetch_array($reserved_tickets)){
            $reserved[$count] = $row;
            $count++;
        }
        while($city = mysqli_fetch_array($cities)){
            foreach($ticket as $i => $row){
                foreach($reserved as $i => $reserved_ticket){
                    if($row[3] == $reserved_ticket['detail_id'] && $row[4] == $reserved_ticket['seat_type']
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
            ?>
                <tr class="pg-row" style="">
                    <td data-column-name="train_name" style="" class="foreign-key sortable"><?php echo $row[0]; ?></td>
                    <td data-column-name="date_of_train" style="" class="foreign-key sortable"><?php echo $row[1]; ?></td>
                    <td data-column-name="bogie_name" style="" class="foreign-key sortable"><?php echo $row[2]; ?></td>
                    <td data-column-name="detail_id" style="" class="foreign-key sortable"><?php echo $row[3]; ?></td>
                    <td data-column-name="count" style="" class="foreign-key sortable"><?php echo $row[5]; ?></td>
                    <td data-column-name="From" style="" class="foreign-key sortable"><?php echo $city['city_from']; ?></td>
                    <td data-column-name="TO" style="" class="foreign-key sortable"><?php echo $city['city_to']; ?></td>
                    <td data-column-name="seats_available" style="" class="foreign-key sortable"><?php echo $row[4]; ?></td>
                </tr>
            <?php
            }
        }
        ?>