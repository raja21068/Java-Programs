<?php
$course_id;
if(isset($_POST['course_id']))$course_id = $_POST['course_id']; else $course_id=-1;
require_once "DatabaseManager.php";
$course_data = DatabaseManager::get_course_data($course_id);
if($row = mysqli_fetch_array($course_data)){
?>
									<div id="course_form">
                                        <tr>
                                            <td align="right">
                                    <label>Course Code</label>
                                            </td>
                                            <td>
                                    <input id="course_code" name="course_code" type="text" class="input-block-level" value="<?php echo $row['course_code']; ?>" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Course Name</label>
                                            </td>
                                            <td>
                                    <input id="course_name" name="course_name" type="text" class="input-block-level" value="<?php echo $row['course_name']; ?>" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Remarks</label>
                                            </td>
                                            <td>
                                    <input id="course_remarks" name="remarks" type="text" class="input-block-level" value=<?php echo $row['remarks']; ?> />
                                            </td>
                                        </tr>
									</div>
<?php }
else{ ?>
								<div id="course_form">
                                        <tr>
                                            <td align="right">
                                    <label>Course Code</label>
                                            </td>
                                            <td>
                                    <input id="course_code" name="course_code" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Course Name</label>
                                            </td>
                                            <td>
                                    <input id="course_name" name="course_name" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Remarks</label>
                                            </td>
                                            <td>
                                    <input id="remarks" name="remarks" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
								</div>
<?php
}
 ?>