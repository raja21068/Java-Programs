<?php
require_once './DatabaseManager.php';
require_once './DepartmentRequest.php';
?>
<script type="text/javascript">
    $('#program_course').change(function() {
        var prog_id = $('#program_course').val();
        $.post("part_ajax.php", {
            prog_id: prog_id,
            request: <?php echo RequestType::$REQUEST_GET_ALL_PART; ?>
        }, function(response) {
            $("#course_part_list").html(response);
            $("#course_part_list").prepend("<option>-- select part--</option>");
        });
    });

    $('#course_part_list').change(function() {
        update_course_list($('#course_part_list').val(), $('#semester').val());
    });
    $('#semester').change(function() {
        update_course_list($('#course_part_list').val(), $('#semester').val());
        return false;
    });
    function update_course_list(part_id, semester) {
        if (part_id == "" || semester == "")
            return;
        $.post("course_ajax.php", {
            part_id: part_id,
            semester: semester,
            request: <?php echo RequestType::$REQUEST_GET_ALL_COURSE; ?>
        }, function(response) {
            $("#course_list").html(response);
        });
    }

    $('#course_list').change(function() {
        var course_id = $('#course_list').val();
        $.post("course_ajax.php", {
            course_id: course_id,
            request: <?php echo RequestType::$REQUEST_GET_COURSE_BEAN; ?>
        }, function(response) {
            var ob = jQuery.parseJSON(response);
            $("#course_name").val(ob.course_name);
            $("#course_code").val(ob.course_code);
            $("#course_remarks").val(ob.remarks);
        });
        return false;
    });

</script>

<form id="myform3" action="add_course.php" method="post" >
    <div class="row-fluid">
        <div class="span5">
            <h4><i class="icon-th"></i>&nbsp;&nbsp; Courses</h4>
            <table id="course_data">
                <tr>
                    <td align="right">
                        <label>Programs</label>
                    </td>
                    <td>
                        <select id="program_course" name="program_course" >
                            <?php
                            $programs = DatabaseManager::getPrograms($_COOKIE['dept']);
                            echo '<option value="">Please select...</option>';
                            while ($row = mysqli_fetch_array($programs)) {
                                echo '<option value="' . $row['prog_id'] . '">' . $row['prog_tittle'] . '</option>';
                            }
                            ?>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Part</label>
                    </td>
                    <td>
                        <select id="course_part_list" name="course_part_list" >
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Semester</label>
                    </td>
                    <td>
                        <select id="semester" name="semester" >
                            <option>-- select --</option>
                            <option value=1>1st</option>
                            <option value=2>2nd</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Course Code</label>
                    </td>
                    <td>
                        <input id="course_code" name="course_code" type="text" class="input-block-level" />
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Course Name</label>
                    </td>
                    <td>
                        <input id="course_name" name="course_name" type="text" class="input-block-level" />
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label>Remarks</label>
                    </td>
                    <td>
                        <input id="remarks" name="remarks" type="text" class="input-block-level" />
                    </td>
                </tr>
            </table>
            <?php //include "get_course_data.php";  ?>
        </div>
        <div class="span3">
            <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Courses</h4>
            <div class="socials clearfix">
                <select id="course_list" style="overflow:  auto;" name="course_list" size="20">

                </select>

            </div>
        </div>
    </div>
    <br />
    <a onclick="add_course()" class=" btn  ">Add&nbsp;&nbsp;&nbsp;<i class="icon-ok"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="delete_course($('#course_list').val())" class=" btn  ">Delete&nbsp;&nbsp;&nbsp;<i class="icon-remove"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="update_course()" class=" btn  ">Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;
    <a onclick="update_course_form(-1)" class=" btn  ">clear&nbsp;&nbsp;&nbsp;<i class="icon-refresh"></i></a>&nbsp;&nbsp;&nbsp;
    <script type="text/javascript">
    function add_course() {
        var course_part_list = $('#course_part_list').val();
        var course_code = $('#course_code').val();
        var course_name = $('#course_name').val();
        var remarks = $('#course_remarks').val();
        var semester = $('#semester').val();
        if (course_part_list == "" || semester == "")
        {
            return;
        }
        $.post("course_ajax.php", {
            course_part_list: course_part_list,
            semester: semester,
            course_code: course_code,
            course_name: course_name,
            remarks: remarks,
            request: <?php echo RequestType::$REQUEST_ADD_COURSE; ?>
        }, function(response) {
            var ob = jQuery.parseJSON(response);
            $("#course_list").append("<option value='" + ob.course_id + "'>" + course_name + "</option>");
            clear_all();
        });
    }
    function update_course() {
        var course_id = $('#course_list').val();
        var course_code = $('#course_code').val();
        var course_name = $('#course_name').val();
        var remarks = $('#course_remarks').val();
        $.post("course_ajax.php", {
            course_id: course_id,
            course_code: course_code,
            course_name: course_name,
            remarks: remarks,
            request: <?php echo RequestType::$REQUEST_UPDATE_COURSE; ?>
        }, function(response) {
            if (response != "OK") {
                alert("Deletion failed" + response);
            } else {
                $('#course_list').find(':selected').html(course_name);
            }
        });
    }
    function delete_course(course_id) {
        $.post("course_ajax.php", {
            course_id: course_id,
            request: <?php echo RequestType::$REQUEST_DELETE_COURSE; ?>
        }, function(response) {
            if (response != "OK") {
                alert("Deletion failed" + response);
            } else {
                $('#course_list').find(':selected').remove();
                clear_all();
            }
        });
    }
    function clear_all(){
        $('#course_code').val("");
        $('#course_name').val("");
        $('#course_remarks').val("")
    }
    </script>
</form>			
