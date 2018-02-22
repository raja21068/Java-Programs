<?php
require_once "DatabaseManager.php";
require_once './DepartmentRequest.php';
?>
<script type="text/javascript">
    update_part_list($('#program_course').val());

    $('#program_part').change(function() {
        update_part_list($('#program_part').val());
        return false;
    });
    function update_part_list(prog_id) {
        $.post("part_ajax.php", {
            request:<?php echo RequestType::$REQUEST_GET_ALL_PART; ?>,
            prog_id: prog_id,
        }, function(response) {
            $("#part_list").html(response);
        });
    }

    $('#part_list').change(function() {
        var part_id = $('#part_list').val();
        $.post("part_ajax.php", {
            request:<?php echo RequestType::$REQUEST_GET_PART_BEAN; ?>,
            part_id: part_id,
        }, function(response) {
            var ob = jQuery.parseJSON(response);
            $("#part").val(ob.part);
            $("#shift").val(ob.shift);
            $("#remarks").val(ob.remarks);
            $("#group_desc").val(ob.group_desc);
        });
    });

</script>

<div class="row-fluid">
    <div class="span5">
        <h4><i class="icon-th-list"></i>&nbsp;&nbsp; Parts</h4>
        <table id="part_data">
            <tr>
                <td align="right">
                    <label>Programs</label>
                </td>
                <td>
                    <select id="program_part" name="program_part" >
                        <option>---select---</option>
                        <?php
                        $programs = DatabaseManager::getPrograms($_COOKIE['dept']);
                        while ($row = mysqli_fetch_array($programs)) {
                            echo '<option value="' . $row['prog_id'] . '">' . $row['prog_tittle'] . '</option>';
                        }
                        ?>

                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label>Part</label>
                </td>
                <td>
                    <input id="part" name="part" type="text" class="input-block-level" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label>Shift</label>
                </td>
                <td>
                    <select id='shift' name='shift'>
                        <option>please select...</option>
                        <option value="1">Morning</option>
                        <option value="2">Evening</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <label>Remarks</label>
                </td>
                <td>
                    <input id="part_remarks" name="remarks" type="text" class="input-block-level" />
                </td>
            </tr>
            <tr>
                <td>
                    <label>Group Description</label>
                </td>
                <td>
                    <input id="group_desc" name="group_desc" type="text" class="input-block-level" />
                </td>
            </tr>
        </table>
    </div>
    <div class="span3">
        <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Parts</h4>
        <div class="socials clearfix">
            <select id="part_list" name="part_list" size="20">

            </select>

        </div>
    </div>
</div>
<br />
<a onclick="add_part()" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
<a onclick="delete_part($('#part_list').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
<a onclick="update_part()" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
<a onclick="clear_all()" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
<script type="text/javascript">
    function add_part() {
        var part = $('#part').val();
        var shift = $('#shift').val();
        var remarks = $('#part_remarks').val();
        var group_desc = $('#group_desc').val();
        var prog = $("#program_part").val();
        $.post("part_ajax.php", {
            request: <?php echo RequestType::$REQUEST_ADD_PART; ?>,
            program_part: prog,
            part: part,
            shift: shift,
            remarks: remarks,
            group_desc: group_desc,
        }, function(response) {
            var ob = jQuery.parseJSON(response);
            $("#part_list").append("<option value='" + ob.part_id + "' >" + part + "</option>");
            clear_all();
        });
    }

    function update_part() {
        var part_id = $('#part_list').val();
        var part = $('#part').val();
        var shift = $('#shift').val();
        var remarks = $('#part_remarks').val();
        var group_desc = $('#group_desc').val();
        $.post("part_ajax.php", {
            request: <?php echo RequestType::$REQUEST_UPDATE_PART; ?>,
            part_id: part_id,
            part: part,
            shift: shift,
            remarks: remarks,
            group_desc: group_desc,
        }, function(response) {
            if (response != "OK") {
                alert("Updation failed" + response);
            } else {
                $("#part_list").find(':selected').html(part);
            }
        });
    }
    function delete_part(part_id) {
        $.post("part_ajax.php", {
            request: <?php echo RequestType::$REQUEST_DELETE_PART; ?>,
            part_id: part_id,
        }, function(response) {
            if (response != "OK") {
                alert("Deletion failed" + response);
            } else {
                $("#part_list").find(':selected').remove();
            }
        });

    }
</script>		
