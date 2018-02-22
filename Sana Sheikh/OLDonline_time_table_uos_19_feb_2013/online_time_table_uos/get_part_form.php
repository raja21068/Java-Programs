<?php
$part_id;
if(isset($_POST['part_id']))$part_id = $_POST['part_id']; else $part_id=-1;
require_once "DatabaseManager.php";
$course_data = DatabaseManager::get_part_data($part_id);
if($row = mysqli_fetch_array($course_data)){
?>
								<table id="part_form">
                                        <tr>
                                            <td align="right">
                                    <label>Part</label>
                                            </td>
                                            <td>
                                    <input id="part" name="part" type="text" class="input-block-level" value="<?php echo $row['part']; ?>" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Shift</label>
                                            </td>
                                            <td>
											<select id='shift' name='shift'>
												<option>please select...</option>
												<option value="1" <?php if ($row['shift'] ==1) echo "selected"; ?>>Morning</option>
												<option value="2" <?php if ($row['shift'] ==2) echo "selected"; ?>>Evening</option>
											</select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Remarks</label>
                                            </td>
                                            <td>
                                    <input id="part_remarks" name="remarks" type="text" class="input-block-level" value=<?php echo $row['remarks']; ?> />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Group Description</label>
                                            </td>
                                            <td>
                                    <input id="group_desc" name="group_desc" type="text" class="input-block-level" value=<?php echo $row['group_desc']; ?> />
                                            </td>
                                        </tr>
								</table>
<?php }
else{ ?>
								<table id="part_form">
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
                                            <td align="right">
                                    <label>Group Description</label>
                                            </td>
                                            <td>
                                    <input id="group_desc" name="group_desc" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
									</table>
<?php
}
 ?>