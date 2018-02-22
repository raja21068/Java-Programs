						<form id="myform" action="add_room.php" method="post" >
							<input type="hidden" name="dept_id" value="<?php echo $_REQUEST['dept_id']; ?>" />
                            <div class="row-fluid">
                                <div class="span5">
                                    <h4><i class="icon-user"></i>&nbsp;&nbsp; room</h4>
									<?php include "get_room_data.php"; ?>
                                </div>
                                <div class="span3">
                                    <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;rooms</h4>
                                    <div class="socials clearfix">
                                        <select id="rooms" name="rooms" size="20">
										<?php 
											$rooms = DatabaseManager::getRooms($_REQUEST['dept_id']);
											while($row=mysqli_fetch_array($rooms)){
												echo '<option value="'.$row['room_id'].'">'.$row['room_name'].'</option>';
											}
										?>
                                        <script type="text/javascript">
                                            $('#rooms').change(function(){
                                                update_room_data($('#rooms').val());
                                                return false;
                                            });
                                            function update_room_data(room_id){
                                                $.post("get_room_data.php", {
                                                    room_id: room_id,
                                                },function(response){
                                                    setTimeout("finishAjax('room_data', '"+escape(response)+"')", 400);
                                                });
                                            }
                                        </script>
                                        </select>

                                    </div>
                                </div>
                            </div>
                                    <br />
                                    <a onclick="$('#myform').submit();" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="delete_room($('#rooms').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_room($('#rooms').val(),$('#room_name').val())" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_room_data(-1)" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
									<script type="text/javascript">
                                            function add_room(name,fname,surname,nic,mobile_no,password,pay_scill,email,name_code){
											alert(name);
                                                $.post("add_room.php", {
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
												update_room_data("-1");
												refresh_room_list();
												return false;
                                            }
                                            function update_room(room_id,room_name){
//											alert(surname);
                                                $.post("update_room.php", {
                                                    room_id: room_id,
													room_name: room_name,
                                                },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_room_data("-1");
												return false;
                                            }
                                            function delete_room(room_id){
                                                $.post("delete_room.php", {
                                                    room_id: room_id,
                                               },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_room_data("-1");
												refresh_room_list();
												return false;
                                            }
                                            function refresh_room_list(){
                                                $.post("refresh_room_list.php", {
                                                    dept_id: <?php echo $_REQUEST['dept_id']; ?>,
                                                },function(response){
                                                    setTimeout("finishAjax('rooms', '"+escape(response)+"')", 400);
                                                });
												return false;
                                            }
									</script>
						</form>			
