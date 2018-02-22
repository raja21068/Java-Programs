<div class="page_navigator">
<div class="page_navigator">
<div class="pgui-pagination" data-total-record-count="1">

    <div class="pagination">
<?php 
require_once './class.DatabaseManager.php';
//echo '<ul><li><a class="define-page-size-butto" href="ticket.php?date='.$qdate.'&train_id='.$train_id.'&view=allReservedTicket.php">Toggle View</a></ul>'; 
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
                <?php         
                    $train_id = $_POST['train_id'];
                    $qdate = $_POST['date'];
                    $bogie_id = $_POST['bogie_id'];
                    $detail_id = $_POST['detail_id'];
                    $tickets = DatabaseManager::getTotalBydetail($train_id,$qdate,$bogie_id, $detail_id);
                ?>

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

</tbody>

<tfoot>
    
    </tfoot>

</table>
