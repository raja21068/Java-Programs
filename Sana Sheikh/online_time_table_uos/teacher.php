<?php include_once './DatabaseManager.php'; ?>
<?php include_once './DepartmentRequest.php'; ?>
<form id="myform" method="post" >
    <input type="hidden" name="dept_id" value="<?php echo $_REQUEST['dept_id']; ?>" >
    <div class="row-fluid">
        <div class="span5">
            <h4><i class="icon-user"></i>&nbsp;&nbsp; Teacher</h4>
            <table id="teacher_data">
                <tr>
                    <td align="right">
                        <label>Name</label>
                    </td>
                    <td>
                        <input id="name" name="name" type="text" class="input-block-level" value="" >
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Father's Name</label>
                    </td>
                    <td>
                        <input id="fname" name="fname" type="text" class="input-block-level" value="" >
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Surname</label>
                    </td>
                    <td>
                        <input id="surname" name="surname" type="text" class="input-block-level" value="" >
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>NIC</label>
                    </td>
                    <td>
                        <input id="nic" name="nic" type="text" class="input-block-level" value="" >
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Mobile No</label>
                    </td>
                    <td>
                        <input id="mobile_no" name="mobile_no" type="text" class="input-block-level" value="" >
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Password</label>
                    </td>
                    <td>
                        <input id="password" name="password" type="text" class="input-block-level" value="" >
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Pay Skill</label>
                    </td>
                    <td>
                        <input id="pay_scill" name="pay_scill" type="text" class="input-block-level" value="" >
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Email</label>
                    </td>
                    <td>
                        <input id="email" name="email" type="text" class="input-block-level" value="" >
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Name Code</label>
                    </td>
                    <td>
                        <input id="name_code" name="name_code" type="text" class="input-block-level" value="" >                                    
                    </td>
                </tr>
            </table>
        </div>
        <div class="span3">
            <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Teachers</h4>
            <div class="socials clearfix">
                <select id="select_teachers" name="teachers" size="20">
                    <?php
                    $teachers = DatabaseManager::getTeachers($_REQUEST['dept_id']);
                    while ($row = mysqli_fetch_array($teachers)) {
                        echo '<option value="' . $row['teacher_id'] . '">' . $row['name'] . '</option>';
                    }
                    ?>
                    <script type="text/javascript">
                        $('#select_teachers').change(function() {
                            update_teacher_data($(this).val());
                            return false;
                        });
                        function update_teacher_data(teacher_id) {
                            $.post("teacher_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_GET_TEACHER_BEAN; ?>,
                                teacher_id: teacher_id,
                            }, function(response) {
                                var ob = jQuery.parseJSON(response);
                                $("#name").val(ob.name);
                                $("#fname").val(ob.fname);
                                $("#surname").val(ob.surname);
                                $("#nic").val(ob.nic);
                                $("#mobile_no").val(ob.mobile_no);
                                $("#password").val(ob.password);
                                $("#pay_scill").val(ob.pay_schill);
                                $("#email").val(ob.email);
                                $("#name_code").val(ob.name_code);
                            });
                        }
                    </script>
                </select>

            </div>
        </div>
    </div>
    <br />
    <a onclick="add_teacher();" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="delete_teacher($('#select_teachers').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="update_teacher(
                                    $('#select_teachers').val(),
                                    $('#name').val(),
                                    $('#fname').val(),
                                    $('#surname').val(),
                                    $('#nic').val(),
                                    $('#mobile_no').val(),
                                    $('#password').val(),
                                    $('#pay_scill').val(),
                                    $('#email').val(),
                                    $('#name_code').val())" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="clear_all();" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
    <script type="text/javascript">
                        function add_teacher() {
                            var name = $('#name').val();
                            var fname = $('#fname').val();
                            var surname = $('#surname').val();
                            var nic = $('#nic').val();
                            var mobile_no = $('#mobile_no').val();
                            var password = $('#password').val();
                            var pay_scill = $('#pay_scill').val();
                            var email = $('#email').val();
                            var name_code = $('#name_code').val();
                            $.post("teacher_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_ADD_TEACHER; ?>,
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
                            }, function(response) {
                                var ob = jQuery.parseJSON(response);
                                $("#select_teachers").append("<option value='" + ob.teacher_id + "' >" + name + "</option>");
                                clear_all();
                            });
                        }
                        function update_teacher(teacher_id, name, fname, surname, nic, mobile_no, password, pay_scill, email, name_code) {
//											alert(surname);
                            $.post("teacher_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_UPDATE_TEACHER; ?>,
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
                            }, function(response) {
                                if (response != "OK") {
                                    alert("Updation failed"+response);
                                } else {
                                    $("#select_teachers").find(':selected').html(name);
                                }
                            });
                            return false;
                        }
                        function delete_teacher(teacher_id) {
                            $.post("teacher_ajax.php", {
                                request: <?php echo RequestType::$REQUEST_DELETE_TEACHER; ?>,
                                teacher_id: teacher_id,
                            }, function(response) {
                                $("#select_teachers").find(':selected').remove();
                            });
                            update_teacher_data("-1");
                            refresh_teacher_list();
                            return false;
                        }
                        function clear_all() {
                            $('#name').val("");
                            $('#fname').val("");
                            $('#surname').val("");
                            $('#nic').val("");
                            $('#mobile_no').val("");
                            $('#password').val("");
                            $('#pay_scill').val("");
                            $('#email').val("");
                            $('#name_code').val("");
                        }
    </script>
</form>			
