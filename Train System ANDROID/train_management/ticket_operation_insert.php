<?php
                    if(isset($_GET['train_id'])){ $train_id = $_GET['train_id']; }
                    if(isset($_GET['date'])){$qdate = $_GET['date'];}else{$qdate = date("Y-m-d");}
       // include './total_tickets_by_bogie.php';
?>
<script type="text/javascript">
    
update_total_tickets(null,null,null);

function update_to_rout_id_edit(from){
      $('#to_rout_id_edit').fadeOut();
      $('#loader').show();
      $.post("get_to_cities.php", {
        train_id: "<?php echo $train_id; ?>"  ,
        from: from,
      },function(response){
        setTimeout("finishAjax('to_rout_id_edit', '"+escape(response)+"')", 400);
      });
}
function update_total_tickets_get_from(from){
      $('#total_tickets').fadeOut();
      $('#loader').show();
      $.post("total_tickets_by_bogie.php", {
        date: "<?php echo $qdate; ?>",
        train_id: "<?php echo $train_id; ?>"  ,
        from: from,
        to: "_to",
      },function(response){
        setTimeout("finishAjax('total_tickets', '"+escape(response)+"')", 400);
      });
}


function update_total_tickets_By_seat_type(from, to , bogie, detail){
      $('#total_tickets').fadeOut();
      $('#loader').show();
      $.post("total_tickets_by_seat_type.php", {
        date: "<?php echo $qdate; ?>",
        train_id: "<?php echo $train_id; ?>",
        from: from,
        to: to,
        bogie_id: bogie,
        detail_id: detail,
      },function(response){
        setTimeout("finishAjax('total_tickets', '"+escape(response)+"')", 400);
      });
}
function update_total_tickets(from, to , bogie){
    if(from == null){from = "_from";}
    if(to == null){to = "_to";}
    if(bogie == null){bogie = "b.bogies_id";}
      $('#total_tickets').fadeOut();
      $('#loader').show();
      $.post("total_tickets_by_bogie.php", {
        date: "<?php echo $qdate; ?>",
        train_id: "<?php echo $train_id; ?>",
        from: from,
        to: to,
        bogie_id: bogie,
      },function(response){
        setTimeout("finishAjax('total_tickets', '"+escape(response)+"')", 400);
      });
}
function update_detail_id(from, to , bogie){
      $('#detail_id').fadeOut();
      $('#loader').show();
      $.post("get_detail_ids.php", {
        date: "<?php echo $qdate; ?>",
        train_id: "<?php echo $train_id; ?>",
        from: from,
        to: to,
        bogie_id: bogie,
      },function(response){
        setTimeout("finishAjax('detail_id', '"+escape(response)+"')", 400);
      });
}
function finishAjax(id, response){
  $('#loader').hide();
  $('#'+id).html(unescape(response));
  $('#'+id).fadeIn();
}

</script>
<div id="total_tickets">
</div>
<div class="row-fluid">

    <div class="page-header form-header">
<button onclick="update_total_tickets(null,null,null)">refresh</button>
        <h1>ticket</h1>
    </div>

    <div class="pgui-edit-form">
        <form class="form-horizontal"  enctype="multipart/form-data" method="POST" action="add_ticket.php">

            <fieldset>
                            <div class="control-group">
                    <div class="label-container">
                        <label class="control-label" for="no_of_seat">
                            No of Seats
                            <span class="required-mark">*</span>                        </label>
                        <div class="field-options">
</div>                    </div>
                    <div class="controls">
                            <input
        id="no_of_seat"
        name="no_of_seat"
        value="1"
        class="input-xlarge"
        data-editor="true" data-editor-class="TextEdit" data-field-name="no_of_seat" data-editable="true"
        type="text"
        data-required-error-message="No of Seats is required." data-validation="required" data-legacy-field-name="no_of_seat" data-pgui-legacy-validate="true"
        style="width: auto;"    >

                    </div>
                </div>
                            <div class="control-group">
                    <div class="label-container">
                        <label class="control-label" for="from_rout_id_edit">
                            From
                            <span class="required-mark">*</span>                        </label>
                        <div class="field-options">
</div>                    </div>
                    <div class="controls">
                        <select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="from_rout_id"
    data-editable="true"
        id="from_rout_id_edit" name="from_rout_id_edit" data-required-error-message="From Rout Id is required." data-validation="required" data-legacy-field-name="from_rout_id" data-pgui-legacy-validate="true">
                            
<script type="text/javascript">
	$('#from_rout_id_edit').change(function(){
            update_total_tickets($('#from_rout_id_edit').val(),null,null);
//            update_total_tickets_get_from($('#from_rout_id_edit').val());
            update_to_rout_id_edit($('#from_rout_id_edit').val());
            return false;
	});
</script>
        
<?php
$from_cities = DatabaseManager::getCitiesGoFrom($train_id);
    echo '<option value="">Please select...</option>';
        while($row = mysqli_fetch_array($from_cities)){
            echo '<option value="'.$row['_from'].'">'.$row['city_from'].'</option>';
        }
?>
</select>
                    </div>
                </div>
                            <div class="control-group">
                    <div class="label-container">
                        <label class="control-label" for="from_rout_id_edit">
                            To
                            <span class="required-mark">*</span>                        </label>
                        <div class="field-options">
</div>                    </div>
                    <div class="controls">
                        <select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="from_rout_id"
    data-editable="true"
        id="to_rout_id_edit" name="to_rout_id_edit" data-required-error-message="To Rout Id is required." data-validation="required" data-legacy-field-name="to_rout_id" data-pgui-legacy-validate="true">
    <option value="">Please select...</option>
</select>
<script type="text/javascript">
	$('#to_rout_id_edit').change(function(){
            update_total_tickets($('#from_rout_id_edit').val(),$('#to_rout_id_edit').val(),null);
            $('#bogies_edit').fadeIn();
            return false;
	});
</script>
                    </div>
                </div>
                            <div id="bogies_edit" class="control-group">
                    <div class="label-container">
                        <label class="control-label" for="to_rout_id_edit">
                            Boggie
                            <span class="required-mark">*</span>                        </label>
                        <div class="field-options">
</div>                    </div>
                    <div class="controls">
<script type="text/javascript">
$('#bogies_edit').fadeOut();
</script>

<select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="to_rout_id"
    data-editable="true"
        id="bogie_id_edit" name="bogie_id_edit" data-required-error-message="Bogie is required." data-validation="required" data-legacy-field-name="bogie_id_edit" data-pgui-legacy-validate="true">
<script type="text/javascript">
	$('#bogie_id_edit').change(function(){
            update_total_tickets($('#from_rout_id_edit').val(),$('#to_rout_id_edit').val(),$('#bogie_id_edit').val());
            update_detail_id($('#from_rout_id_edit').val(),$('#to_rout_id_edit').val(),$('#bogie_id_edit').val());
            return false;
	});
</script>
        
<?php
$bogies = DatabaseManager::getBogies($train_id,$qdate);
    echo '<option value="">Please select...</option>';
        while($row = mysqli_fetch_array($bogies)){
            echo '<option value="'.$row['bogies_id'].'">'.$row['bogie_name'].'</option>';
        }
?>
</select>
                    </div>
                </div>
                
                <div class="control-group">
                    <div class="label-container">
                        <label class="control-label" for="from_rout_id_edit">
                            bogies ides
                            <span class="required-mark">*</span>                        </label>
                        <div class="field-options">
</div>                    </div>
                    <div class="controls">
                        <select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="detail_id"
    data-editable="true"
        id="detail_id" name="detail_id" data-required-error-message="detail Id is required." data-validation="required" data-legacy-field-name="detail_id" data-pgui-legacy-validate="true">
    <option value="">Please select...</option>
</select>
<script type="text/javascript">
	$('#detail_id').change(function(){
            update_total_tickets_By_seat_type($('#from_rout_id_edit').val(),$('#to_rout_id_edit').val(),$('#bogie_id_edit').val(), $('#detail_id').val());
            $('#bogies_edit').fadeIn();
            return false;
	});
</script>
                    </div>
                </div>
                <div class="control-group">
                    <div class="label-container">
                        <label class="control-label" for="from_rout_id_edit">
                            Seat Birth
                            <span class="required-mark">*</span>                        </label>
                        <div class="field-options">
</div>                    </div>
                    <div class="controls">
                        <select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="seat_birth"
    data-editable="true"
        id="seat_birth" name="seat_birth" data-required-error-message="Seat Birth is required." data-validation="required" data-legacy-field-name="seat_birth" data-pgui-legacy-validate="true">
    <option value="">Please select...</option>
    <option value="seat">seat</option>
    <option value="birth">birth</option>
</select>
                    </div>
                </div>

                            <div class="control-group">
                    <div class="label-container">
                        <label class="control-label" for="pessanger_edit">
                            Pessanger
                            <span class="required-mark">*</span>                        </label>
                        <div class="field-options">
</div>                    </div>
                    <div class="controls">
                            <input
        id="pessanger_edit"
        name="pessanger_edit"
        value=""
        class="input-xlarge"
        data-editor="true" data-editor-class="TextEdit" data-field-name="pessanger" data-editable="true"
        type="text" maxlength="20" size="20"
        data-required-error-message="Pessanger is required." data-validation="required" data-legacy-field-name="pessanger" data-pgui-legacy-validate="true"
        style="width: auto;"    >

                    </div>
                </div>
            
                <div class="control-group">
                    <div class="controls">
                        <span class="required-mark">*</span> - Required field
                    </div>
                </div>
            </fieldset>


            <div class="error-container"></div>

            <div class="form-actions">

                <div class="btn-toolbar">
                    <div class="btn-group">
<input type="hidden" name="train_id" value="<?php echo $train_id;?>" />
<input type="hidden" name="date" value="<?php echo $qdate; ?>" />

                        <button id="submit-button"
                                class="btn btn-primary submit-button"
                                onclick="$(this).closest('form').submit(); return false;"
                                >Save</button>

                        <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li data-value="save"><a href="#" class="save-button">Save and return back to the list</a></li>
                            <li data-value="saveinsert"><a href="#" class="saveinsert-button">Save and add another record</a></li>
                            <li data-value="saveedit"><a href="#" class="saveedit-button">Save and continue editing</a></li>
                                                                                </ul>
                    </div>

                    <div class="btn-group">
                        <button class="btn" onclick="window.location.href='ticket.php?operation=return'; return false;">Cancel</button>
                    </div>
                </div>
            </div>
        </form>

        <script type="text/javascript">
            
            $(function() {
                    $('.dropdown-toggle').dropdown();

                    $('.save-and-open-details').click(function(e) {
                        e.preventDefault();
                        $('form').attr('action', $(this).attr('data-action'));
                        $('#submit-button').click();
                    });

                    $('a.save-button').click(function() {
                        $('#submit-action').val('save');
                        $('#submit-button').click();
                    });

                    $('a.saveedit-button').click(function() {
                        $('#submit-action').val('saveedit');
                        $('#submit-button').click();
                    });
                    $('a.saveinsert-button').click(function() {
                        $('#submit-action').val('saveinsert');
                        $('#submit-button').click();
                    });
                });
            function InsertForm_initd(editors) {
                ;
            }
            
        </script>
    </div>
</div>

