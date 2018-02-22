                            <div class="page-header">
        <h1>
            ticket
        </h1>
        <div class="btn-group export-button">


    
<?php
                    if(isset($_GET['train_id'])){ $train_id = $_GET['train_id']; }
                    if(isset($_GET['date'])){$qdate = $_GET['date'];}else{$qdate = date("Y-m-d");}
                    if(isset($_GET['view'])){$view = $_GET['view'];}else{$view = "allReservedTicket.php";}
?>
    
    
</div>    </div>

    <!-- <Pages> -->
<?php include $view;?>
    
<script type="text/javascript">

        
            require(['pgui.text_highlight'], function(textHighlight) {
    
        
    });
    
    

    
    $(function() {
        var gridId = 'ticketGrid';
        var $gridContainer = $('#' + gridId);

        require(['pgui.grid', 'pgui.advanced_filter'], function(pggrid, fb) {

            var grid = new pggrid.Grid($gridContainer);

            grid.onConfigureFilterBuilder(function(filterBuilder) {
            
                                filterBuilder.addField(
                        'ticket_id',
                        'Ticket Id',
                        fb.FieldType.Integer,
                        fb.TextEdit,
                        {});
                                filterBuilder.addField(
                        'seat_no',
                        'Seat No',
                        fb.FieldType.Integer,
                        fb.TextEdit,
                        {});
                                filterBuilder.addField(
                        'detail_id',
                        'Detail Id',
                        fb.FieldType.Integer,
                        fb.Typeahead,
                        {"handler":"detail_id_advanced_search_lookup_handler"});
                                filterBuilder.addField(
                        'from_rout_id',
                        'From Rout Id',
                        fb.FieldType.Integer,
                        fb.Typeahead,
                        {"handler":"from_rout_id_advanced_search_lookup_handler"});
                                filterBuilder.addField(
                        'to_rout_id',
                        'To Rout Id',
                        fb.FieldType.Integer,
                        fb.Typeahead,
                        {"handler":"to_rout_id_advanced_search_lookup_handler"});
                                filterBuilder.addField(
                        'pessanger',
                        'Pessanger',
                        fb.FieldType.String,
                        fb.TextEdit,
                        {});
                            ;
            });

            var activeFilterJson = {"type":1,"operator":1,"items":[]};
            var activeFilter = new fb.Filter();
            activeFilter.fromJson(activeFilterJson);
            grid.setFilter(activeFilter);
        });
    });
    
</script>

    <!-- <Pages> -->
<div class="page_navigator">
<div class="page_navigator">
<div class="pgui-pagination" data-total-record-count="1">


    <div class="modal hide pagination-size">

        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><i class="icon-remove"></i></button>
            <h3>Change record count per page</h3>
        </div>

        <div class="modal-body">
                        <p>Total record count: 1.</p>

            <table class="table table-bordered">
                <tr>
                    <th>Records per page</th>
                    <th>Total pages</th>
                </tr>
                                    <tr>
                        <td>
                            <div class="controls">
                                <label class="radio">
                                    <input type="radio" value="10" name="recperpage">
                                    10
                                </label>
                            </div>
                        </td>
                        <td>1</td>
                    </tr>
                                    <tr>
                        <td>
                            <div class="controls">
                                <label class="radio">
                                    <input type="radio" value="20" name="recperpage">
                                    20
                                </label>
                            </div>
                        </td>
                        <td>1</td>
                    </tr>
                                    <tr>
                        <td>
                            <div class="controls">
                                <label class="radio">
                                    <input type="radio" value="50" name="recperpage">
                                    50
                                </label>
                            </div>
                        </td>
                        <td>1</td>
                    </tr>
                                    <tr>
                        <td>
                            <div class="controls">
                                <label class="radio">
                                    <input type="radio" value="100" name="recperpage">
                                    100
                                </label>
                            </div>
                        </td>
                        <td>1</td>
                    </tr>
                                    <tr>
                        <td>
                            <div class="controls">
                                <label class="radio">
                                    <input type="radio" value="0" name="recperpage">
                                    ALL
                                </label>
                            </div>
                        </td>
                        <td>1</td>
                    </tr>
                                <tr>
                    <td>
                        <div class="controls">
                            <label class="radio">
                                <input type="radio" value="custom" name="recperpage" checked="checked">
                                Use custom value
                            </label>
                            <label class="text">
                                <input type="text" value="20" class="input-medium pgui-custom-page-size">
                            </label>
                        </div>

                    </td>
                    <td><span class="custom_page_size_page_count">1</span></td>
                </tr>
            </table>

        </div>

        <div class="modal-footer">
            <a href="#" class="btn" data-dismiss="modal">Cancel</a>
            <a href="#" class="save-changes-button btn btn-primary">Save changes</a>
        </div>
    </div>


</div>
</div>
</div>
<!-- </Pages> -->

