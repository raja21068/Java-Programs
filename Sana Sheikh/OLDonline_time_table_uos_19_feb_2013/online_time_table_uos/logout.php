<?php
		setcookie("user", $_COOKIE["user"], time());
		header("Location: index.php");
?>