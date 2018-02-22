<div id="header">   	
<div id=hiast_name>
<font size=5>
Train Managements System
</font>
</div>
<div class="clearDiv"></div>
</div>
<div id="mainpic"> 
<img src="img/main.jpg" width="900" height="180" alt="campus scenes" />
</div>
<?php
if(isset($_SSESSION)){
session_start();
}
if(isset($_SESSION['admin'])){
echo '
<div id="topnav">
	<ul id="topmenu">
    	<li><a href="index.php">Home</a></li>
    	<li><a href="admin_home.php?page=bogies.php">Bogies</a></li>
    	<li><a href="admin_home.php?page=city.php">City</a></li>
    	<li><a href="admin_home.php?page=days.php">Days</a></li>
    	<li><a href="admin_home.php?page=schedule.php">Schedule</a></li>
    	<li><a href="admin_home.php?page=rout.php">Rout</a></li>
    	<li><a href="admin_home.php?page=schedule_detail.php">ScheduleDetail</a></li>
    	<li><a href="admin_home.php?page=ticket.php">Ticket</a></li>
    	<li><a href="admin_home.php?page=train.php">Train</a></li>
	</ul>
</div>
';
}
?>





<div class="clearDiv"></div>
