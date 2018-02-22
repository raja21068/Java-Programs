<?php
require_once "DatabaseManager.php";
require_once './DepartmentRequest.php';
?>
<form id="myform" action="add_teacher.php" method="post" >
    <div class="row-fluid">
        <div class="span5">
            <h4><i class="icon-th-large"></i>&nbsp;&nbsp; Department</h4>
            <table id="department_data">
                <tr>
                    <td align="right">
                        <label>Name</label>
                    </td>
                    <td>
                        <input id="txt_dep_name" name="name" type="text" class="input-block-level" value/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Code</label>
                    </td>
                    <td>
                        <input id="txt_code" name="code" type="text" class="input-block-level" value/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Remarks</label>
                    </td>
                    <td>
                        <input id="txt_remarks" name="remarks" type="text" class="input-block-level" value/>
                    </td>
                </tr>
            </table>
        </div>
        <div class="span3">
            <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;</h4>
            <div class="socials clearfix">
                <select id="departments" name="teachers" size="20">
                    <?php
                    $departs = DatabaseManager::getDepartments();
                    while ($row = mysqli_fetch_array($departs)) {
                        echo '<option value="' . $row['dept_id'] . '">' . $row['dept_name'] . '</option>';
                    }
                    ?>
                    <script type="text/javascript">
                        $('#departments').change(function() {
                            set_depart_data($(this).val(), <?php echo RequestType::$REQUEST_GET_DEPARTMENT_BEAN; ?>);
                            return false;
                        });
                        function set_depart_data(dep_id, req) {
                            $.post("department_ajax.php", {
                                request: req,
                                dept_id: dep_id
                            }, function(response) {
                                var ob = jQuery.parseJSON(response);
                                $("#txt_dep_name").val(ob.dept_name);
                                $("#txt_code").val(ob.code);
                                $("#txt_remarks").val(ob.remarks);
                            });
                        }

                    </script>
                </select>

            </div>
        </div>
    </div>
    <br />
    <a onclick="add_department();" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="delete_department();" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="update_department();" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="clear_all();" class="btn">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
    <script type="text/javascript">

                        function add_department() {
                            var name = $("#txt_dep_name").val();
                            var code = $("#txt_code").val();
                            var remarks = $("#txt_remarks").val();
                            if (name == "" && code == "") {
                                alert("Department Name and Code should not be empty");
                                return;
                            }
                            $.post("department_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_ADD_DEPARTMENT; ?>,
                                dept_name: name,
                                code: code,
                                remarks: remarks
                            }, function(response) {
                                $("#departments").append("<option value='" + response + "' >" + name + "</option>");
                                clear_all();
                            });
                        }
                        function delete_department() {
                            var id = $('#departments').val();
                            $.post("department_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_DELETE_DEPARTMENT; ?>,
                                dept_id: id
                            }, function(response) {
                                if (response == "OK") {
                                    clear_all();
                                    $("#departments").find(':selected').remove();
                                }
                            });
                        }

                        function update_department() {
                            var id = $('#departments').val();
                            var name = $("#txt_dep_name").val();
                            var code = $("#txt_code").val();
                            var remarks = $("#txt_remarks").val();
                            if (name == "" && code == "") {
                                alert("Department Name and Code should not be empty");
                                return;
                            }
                            $.post("department_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_UPDATE_DEPARTMENT; ?>,
                                dept_id: id,
                                dept_name: name,
                                code: code,
                                remarks: remarks
                            }, function(response) {
                                if(response != "OK"){
                                    alert("Updation failed");
                                }else{
                                    $("#departments").find(':selected').html(name);
                                }
                            });
                        }

                        function clear_all() {
                            $("#txt_dep_name").val("");
                            $("#txt_code").val("");
                            $("#txt_remarks").val("");
                        }
    </script>
</form>			
