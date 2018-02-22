<div class="page_navigator">
<div class="page_navigator">
<div class="pgui-pagination" data-total-record-count="1">

    <div class="pagination">
<?php echo '<ul><li><a class="define-page-size-butto" href="ticket.php?date='.$qdate.'&train_id='.$train_id.'&view=groupReservedTicket.php">Toggle View</a></ul>'; ?>
    </div>

</div>
</div>
</div>
<!-- </Pages> -->

    <table
    id="ticketGrid"
    class="pgui-grid grid legacy stripped"
    data-grid-hidden-values="[]"
    data-inline-edit="{ &quot;enabled&quot;:&quot;true&quot;, &quot;request&quot;:&quot;ticket.php&quot}"
        data-delete-selected-action="ticket.php" data-grid-quick-filter-value="">
<thead>
        <tr>
        <td colspan="12" class="header-panel">
            <div class="btn-toolbar pull-left">
                <div class="btn-group">
                <?php         
                    $tickets = DatabaseManager::getTicketReserved($train_id,$qdate);
                    echo'<a class="btn" href="ticket.php?operation=insert&date='.$qdate.'&train_id='.$train_id.'">';
                ?>                
                            <i class="pg-icon-add-record"></i>
                            Add new
                        </a>
                                    
                    
            <?php echo '<a class="btn" href="ticket.php?date='.$qdate.'&train_id='.$train_id.'">'; ?>
                            <i class="pg-icon-page-refresh"></i>
                            Refresh
                        </a>
                    <?php
                        require_once './class.DatabaseManager.php';
                        $d = DatabaseManager::getDates($train_id);
                        while($row = mysqli_fetch_array($d)){
                            $date = $row['date_of_train'];
                            if($date == date("Y-m-d")){
                            echo '
                            <a class="btn" href="ticket.php?date='.$date.'&train_id='.$train_id.'">
                                <i class="pg-icon-page-today"></i>
                                '.$date.'
                            </a>';                                
                            }
                            else{
                            echo '
                            <a class="btn" href="ticket.php?date='.$date.'&train_id='.$train_id.'">
                                <i class="pg-icon-page-no-today"></i>
                                '.$date.'
                            </a>';
                            } 
                        }
                    ?>
                                    </div>
            </div>

                        <div id="quick-filter-toolbar" class="btn-toolbar pull-right">
                <div class="btn-group">
                    <div class="input-append" style="float: left; margin-bottom: 0;">
                        <input placeholder="Quick search" type="text" size="16" class="quick-filter-text" value=""><button type="button" class="btn quick-filter-go"><i class="pg-icon-quick-find"></i></button><button type="button" class="btn quick-filter-reset"><i class="pg-icon-filter-reset"></i></button>
                    </div>
                </div>
            </div>
                    </td>
    </tr>
    
    <tr class="addition-block messages hide">
        <td colspan="12">
                        
        </td>
    </tr>

    <tr class="header">
    
    
            
    <!-- <Grid Head Columns> -->
                        <th colspan="4">
                Actions
            </th>
                                                <th class="primary-key sortable"
                    
                                        data-sort-url="ticket.php?order=aticket_id"
                    data-field-caption="Ticket Id"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >Ticket Id</span>
                    <i class="sort-icon"></i>
                </th>
                            <th class="sortable"
                    
                                        data-sort-url="ticket.php?order=aseat_no"
                    data-field-caption="Seat No"
                    data-comment="">
                    <i class="additional-info-icon"></i>
                    <span >Seat No</span>
                    <i class="sort-icon"></i>
                </th>
                            <th class="foreign-key sortable"
                    
                                        data-sort-url="ticket.php?order=adetail_id_schedule_id"
                    data-field-caption="Detail Id"
                    data-comment="">
                    <span >Passenger</span>
                    <i class="sort-icon"></i>
                </th>
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
                            </tr>

    </thead>

<tbody>
	<tr class="new-record-row" style="display: none;" data-new-row="false">

        
        
        
                            <td data-column-name="view"></td>
                            <td data-column-name="edit"></td>
                            <td data-column-name="delete"></td>
                            <td data-column-name="copy"></td>
                            <td data-column-name="ticket_id"></td>
                            <td data-column-name="seat_no"></td>
                            <td data-column-name="passenger"></td>
                            <td data-column-name="train_name"></td>
                            <td data-column-name="date_of_train"></td>
                            <td data-column-name="city_from"></td>
                            <td data-column-name="city_to"></td>
                            <td data-column-name="bogie_name"></td>
                        </tr>
    <?php
        while($row = mysqli_fetch_array($tickets, MYSQL_NUM)){
            ?>
            <tr class="pg-row" style="">
                    <td data-column-name="view" style="" class="data-operation"><span><a href="ticket.php?operation=view&amp;pk0=1" >View</a></span></td>
                    <td data-column-name="edit" style="" class="data-operation"><span><a href="ticket.php?operation=edit&amp;pk0=1" >Edit</a></span></td>
                    <td data-column-name="delete" style="" class="data-operation"><span><a href="ticket.php?operation=delete&amp;pk0=1"  data-modal-delete="true" data-delete-handler-name="ticket_modal_delete">Delete</a></span></td>
                    <td data-column-name="copy" style="" class="data-operation"><span><a href="ticket.php?operation=copy&amp;pk0=1" >Copy</a></span></td>
                    <td data-column-name="ticket_id" style="" class="primary-key sortable"><?php echo $row[0]; ?></td>
                    <td data-column-name="seat_no" style="" class="sortable"><?php echo $row[1]; ?></td>
                    <td data-column-name="pessanger" style="" class="sortable"><?php echo $row[2]; ?></td>
                    <td data-column-name="train_name" style="" class="foreign-key sortable"><?php echo $row[3]; ?></td>
                    <td data-column-name="date_of_train" style="" class="foreign-key sortable"><?php echo $row[4]; ?></td>
                    <td data-column-name="city_from" style="" class="foreign-key sortable"><?php echo $row[5]; ?></td>
                    <td data-column-name="city_to" style="" class="foreign-key sortable"><?php echo $row[6]; ?></td>
                    <td data-column-name="bogie_name" style="" class="foreign-key sortable"><?php echo $row[7]; ?></td>
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