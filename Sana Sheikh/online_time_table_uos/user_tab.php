<?php
require_once "DatabaseManager.php";
require_once './DepartmentRequest.php';
?>
<form id="myform" action="add_teacher.php" method="post" >
    <div class="row-fluid">
        <div class="span5">
            <h4><i class="icon-th-large"></i>&nbsp;&nbsp; Users</h4>
            <table id="department_data">
                <tr>
                    <td align="right">
                        <label>Name</label>
                    </td>
                    <td>
                        <input id="txt_user_name" name="name" type="text" class="input-block-level" value/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Father</label>
                    </td>
                    <td>
                        <input id="txt_user_father" name="name" type="text" class="input-block-level" value/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Surname</label>
                    </td>
                    <td>
                        <input id="txt_user_surname" name="name" type="text" class="input-block-level" value/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Designation</label>
                    </td>
                    <td>
                        <input id="txt_user_address" name="name" type="text" class="input-block-level" value/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Type</label>
                    </td>
                    <td>
                        <select id="select_user_type">
                            <option value="<?php echo DatabaseManager::$SUPER_ADMIN; ?>">Admin</option>
                            <option value="<?php echo DatabaseManager::$USER; ?>">User</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Department</label>
                    </td>
                    <td>
                        <select id="select_department"
                            data-editor="true"
                            data-editor-class="ComboBox"
                            data-field-name="to_rout_id"
                            data-editable="true"
                            data-required-error-message="Teacher is required." data-validation="required" data-legacy-field-name="bogie_id_edit" data-pgui-legacy-validate="true">
                                <?php
                                $departments = DatabaseManager::getDepartments();
                                echo '<option value="">Please select...</option>';
                                while ($row = mysqli_fetch_array($departments)) {
                                    // echo '<option value="' . $row['dept_id'] . '"';
                                    // if ($row['dept_id'] == $_REQUEST['dept_id'])
                                        // echo " selected";
                                    // echo '>' . $row['dept_name'] . '</option>';
									?> 
									<option value='<?php echo $row['dept_id'];?>'><?php echo $row['dept_name'];?></option>
									<?php
									
									
                                }
                                ?>
                        </select>
                    </td>
                </tr>
                 <tr>
                    <td align="right">
                        <label>Username</label>
                    </td>
                    <td>
                        <input id="txt_user_username" type="text" class="input-block-level" value/>
                    </td>
                </tr>
                 <tr>
                    <td align="right">
                        <label>Password</label>
                    </td>
                    <td>
                        <input id="txt_user_password" type="password" class="input-block-level" value/>
                    </td>
                    <td>
                        <input onclick="show_pass()" id="check_show_pass"  type="checkbox" class="input-block-level" value/>
                    </td>
                </tr>
                
            </table>
        </div>
        <div class="span3">
            <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;</h4>
            <div class="socials clearfix">
                <select id="select_users" size="20">
                    <?php
                    $departs = DatabaseManager::getUsers();
                    while ($row = mysqli_fetch_array($departs)) {
                        echo '<option value="' . $row['admin_id'] . '">' . $row['name'] . '</option>';
                    }
                    ?>
                    <script type="text/javascript">
                        function show_pass(){
                            var b=$("#check_show_pass").prop("checked");
                            if(b){
                                  $("#txt_user_password").attr("type","text");
                            }else{
                             $("#txt_user_password").attr("type","password");  
                            }
                        }
                        $('#select_users').change(function() {
                            set_depart_data($(this).val(), <?php echo RequestType::$REQUEST_GET_USER_BEAN; ?>);
                            return false;
                        });
                        function set_depart_data(dep_id, req) {
                            $.post("user_ajax.php", {
                                request: req,
                                user_id: dep_id
                            }, function(response) {
                                var ob = jQuery.parseJSON(response);
                                $("#txt_user_name").val(ob.name);
                                $("#txt_user_father").val(ob.fathers_name);
                                $("#txt_user_surname").val(ob.surname);
                                $("#txt_user_address").val(ob.address);
                                $("#txt_user_username").val(ob.username);
                                $("#txt_user_password").val(ob.password);
                                $("#select_user_type").val(ob.is_super_admin);
                                $("#select_department").val(ob.department_dept_id);
                            });
                        }

                    </script>
                </select>

            </div>
        </div>
    </div>
    <br />
    <a onclick="add_users();" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="delete_users();" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="update_users();" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="clear_all();" class="btn">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
    <script type="text/javascript">

                        function add_users() {
                            var name = $("#txt_user_name").val();
                            var father = $("#txt_user_father").val();
                            var surname = $("#txt_user_surname").val();
                            var designation = $("#txt_user_address").val();
                            var username = $("#txt_user_username").val();
                            var password = $("#txt_user_password").val();
                            var depart = $("#select_department").val();
                            var userType = $("#select_user_type").val();
                            var cell = "";
                            if (name == "" && father == "" && surname == "" && designation == "" && username == "" && password == "") {
                                alert("All fields are required, please fill all...");
                                return;
                            }
                            $.post("user_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_ADD_USER; ?>,
                                name : name,
                                fathers_name:father,
                                surname: surname,
                                address: designation,
                                admin_type: userType,
                                username: username,
                                password: password,
                                department_dept_id: depart,
                                is_super_admin: userType,
                                cell_no: cell
                            }, function(response) {
                                var ob = jQuery.parseJSON(response);
                                if(ob.admin_id>0){
                                $("#select_users").append("<option value='" + ob.admin_id + "' >" + name + "</option>");
                                clear_all();}
                            });
                        }
                        function delete_users() {
                            var id = $('#select_users').val();
                            $.post("user_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_DELETE_USER; ?>,
                                admin_id: id
                            }, function(response) {
                                if (response == "OK") {
                                    clear_all();
                                    $("#select_users").find(':selected').remove();
                                }
                            });
                        }

                        function update_users() {
                            var id = $('#select_users').val();
                            var name = $("#txt_user_name").val();
                            var father = $("#txt_user_father").val();
                            var surname = $("#txt_user_surname").val();
                            var designation = $("#txt_user_address").val();
                            var username = $("#txt_user_username").val();
                            var password = $("#txt_user_password").val();
                            var depart = $("#select_department").val();
                            var userType = $("#select_user_type").val();
                            var cell = "";
                            if (name == "" && father == "" && surname == "" && designation == "" && username == "" && password == "") {
                                alert("All fields are required, please fill all...");
                                return;
                            }
                            $.post("user_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_UPDATE_USER; ?>,
                                admin_id: id,
                                name : name,
                                fathers_name:father,
                                surname: surname,
                                address: designation,
                                admin_type: userType,
                                username: username,
                                password: password,
                                department_dept_id: depart,
                                is_super_admin: userType,
                                cell_no: cell
                            }, function(response) {
                                if (response != "OK") {
                                    alert("Updation failed");
                                } else {
                                    $("#select_users").find(':selected').html(name);
                                }
                            });
                        }

                        function clear_all() {
                            $("#txt_user_name").val("");
                            $("#txt_user_father").val("");
                            $("#txt_user_surname").val("");
                            $("#txt_user_address").val("");
                            $("#txt_user_username").val("");
                            $("#txt_user_password").val("");
                            $("#select_department").val("");
                            $("#select_user_type").val("");
                            
                        }
    </script>
</form>			
