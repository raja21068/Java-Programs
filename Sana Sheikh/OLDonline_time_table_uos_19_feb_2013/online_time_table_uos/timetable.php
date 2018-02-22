<table border=2 width="500px">
	<tr>
		<th>
			<b>Day</b>
		</th>
<?php
	 require './DatabaseManager.php';
	 
	 if(isset($_REQUEST['part_id']))$part_id = $_REQUEST['part_id'];else $part_id = 'p.part_id';
	 if(isset($_REQUEST['teacher_id']))$teacher_id = $_REQUEST['teacher_id'];else $teacher_id = 't.teacher_id';
	 if(isset($_REQUEST['day_id']) && ($_REQUEST['day_id']+=0) > 0)$day_id = $_REQUEST['day_id'];else $day_id = 'day_id';
	 if(isset($_REQUEST['time_id']) && ($_REQUEST['time_id']+=0) > 0)$time_id = $_REQUEST['time_id'];else $time_id = 'time_id';
	 if(isset($_REQUEST['semester']))$semester = $_REQUEST['semester'];else $semester = 'semester';
?>
<?php
	$time = DatabaseManager::getTimes($_REQUEST['dept_id'], $part_id);
	$time_row;
	$i=0;
    while($row = mysqli_fetch_array($time)){
		$time_row[$i] = $row;
		$i++;
    }
	$days = DatabaseManager::getDays();
	$day_row;
	$i=0;
    while($row = mysqli_fetch_array($days)){
		$day_row[$i] = $row;
		$i++;
    }
	$time_table = DatabaseManager::getTimeTable($part_id, $semester, $teacher_id);
	$time_table_row;
	while($row = mysqli_fetch_array($time_table)){
		$time_table_row[$row['days_name']][$row['time_id']] = $row['course_code'] .  '<br>Room: ' . $row['room_name'] . '<br>'. $row['name_code'];
	}
	foreach($time_row as $j=>$row){
		echo "<td>".$row['time']."</td>";														
	}
	foreach($day_row as $i=>$row2){
		echo"</tr><tr><th><b>".$row2['days_name']."</b></th>";
		foreach($time_row as $j=>$row){
			if(isset($_REQUEST['time_id']) && isset($_REQUEST['day_id'])&& ($_REQUEST['day_id']+=0) > 0&& ($_REQUEST['time_id']+=0) > 0){
				if($time_id == $row['time_id'] && $day_id == $row2['days_id']){
					echo"<td bgcolor=red>";
				}
				else{
					echo "<td>";
				}
			}
			else if($time_id == $row['time_id'] || $day_id == $row2['days_id']){
				echo"<td bgcolor=red>";
			}
			else{
				echo "<td>";
			}
			if(isset($time_table_row[$row2['days_name']][$row['time_id']])){
				echo $time_table_row[$row2['days_name']][$row['time_id']];
			}
			else{
				echo "N.A";
			}
			echo "</td>";
		}
	}
?>
	</tr>											
</table>