<div id="identity">
	<div id="signature">
		<a href="\train_management"><img src="img/iub_crimson.gif"  width="250" height="120" /></a>
        <!-- BEGIN OPTIONAL SEARCH FEATURE -->
        
	<?php
		session_start();
		if(isset($_SESSION['admin'])){
		    require_once('class.DatabaseManager.php'); // required library file
		    $bool=true;//DatabaseManager::confirmAdmin($_COOKIE['admin'], $_COOKIE['pass']);
		    if($bool == true){
			echo "<div id=hello_box>";
			echo "<font size=4>Hi, <a href='admin_home.php'> admin </a>";
			echo " <a href='signout.php'>Logout</a></font>";
			echo "</div>";
		    }
		}
		
	?>
        <!-- END OPTIONAL SEARCH FEATURE -->
        
    </div>
  	<hr />
</div>
<div class="clearDiv"></div>
<!-- END INDIANA UNIVERSITY BLOOMINGTON BRANDING BAR -->