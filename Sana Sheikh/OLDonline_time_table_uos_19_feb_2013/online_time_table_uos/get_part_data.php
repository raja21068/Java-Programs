                                    <table id="part_data">
                                        <tr>
                                            <td align="right">
                                    <label>Programs</label>
                                            </td>
                                            <td>
                                        <select id="program_part" name="program_part" >
											<option>---select---</option>
										<?php 
											require_once "DatabaseManager.php";
											$programs = DatabaseManager::getPrograms($_REQUEST['dept_id']);
											while($row=mysqli_fetch_array($programs)){
												echo '<option value="'.$row['prog_id'].'">'.$row['prog_tittle'].'</option>';
											}
										?>
                                        <script type="text/javascript">
                                            $('#program_part').change(function(){
                                                update_part_list($('#program_part').val());
                                                return false;
                                            });
                                            function update_part_list(prog_id){
                                                $.post("refresh_part_list.php", {
                                                    prog_id: prog_id,
                                                },function(response){
                                                    setTimeout("finishAjax('part_list', '"+escape(response)+"')", 400);
                                                });
                                            }
											update_part_list($('#program_course').val());
                                        </script>
                                        </select>

                                            </td>
                                        </tr>
										</table>
<?php include "get_part_form.php"; ?>