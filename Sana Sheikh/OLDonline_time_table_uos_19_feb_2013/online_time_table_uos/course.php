						<form id="myform3" action="add_course.php" method="post" >
                            <div class="row-fluid">
                                <div class="span5">
                                    <h4><i class="icon-th"></i>&nbsp;&nbsp; Courses</h4>
									<?php include "get_course_data.php"; ?>
                                </div>
                                <div class="span3">
                                    <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Courses</h4>
                                    <div class="socials clearfix">
                                        <select id="course_list" name="course_list" size="20">
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
                                        </select>

                                    </div>
                                </div>
                            </div>
                                    <br />
                                    <a onclick="$('#myform3').submit();" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="delete_course($('#course_list').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_course(	
									$('#course_list').val(),
									$('#course_code').val(),
									$('#course_name').val(),
									$('#course_remarks').val())" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
                                    <a onclick="update_course_form(-1)" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
									<script type="text/javascript">
                                            function update_course(course_id,course_code,course_name, remarks){
//											alert(prog_tittle);
                                                $.post("update_course.php", {
                                                    course_id: course_id,
													course_code: course_code,
													course_name: course_name,
													remarks:remarks,
                                                },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_course_form("-1");
												return false;
                                            }
                                            function delete_course(course_id){
                                                $.post("delete_course.php", {
                                                    course_id: course_id,
                                               },function(response){
                                                    setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
                                                });
												update_course_form("-1");
                                                update_course_list($('#course_part_list').val());
												return false;
                                            }
									</script>
						</form>			
