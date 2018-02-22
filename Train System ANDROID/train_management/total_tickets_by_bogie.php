<div class="page_navigator">
<div class="page_navigator">
<div class="pgui-pagination" data-total-record-count="1">

    <div class="pagination">
<?php 
require_once './class.DatabaseManager.php';
?>
    </div>

</div>
</div>
</div>

    <table
    id="ticketGrid"
    class="pgui-grid grid legacy stripped"
    data-grid-hidden-values="[]"
    data-inline-edit="{ &quot;enabled&quot;:&quot;true&quot;, &quot;request&quot;:&quot;ticket.php&quot}"
        data-delete-selected-action="ticket.php" data-grid-quick-filter-value="">
<thead>
    <tr class="addition-block messages hide">
        <td colspan="12">
                        
        </td>
    </tr>

    <tr class="header">
    
    
            
    <!-- <Grid Head Columns> -->
                <th class="foreign-key sortable"
                    
                                        data-sort-url="ticket.php?order=afrom_rout_id_city_id"
                    data-field-caption="From Rout Id"
                    data-comment="">
                    <span >Train Name</span>
                    <i class="sort-icon"></i>
                </th>
                            <th class="foreign-key sortable"
                    
                                        data-sort-url="ticket.php?order=ato_rout_id_city_id"
                    data-field-caption="To Rout Id"
                    data-comment="">
                    <span >Date</span>
                    <i class="sort-icon"></i>
                </th>
                            <th class="sortable"
                    
                                        data-sort-url="ticket.php?order=apessanger"
                    data-field-caption="Pessanger"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >Bogie</span>
                    <i class="sort-icon"></i>
                </th>
                            <th class="sortable"
                    
                                        data-sort-url="ticket.php?order=apessanger"
                    data-field-caption="Pessanger"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >Detail Id</span>
                    <i class="sort-icon"></i>
                </th>

               <th class="sortable"
                    
                                        data-sort-url="ticket.php?order=apessanger"
                    data-field-caption="Pessanger"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >count</span>
                    <i class="sort-icon"></i>
                </th>


                            <th class="sortable"
                    
                                        data-sort-url="ticket.php?order=apessanger"
                    data-field-caption="Pessanger"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >From</span>
                    <i class="sort-icon"></i>
                </th>

                            <th class="sortable"
                    
                                        data-sort-url="ticket.php?order=apessanger"
                    data-field-caption="Pessanger"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >To</span>
                    <i class="sort-icon"></i>
                </th>

                <th class="sortable"
                    
                                        data-sort-url="ticket.php?order=apessanger"
                    data-field-caption="Pessanger"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >Seats Available</span>
                    <i class="sort-icon"></i>
                </th>
                            </tr>

    </thead>

<tbody>
	<tr class="new-record-row" style="display: none;" data-new-row="false">

        
        
        
                            <td data-column-name="train_name"></td>
                            <td data-column-name="date_of_train"></td>
                            <td data-column-name="bogie_name"></td>
                            <td data-column-name="detail_id"></td>
                            <td data-column-name="count"></td>
                            <td data-column-name="from"></td>
                            <td data-column-name="to"></td>
                            <td data-column-name="count"></td>
                        </tr>
    <?php
        if(isset($_GET['train_id'])){ $train_id = $_POST['train_id']; }else{$train_id = 1;}
        if(isset($_POST['date'])){$qdate = $_POST['date'];}else{$qdate = date("Y-m-d");}
        if(isset($_POST['bogie_id'])){$bogie_id = $_POST['bogie_id'];}else{$bogie_id = "b.bogies_id";}
        if(isset($_POST['from'])){$from = $_POST['from'];}else{$from = "_from" ;}
        if(isset($_POST['to'])){$to = $_POST['to'];}else{$to = "_to" ;}
        $tickets = DatabaseManager::getTotalByBogie($train_id,$qdate,$bogie_id);
        $cities = DatabaseManager::getcitiesGo($train_id, $from, $to);
        $ticket = array();
        $count = 0;
        while($row = mysqli_fetch_array($tickets, MYSQL_NUM)){
            $ticket[$count] = $row;
            $count++;
        }
        
//        $routes = DatabaseManager::get_from_to_routes($city['_from'], $city['_to'], $train_id);
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
//                    echo '<br />' . $row[3] . ' == ' . $reserved_ticket['detail_id'] . '<br /> 
//                            &&' .
//                            $city['_from'] . ' <= ' . $reserved_ticket['_from'] . '<br />
//                            &&' .
//                            $city['_to'] . ' >= ' . $reserved_ticket['_to'] . '<br />'.
//                            '||<br />'.
//                            $city['_from'] . ' >= ' . $reserved_ticket['_from'] . '<br />
//                            &&' .
//                            $city['_to'] . ' <= ' . $reserved_ticket['_to'] . '<br />';
                    
//                    if($row[3] == $reserved_ticket['detail_id'] 
//                            &&
//                            ($city['_to'] >= $reserved_ticket['_to'] && $city['_from'] <= $reserved_ticket['_from'])
//                            ||
//                            ($city['_to'] <= $reserved_ticket['_to'] && $city['_from'] >= $reserved_ticket['_from'])
//                            ||
//                            (($city['_to'] >= $reserved_ticket['_to'] && $city['_from'] <= $reserved_ticket['_to'])
//                            ||
//                            ($city['_to'] <= $reserved_ticket['_from'] && $city['_from'] >= $reserved_ticket['_from']))
//                       ){
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

</tbody>

<tfoot>
    
    </tfoot>

</table>
