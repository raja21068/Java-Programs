										<?php 
											$part_id = $_REQUEST['part_id'];
											$semester = $_REQUEST['semester'];
											require_once "DatabaseManager.php";
											$courses = DatabaseManager::getcourse($part_id, $semester);
											while($row=mysqli_fetch_array($courses)){
												echo '<option value="'.$row['course_id'].'">'.$row['course_name'].'</option>';
											}
										?>
                                        <script type="text/javascript">
                                            $('#course_list').change(function(){
                                                update_course_form($('#course_list').val());
                                                return false;
                                            });
                                            function update_course_form(course_id){
                                                $.post("get_course_form.php", {
                                                    course_id: course_id,
                                                },function(response){
                                                    setTimeout("finishAjax('course_form', '"+escape(response)+"')", 400);
                                                });
                                            }
                                        </script>
