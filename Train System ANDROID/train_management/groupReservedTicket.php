<div class="page_navigator">
<div class="page_navigator">
<div class="pgui-pagination" data-total-record-count="1">

    <div class="pagination">
<?php echo '<ul><li><a class="define-page-size-butto" href="ticket.php?date='.$qdate.'&train_id='.$train_id.'&view=allReservedTicket.php">Toggle View</a></ul>'; ?>
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
                    if(isset($_GET['train_id'])){ $train_id = $_GET['train_id']; }
                    if(isset($_GET['date'])){$qdate = $_GET['date'];}else{$qdate = date("Y-m-d");}
                    $tickets = DatabaseManager::getGroupTicketReserved($train_id,$qdate);
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
                    <span >City From</span>
                    <i class="sort-icon"></i>
                </th>
                            <th class="sortable"
                    
                                        data-sort-url="ticket.php?order=apessanger"
                    data-field-caption="Pessanger"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >City To</span>
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
                    <span >Count</span>
                    <i class="sort-icon"></i>
                </th>
                            </tr>

    </thead>

<tbody>
	<tr class="new-record-row" style="display: none;" data-new-row="false">

        
        
        
                            <td data-column-name="train_name"></td>
                            <td data-column-name="date_of_train"></td>
                            <td data-column-name="city_from"></td>
                            <td data-column-name="city_to"></td>
                            <td data-column-name="bogie_name"></td>
                            <td data-column-name="count"></td>
                        </tr>
    <?php
        while($row = mysqli_fetch_array($tickets, MYSQL_NUM)){
            ?>
            <tr class="pg-row" style="">
                    <td data-column-name="train_name" style="" class="foreign-key sortable"><?php echo $row[0]; ?></td>
                    <td data-column-name="date_of_train" style="" class="foreign-key sortable"><?php echo $row[1]; ?></td>
                    <td data-column-name="city_from" style="" class="foreign-key sortable"><?php echo $row[2]; ?></td>
                    <td data-column-name="city_to" style="" class="foreign-key sortable"><?php echo $row[3]; ?></td>
                    <td data-column-name="bogie_name" style="" class="foreign-key sortable"><?php echo $row[4]; ?></td>
                    <td data-column-name="bogie_name" style="" class="foreign-key sortable"><?php echo $row[5]; ?></td>
            </tr>
            <?php
        }
    ?>

    <tr class="empty-grid hide">
        <td colspan="10" class="empty-grid">
            There are no records to display
        </td>
    </tr>

</tbody>

<tfoot>
    
    </tfoot>

</table>
