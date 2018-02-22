<?php
$room_id;
if(isset($_POST['room_id']))$room_id = $_POST['room_id']; else $room_id=-1;
require_once "DatabaseManager.php";
$room_data = DatabaseManager::get_room_data($room_id);
if($row = mysqli_fetch_array($room_data)){
?>
                                    <table id="room_data">
                                        <tr>
                                            <td align="right">
                                    <label>Room Name</label>
                                            </td>
                                            <td>
                                    <input id="room_name" name="room_name" type="text" class="input-block-level" value="<?php echo $row['room_name']; ?>" />
                                            </td>
                                        </tr>
                                    </table>
<?php }
else{ ?>
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
<?php
}
 ?>