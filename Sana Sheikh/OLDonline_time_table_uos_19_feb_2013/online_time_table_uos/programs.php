						<form id="myform2" action="add_program.php" method="post" >
							<input type="hidden" name="dept_id" value="<?php echo $user_data_row['department_dept_id']; ?>" />
                            <div class="row-fluid">
                                <div class="span5">
                                    <h4><i class="icon-th-large"></i>&nbsp;&nbsp; Programs</h4>
									<?php include "get_program_data.php"; ?>
                                </div>
                                <div class="span3">
                                    <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Programs</h4>
                                    <div class="socials clearfix">
                                        <select id="program" name="program" size="20">
										<?php 
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
                                        </select>

                                    </div>
                                </div>
                            </div>
                                    <br />
                                    <a onclick="$('#myform2').submit();" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="delete_program($('#program').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_program(	
									$('#program').val(),
									$('#program_tittle').val(),
									$('#degree_tittle').val())" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_program_data(-1)" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
									<script type="text/javascript">
                                            function add_teacher(name,fname,surname,nic,mobile_no,password,pay_scill,email,name_code){
											alert(name);
                                                $.post("add_teacher.php", {
                                                    dept_id: "<?php echo $_REQUEST['dept_id']; ?>",
													name: name,
													fname: fname,
													surname: surname,
													nic: nic,
													mobile_no: mobile_no,
													password: password,
													pay_scill: pay_scill,
													email: email,
													name_code: name_code,
                                                },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_teacher_data("-1");
												refresh_teacher_list();
												return false;
                                            }
                                            function update_program(prog_id,prog_tittle,degree_tittle){
//											alert(prog_tittle);
                                                $.post("update_program.php", {
                                                    prog_id: prog_id,
													prog_tittle: prog_tittle,
													degree_tittle: degree_tittle,
                                                },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_program_data("-1");
												return false;
                                            }
                                            function delete_program(prog_id){
                                                $.post("delete_program.php", {
                                                    prog_id: prog_id,
                                               },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_program_data("-1");
												refresh_program_list();
												return false;
                                            }
                                            function refresh_program_list(){
                                                $.post("refresh_program_list.php", {
                                                    dept_id: <?php echo $_REQUEST['dept_id']; ?>,
                                                },function(response){
                                                    setTimeout("finishAjax('program', '"+escape(response)+"')", 400);
                                                });
												return false;
                                            }
									</script>
						</form>			
