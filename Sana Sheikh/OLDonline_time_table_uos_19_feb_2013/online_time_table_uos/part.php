						<form id="myform4" action="add_part.php" method="post" >
                            <div class="row-fluid">
                                <div class="span5">
                                    <h4><i class="icon-th-list"></i>&nbsp;&nbsp; Parts</h4>
									<?php include "get_part_data.php"; ?>
                                </div>
                                <div class="span3">
                                    <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Parts</h4>
                                    <div class="socials clearfix">
                                        <select id="part_list" name="part_list" size="20">
                                        <script type="text/javascript">
                                            $('#part_list').change(function(){
                                                update_part_form($('#part_list').val());
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
                                        </select>

                                    </div>
                                </div>
                            </div>
                                    <br />
                                    <a onclick="$('#myform4').submit();" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="delete_part($('#part_list').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_part(	
									$('#part_list').val(),
									$('#part').val(),
									$('#shift').val(),
									$('#part_remarks').val(),
									$('#group_desc').val())" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_part_form(-1)" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
									<script type="text/javascript">
									
                                            function update_part(part_id, part, shift, remarks, group_desc){
                                                $.post("update_part.php", {
                                                    part_id: part_id,
													part: part,
													shift: shift,
													remarks:remarks,
													group_desc:group_desc,
                                                },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_part_form("-1");
												return false;
                                            }
                                            function delete_part(part_id){
                                                $.post("delete_part.php", {
                                                    part_id: part_id,
                                               },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_part_form("-1");
                                                update_part_list($('#program_part').val());
												return false;
                                            }
									</script>
						</form>			
