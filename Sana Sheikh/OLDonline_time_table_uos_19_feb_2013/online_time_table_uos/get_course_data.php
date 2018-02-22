                                    <table id="course_data">
                                        <tr>
                                            <td align="right">
                                    <label>Programs</label>
                                            </td>
                                            <td>
                                        <select id="program_course" name="program_course" >
										<?php 
											require "DatabaseManager.php";
											$programs = DatabaseManager::getPrograms($_REQUEST['dept_id']);
											echo '<option value="">Please select...</option>';
											while($row=mysqli_fetch_array($programs)){
												echo '<option value="'.$row['prog_id'].'">'.$row['prog_tittle'].'</option>';
											}
										?>
                                        <script type="text/javascript">
                                            $('#program_course').change(function(){
                                                update_course_part_data($('#program_course').val());
                                                return false;
                                            });
                                            function update_course_part_data(prog_id){
                                                $.post("get_part.php", {
                                                    prog_id: prog_id,
                                                },function(response){
                                                    setTimeout("finishAjax('course_part_list', '"+escape(response)+"')", 400);
                                                });
                                            }
											//update_course_list($('#program_course').val());
                                        </script>
                                        </select>

                                            </td>
                                        </tr>
										                                        <tr>
                                            <td align="right">
                                    <label>Part</label>
                                            </td>
                                            <td>
                                        <select id="course_part_list" name="course_part_list" >
                                        </select>
                                        <script type="text/javascript">
                                            $('#course_part_list').change(function(){
                                                update_course_list($('#course_part_list').val(), $('#semester').val());
                                                return false;
                                            });
//											refresh_course_list($('#program_course').val());
                                        </script>
                                            </td>
                                        </tr>
										                                        <tr>
                                            <td align="right">
                                    <label>Semester</label>
                                            </td>
                                            <td>
                                        <select id="semester" name="semester" >
										<option>-- select --</option>
										<option value=1>1st</option>
										<option value=2>2nd</option>
                                        </select>
                                        <script type="text/javascript">
                                            $('#semester').change(function(){
                                                update_course_list($('#course_part_list').val(), $('#semester').val());
                                                return false;
                                            });
                                            function update_course_list(part_id, semester){
                                                $.post("refresh_course_list.php", {
                                                    part_id: part_id,
													semester: semester,
                                                },function(response){
                                                    setTimeout("finishAjax('course_list', '"+escape(response)+"')", 400);
                                                });
                                            }
//											refresh_course_list($('#program_course').val());
                                        </script>
                                            </td>
                                        </tr>
									</table>
										<table id="course_form">
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
                                    </table>