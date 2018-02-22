<?php
$prog_id;
if(isset($_POST['prog_id']))$prog_id = $_POST['prog_id']; else $prog_id=-1;
require_once "DatabaseManager.php";
$prog_data = DatabaseManager::get_prog_data($prog_id);
if($row = mysqli_fetch_array($prog_data)){
?>
                                    <table id="program_data">
                                        <tr>
                                            <td align="right">
                                    <label>Program Title</label>
                                            </td>
                                            <td>
                                    <input id="program_tittle" name="program_tittle" type="text" class="input-block-level" value="<?php echo $row['prog_tittle']; ?>" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Degree Title</label>
                                            </td>
                                            <td>
                                    <input id="degree_tittle" name="degree_tittle" type="text" class="input-block-level" value=<?php echo $row['degree_tittle']; ?> />
                                            </td>
                                        </tr>
                                    </table>
<?php }
else{ ?>
                                    <table id="program_data">
                                        <tr>
                                            <td align="right">
                                    <label>Program Title</label>
                                            </td>
                                            <td>
                                    <input id="program_tittle" name="program_tittle" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Degree Title</label>
                                            </td>
                                            <td>
                                    <input id="degree_tittle" name="degree_tittle" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                    </table>
<?php
}
 ?>