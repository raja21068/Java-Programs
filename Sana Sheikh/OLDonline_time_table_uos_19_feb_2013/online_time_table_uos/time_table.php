<?php
	 require './DatabaseManager.php';
?>
<script type="text/javascript">

function get_time_table(teacher, course, semister){
      $('#time_table').fadeOut();
      $('#loader').show();
      $.post("get_time_table.php", {
        teacher: teacher,
		course: course,
		semester: semister,
      },function(response){
        setTimeout("finishAjax('time_table', '"+escape(response)+"')", 400);
      });
}
function update_times(part){
      $('#time').fadeOut();
      $('#loader').show();
      $.post("get_times.php", {
        part: part,
		dept_id: <?php echo $_REQUEST['dept_id'];?>
      },function(response){
        setTimeout("finishAjax('time', '"+escape(response)+"')", 400);
      });
}
function update_course(part, semester){
      $('#course').fadeOut();
      $('#loader').show();
      $.post("get_course.php", {
        part: part,
        semester: semester,
      },function(response){
        setTimeout("finishAjax('course', '"+escape(response)+"')", 400);
      });
}
function update_part(programs){
      $('#part').fadeOut();
      $('#loader').show();
      $.post("get_part.php", {
        prog_id: programs,
      },function(response){
        setTimeout("finishAjax('part', '"+escape(response)+"')", 400);
      });
}
function update_programs(departments){
      $('#programs').fadeOut();
      $('#loader').show();
      $.post("get_programs.php", {
        departments: departments,
      },function(response){
        setTimeout("finishAjax('programs', '"+escape(response)+"')", 400);
      });
}
function update_teachers(departments){
      $('#teacher').fadeOut();
      $('#loader').show();
      $.post("get_teachers.php", {
        departments: departments,
      },function(response){
        setTimeout("finishAjax('teacher', '"+escape(response)+"')", 400);
      });
}
function update_rooms(departments){
      $('#room').fadeOut();
      $('#loader').show();
      $.post("get_rooms.php", {
        departments: departments,
      },function(response){
        setTimeout("finishAjax('room', '"+escape(response)+"')", 400);
      });
}

function add_time_table(teacher, day, time, course, part, room){
      $.post("add_time_table.php", {
        teacher_id: teacher,
        day_id: day,
        time_id: time,
        course_id: course,
        part_id: part,
		room: room,
      },function(response){
        setTimeout("finishAjax('null', '"+escape(response)+"')", 400);
      });
	  update_time_table(part, null, null);
}

function update_time_table(part_id, day, time){
      $.post("timetable.php", {
        part_id: part_id,
		day_id: day,
		time_id: time,
		dept_id: <?php echo $_REQUEST['dept_id'];?>
      },function(response){
        setTimeout("finishAjax('time_table', '"+escape(response)+"')", 400);
      });
}

function finishAjax(id, response){
  $('#loader').hide();
  $('#'+id).html(unescape(response));
  $('#'+id).fadeIn();
}

</script>
<div class="row-fluid">
    <div class="span5">
        <h4><i class="icon-time"></i>&nbsp;&nbsp; Time Table</h4>
		<table>
            <tr>
                <td align="right">
				    <label>
                        Programs
						<span class="required-mark">*</span>                        
					</label>
				</td>
				<td>
					<select id="programs" name="programs" data-required-error-message="Program is required." data-validation="required" data-legacy-field-name="to_rout_id" data-pgui-legacy-validate="true">
<?php
$departments = DatabaseManager::getPrograms($_REQUEST['dept_id']);
    echo '<option value="">Please select...</option>';
        while($row = mysqli_fetch_array($departments)){
            echo '<option value="'.$row['prog_id'].'">'.$row['prog_tittle'].'</option>';
        }
?>
</select>
<script type="text/javascript">
	$('#programs').change(function(){
            update_part($('#programs').val());
            return false;
	});
</script>
				</td>
			</tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="from_rout_id_edit">
                            Part
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
                        <select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="detail_id"
    data-editable="true"
        id="part" name="part" data-required-error-message="batch is required." data-validation="required" data-legacy-field-name="detail_id" data-pgui-legacy-validate="true">
<option value="">Please select...</option>
</select>
<script type="text/javascript">
	$('#part').change(function(){
			update_times($('#part').val());
			update_time_table($('#part').val(), null, null);
            return false;
	});
</script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="from_rout_id_edit">
                            Semester
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
                        <select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="detail_id"
    data-editable="true"
        id="semester" name="semester" data-required-error-message="batch is required." data-validation="required" data-legacy-field-name="detail_id" data-pgui-legacy-validate="true">
<option value="">Please select...</option>
<option value="1">1st</option>
<option value="2">2nd</option>
</select>
<script type="text/javascript">
	$('#semester').change(function(){
            update_course($('#part').val(),$('#semester').val());
			//update_time_table($('#part').val(), $('#semester').val(), null, null);
            return false;
	});
</script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="from_rout_id_edit">
                            Course
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
                        <select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="seat_birth"
    data-editable="true"
        id="course" name="course" data-required-error-message="Seat Birth is required." data-validation="required" data-legacy-field-name="seat_birth" data-pgui-legacy-validate="true">
    <option value="">Please select...</option>
</select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="to_rout_id_edit">
                            Day
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
<select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="to_rout_id"
    data-editable="true"
        id="day" name="day" data-required-error-message="Day is required." data-validation="required" data-legacy-field-name="day" data-pgui-legacy-validate="true">
<?php
$days = DatabaseManager::getDays();
    echo '<option value="">Please select...</option>';
			$day_row;
			$i=0;
        while($row = mysqli_fetch_array($days)){
			$day_row[$i] = $row;
			$i++;
            echo '<option value="'.$row['days_id'].'">'.$row['days_name'].'</option>';
        }
?>
</select>
<script type="text/javascript">
	$('#day').change(function(){
			update_time_table($('#part').val(),$('#day').val(), $('#time').val());
            return false;
	});
</script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="to_rout_id_edit">
                            Time
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
<select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="to_rout_id"
    data-editable="true"
        id="time" name="time" data-required-error-message="Time is required." data-validation="required" data-legacy-field-name="bogie_id_edit" data-pgui-legacy-validate="true">
<?php
    echo '<option value="">Please select...</option>';
?>
</select>
<script type="text/javascript">
	$('#time').change(function(){
			update_time_table($('#part').val(), $('#day').val(), $('#time').val());
            return false;
	});
</script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan=2 align=center>
												<h3>Teacher</h3>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="to_rout_id_edit">
                            Department
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
<select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="to_rout_id"
    data-editable="true"
        id="department_t" name="department_t" data-required-error-message="Teacher is required." data-validation="required" data-legacy-field-name="bogie_id_edit" data-pgui-legacy-validate="true">
<?php
$departments = DatabaseManager::getDepartments();
    echo '<option value="">Please select...</option>';
        while($row = mysqli_fetch_array($departments)){
            echo '<option value="'.$row['dept_id'] .'"';
			if ($row['dept_id'] == $_REQUEST['dept_id'])echo " selected";
			echo '>'.$row['dept_name'].'</option>';
        }
?>
</select>
<script type="text/javascript">
	$('#department_t').change(function(){
			update_teachers($('#department_t').val());
            return false;
	});
</script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="to_rout_id_edit">
                            Teacher
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
<select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="to_rout_id"
    data-editable="true"
        id="teacher" name="teacher" data-required-error-message="Teacher is required." data-validation="required" data-legacy-field-name="bogie_id_edit" data-pgui-legacy-validate="true">
<?php
$teachers = DatabaseManager::getTeachers('dept_id');
    echo '<option value="">Please select...</option>';
        while($row = mysqli_fetch_array($teachers)){
            echo '<option value="'.$row['teacher_id'].'">'.$row['name'].'</option>';
        }
?>
</select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan=2 align=center>
												<h3>Room</h3>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="to_rout_id_edit">
                            Department
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
<select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="to_rout_id"
    data-editable="true"
        id="department_r" name="department_r" data-required-error-message="Teacher is required." data-validation="required" data-legacy-field-name="bogie_id_edit" data-pgui-legacy-validate="true">
<?php
$departments = DatabaseManager::getDepartments();
    echo '<option value="">Please select...</option>';
        while($row = mysqli_fetch_array($departments)){
            echo '<option value="'.$row['dept_id'] .'"';
			if ($row['dept_id'] == $_REQUEST['dept_id'])echo " selected";
			echo '>'.$row['dept_name'].'</option>';
        }
?>
</select>
<script type="text/javascript">
	$('#department_r').change(function(){
			update_rooms($('#department_r').val());
            return false;
	});
</script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right">
                        <label class="control-label" for="to_rout_id_edit">
                            Room
                            <span class="required-mark">*</span>                        </label>
                                            </td>
                                            <td>
<select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="to_rout_id"
    data-editable="true"
        id="room" name="room" data-required-error-message="Teacher is required." data-validation="required" data-legacy-field-name="bogie_id_edit" data-pgui-legacy-validate="true">
<?php
$rooms = DatabaseManager::getRooms('dept_id');
    echo '<option value="">Please select...</option>';
        while($row = mysqli_fetch_array($rooms)){
            echo '<option value="'.$row['room_id'].'">'.$row['room_name'].'</option>';
        }
?>
</select>
                                            </td>
                                        </tr>
		</table>
    </div>
	                        <div class="span3">
                                    <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Time Table</h4>
								<div id = time_table>
                                </div>
                            </div>
</div>
								<br />
								<a onclick="add_time_table($('#teacher').val(), $('#day').val(), $('#time').val(), $('#course').val(), $('#part').val(), $('#room').val())" class=" btn  ">Add/Update&nbsp;&nbsp;&nbsp;<i class="icon-upload"></i></a>&nbsp;&nbsp;&nbsp;