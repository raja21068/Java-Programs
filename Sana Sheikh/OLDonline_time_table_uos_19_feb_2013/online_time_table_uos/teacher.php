						<form id="myform" action="add_teacher.php" method="post" >
							<input type="hidden" name="dept_id" value="<?php echo $_REQUEST['dept_id']; ?>" />
                            <div class="row-fluid">
                                <div class="span5">
                                    <h4><i class="icon-user"></i>&nbsp;&nbsp; Teacher</h4>
									<?php include "get_teacher_data.php"; ?>
                                </div>
                                <div class="span3">
                                    <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Teachers</h4>
                                    <div class="socials clearfix">
                                        <select id="teachers" name="teachers" size="20">
										<?php 
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
                                        </select>

                                    </div>
                                </div>
                            </div>
                                    <br />
                                    <a onclick="$('#myform').submit();" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="delete_teacher($('#teachers').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_teacher(	
									$('#teachers').val(),
									$('#name').val(),
									$('#fname').val(),
									$('#surname').val(),
									$('#nic').val(),
									$('#mobile_no').val(),
									$('#password').val(),
									$('#pay_scill').val(),
									$('#email').val(),
									$('#name_code').val())" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_teacher_data(-1)" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
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
                                            function update_teacher(teacher_id,name,fname,surname,nic,mobile_no,password,pay_scill,email,name_code){
//											alert(surname);
                                                $.post("update_teacher.php", {
                                                    teacher_id: teacher_id,
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
												return false;
                                            }
                                            function delete_teacher(teacher_id){
                                                $.post("delete_teacher.php", {
                                                    teacher_id: teacher_id,
                                               },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_teacher_data("-1");
												refresh_teacher_list();
												return false;
                                            }
                                            function refresh_teacher_list(){
                                                $.post("refresh_teacher_list.php", {
                                                    dept_id: <?php echo $_REQUEST['dept_id']; ?>,
                                                },function(response){
                                                    setTimeout("finishAjax('teachers', '"+escape(response)+"')", 400);
                                                });
												return false;
                                            }
									</script>
						</form>			
