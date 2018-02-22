<?php
$teacher_id;
if(isset($_POST['teacher_id']))$teacher_id = $_POST['teacher_id']; else $teacher_id=-1;
require_once "DatabaseManager.php";
$teacher_data = DatabaseManager::get_teacher_data($teacher_id);
if($row = mysqli_fetch_array($teacher_data)){
?>
                                    <table id="teacher_data">
                                        <tr>
                                            <td align="right">
                                    <label>Name</label>
                                            </td>
                                            <td>
                                    <input id="name" name="name" type="text" class="input-block-level" value="<?php echo $row['name']; ?>" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Father's Name</label>
                                            </td>
                                            <td>
                                    <input id="fname" name="fname" type="text" class="input-block-level" value=<?php echo $row['fname']; ?> />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Surname</label>
                                            </td>
                                            <td>
                                    <input id="surname" name="surname" type="text" class="input-block-level" value=<?php echo $row['surname']; ?> />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>NIC</label>
                                            </td>
                                            <td>
                                    <input id="nic" name="nic" type="text" class="input-block-level" value=<?php echo $row['nic']; ?> />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Mobile No</label>
                                            </td>
                                            <td>
                                    <input id="mobile_no" name="mobile_no" type="text" class="input-block-level" value=<?php echo $row['mobile_no']; ?> />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Password</label>
                                            </td>
                                            <td>
                                    <input id="password" name="password" type="text" class="input-block-level" value=<?php echo $row['password']; ?> />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Pay Skill</label>
                                            </td>
                                            <td>
                                    <input id="pay_scill" name="pay_scill" type="text" class="input-block-level" value=<?php echo $row['pay_scill']; ?> />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Email</label>
                                            </td>
                                            <td>
                                    <input id="email" name="email" type="text" class="input-block-level" value=<?php echo $row['email']; ?> />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Name Code</label>
                                            </td>
                                            <td>
                                    <input id="name_code" name="name_code" type="text" class="input-block-level" value=<?php echo $row['name_code']; ?> />                                    
                                            </td>
                                        </tr>
                                    </table>
<?php }
else{ ?>
                                    <table id="teacher_data">
                                        <tr>
                                            <td align="right">
                                    <label>Name</label>
                                            </td>
                                            <td>
                                    <input name="name" type="text" class="input-block-level" value/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Father's Name</label>
                                            </td>
                                            <td>
                                    <input name="fname" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Surname</label>
                                            </td>
                                            <td>
                                    <input name="surname" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>NIC</label>
                                            </td>
                                            <td>
                                    <input name="nic" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Mobile No</label>
                                            </td>
                                            <td>
                                    <input name="mobile_no" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Password</label>
                                            </td>
                                            <td>
                                    <input name="password" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Pay Skill</label>
                                            </td>
                                            <td>
                                    <input name="pay_scill" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Email</label>
                                            </td>
                                            <td>
                                    <input name="email" type="text" class="input-block-level" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                                    <label>Name Code</label>
                                            </td>
                                            <td>
                                    <input name="name_code" type="text" class="input-block-level" />                                    
                                            </td>
                                        </tr>
                                    </table>
<?php
}
 ?>