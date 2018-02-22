										<?php 
											require_once "DatabaseManager.php";
											$teachers = DatabaseManager::getTeachers($_REQUEST['dept_id']);
											while($row=mysqli_fetch_array($teachers)){
												echo '<option value="'.$row['teacher_id'].'">'.$row['name'].'</option>';
											}
										?>
                                        <script type="text/javascript">
                                            $('#teachers').change(function(){
                                                update_teacher_data($('#teachers').val());
                                                return false;
                                            });
                                            function update_teacher_data(teacher_id){
                                                $.post("get_teacher_data.php", {
                                                    teacher_id: teacher_id,
                                                },function(response){
                                                    setTimeout("finishAjax('teacher_data', '"+escape(response)+"')", 400);
                                                });
                                            }
                                        </script>