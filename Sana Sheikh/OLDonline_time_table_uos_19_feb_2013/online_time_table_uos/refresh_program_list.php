										<?php 
											require_once "DatabaseManager.php";
											$programs = DatabaseManager::getPrograms($_REQUEST['dept_id']);
											while($row=mysqli_fetch_array($programs)){
												echo '<option value="'.$row['prog_id'].'">'.$row['prog_tittle'].'</option>';
											}
										?>
                                        <script type="text/javascript">
                                            $('#program').change(function(){
                                                update_program_data($('#program').val());
                                                return false;
                                            });
                                            function update_program_data(prog_id){
                                                $.post("get_program_data.php", {
                                                    prog_id: prog_id,
                                                },function(response){
                                                    setTimeout("finishAjax('program_data', '"+escape(response)+"')", 400);
                                                });
                                            }
                                        </script>