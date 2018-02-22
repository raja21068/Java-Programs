<?php
require_once './DatabaseManager.php';
require_once './DepartmentRequest.php';
?>
<script type="text/javascript">
    $('#rooms').change(function() {
        var room = $('#rooms').find(':selected').html();
        $("#room_name").val(room);
    });
</script>
<form id="myform" action="add_room.php" method="post" >
    <input type="hidden" name="dept_id" value="<?php echo $_COOKIE['dept']; ?>" />
    <div class="row-fluid">
        <div class="span5">
            <h4><i class="icon-user"></i>&nbsp;&nbsp; room</h4>
            <table id="room_data">
                <tr>
                    <td align="right">
                        <label>Room Name</label>
                    </td>
                    <td>
                        <input id="room_name" name="room_name" type="text" class="input-block-level" value/>
                    </td>
                </tr>
            </table>
        </div>
        <div class="span3">
            <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;rooms</h4>
            <div class="socials clearfix">
                <select id="rooms" name="rooms" size="20">
                    <?php
                    $rooms = DatabaseManager::getRooms($_COOKIE['dept']);
                    while ($row = mysqli_fetch_array($rooms)) {
                        echo '<option value="' . $row['room_id'] . '">' . $row['room_name'] . '</option>';
                    }
                    ?>
                </select>

            </div>
        </div>
    </div>
    <br />
    <a onclick="add_room()" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="delete_room($('#rooms').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="update_room()" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="clear_all()" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
    <script type="text/javascript">
    function add_room() {
        var room_name = $("#room_name").val();
        $.post("room_ajax.php", {
            request: "<?php echo RequestType::$REQUEST_ADD_ROOM; ?>",
            dept_id: "<?php echo $_COOKIE['dept']; ?>",
            room_name: room_name,
        }, function(response) {
            var ob = jQuery.parseJSON(response);
            $("#rooms").append("<option value='" + ob.room_id + "'>" + room_name + "</option>");
            clear_all();
        });
    }
    function update_room() {
        var room_id = $("#rooms").val();
        var room_name = $("#room_name").val();
        $.post("room_ajax.php", {
            request: "<?php echo RequestType::$REQUEST_UPDATE_ROOM; ?>",
            room_id: room_id,
            room_name: room_name,
        }, function(response) {
            if (response != "OK") {
                alert("Updation failed" + response);
            } else {
                $("#rooms").find(':selected').html(room_name);
            }
        });
    }
    function delete_room(room_id) {
        $.post("room_ajax.php", {
            request: "<?php echo RequestType::$REQUEST_DELETE_ROOM; ?>",
            room_id: room_id,
        }, function(response) {
            if (response != "OK") {
                alert("Deletion failed" + response);
            } else {
                $("#rooms").find(':selected').remove();
            }
        });
    }
    function clear_all() {
        $("#room_name").val("");
    }
    </script>
</form>			
