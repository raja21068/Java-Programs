										<?php 
											require_once "DatabaseManager.php";
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
