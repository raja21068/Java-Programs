										<?php 
											$prog_id = $_REQUEST['prog_id'];
											require_once "DatabaseManager.php";
											$courses = DatabaseManager::getpart($prog_id);
											while($row=mysqli_fetch_array($courses)){
												echo '<option value="'.$row['part_id'].'">'.$row['part'].'</option>';
											}
										?>
                                        <script type="text/javascript">
                                            $('#part_list').change(function(){
                                                update_course_form($('#part_list').val());
                                                return false;
                                            });
                                            function update_part_form(part_id){
                                                $.post("get_part_form.php", {
                                                    part_id: part_id,
                                                },function(response){
                                                    setTimeout("finishAjax('part_form', '"+escape(response)+"')", 400);
                                                });
                                            }
                                        </script>
