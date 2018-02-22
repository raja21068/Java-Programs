<?php include_once './DatabaseManager.php'; ?>
<?php include_once './DepartmentRequest.php'; ?>

<form id="myform2" action="add_program.php" method="post" >
    <input type="hidden" name="dept_id" value="<?php echo $_COOKIE['dept']; ?>" />
    <div class="row-fluid">
        <div class="span5">
            <h4><i class="icon-th-large"></i>&nbsp;&nbsp; Programs</h4>
            <table id="program_data">
                <tr>
                    <td align="right">
                        <label>Program Title</label>
                    </td>
                    <td>
                        <input id="program_tittle" name="program_tittle" type="text" class="input-block-level" />
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Degree Title</label>
                    </td>
                    <td>
                        <input id="degree_tittle" name="degree_tittle" type="text" class="input-block-level" />
                    </td>
                </tr>
            </table>
        </div>
        <div class="span3">
            <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Programs</h4>
            <div class="socials clearfix">
                <select id="program" name="program" size="20">
                    <?php
                    $programs = DatabaseManager::getPrograms($_REQUEST['dept_id']);
                    while ($row = mysqli_fetch_array($programs)) {
                        echo '<option value="' . $row['prog_id'] . '">' . $row['prog_tittle'] . '</option>';
                    }
                    ?>
                    <script type="text/javascript">
                        $('#program').change(function() {
                            update_program_data($('#program').val());
                        });
                        function update_program_data(prog_id) {
                            $.post("program_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_GET_PROGRAMS_BEAN; ?>,
                                prog_id: prog_id,
                            }, function(response) {
                                var ob = jQuery.parseJSON(response);
                                $("#program_tittle").val(ob.prog_tittle);
                                $("#degree_tittle").val(ob.degree_tittle);
                            });
                        }
                    </script>
                </select>

            </div>
        </div>
    </div>
    <br />
    <a onclick="add_program()" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="delete_program($('#program').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="update_program()" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="clear_all()" class="btn">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
    <script type="text/javascript">
                        function add_program() {
                            var prog = $("#program_tittle").val();
                            var deg = $("#degree_tittle").val();
                            $.post("program_ajax.php", {
                                dept_id: "<?php echo $_COOKIE['dept']; ?>",
                                request: <?php echo RequestType::$REQUEST_ADD_PROGRAMS; ?>,
                                program_tittle: prog,
                                degree_tittle: deg
                            }, function(response) {
                                var ob = jQuery.parseJSON(response);
                                $("#program").append("<option value='" + ob.prog_id + "' >" + prog + "</option>");
                                clear_all();
                            });
                        }
                        function update_program() {
                            var prog_id = $('#program').val();
                            var prog_tittle = $('#program_tittle').val();
                            var degree_tittle = $('#degree_tittle').val();
                            $.post("program_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_UPDATE_PROGRAMS; ?>,
                                prog_id: prog_id,
                                prog_tittle: prog_tittle,
                                degree_tittle: degree_tittle,
                            }, function(response) {
                                if (response != "OK") {
                                    alert("Updation failed"+response);
                                } else {
                                    $("#program").find(':selected').html(prog_tittle);
                                }
                            });
                        }
                        function delete_program(prog_id) {
                            $.post("program_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_DELETE_PROGRAMS; ?>,
                                prog_id: prog_id,
                            }, function(response) {
                                if (response != "OK") {
                                    alert("Deletion failed"+response);
                                } else {
                                    $("#program").find(':selected').remove();
                                }
                            });
                            
                        }
                        function clear_all() {
                            $("#program_tittle").val("");
                            $("#degree_tittle").val("");
                        }
    </script>
</form>			
