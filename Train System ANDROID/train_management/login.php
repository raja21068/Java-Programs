<?php
require('class.DatabaseManager.php'); // required library file
session_start();
$user = $_POST['user'];
$pass = $_POST['pass'];

$id = DatabaseManager::confirmAdmin($user, $pass);

if($id > 0){
$_SESSION['admin']=$id;
header( 'Location: admin_home.php' );
}
else{
header( 'Location: index.php?login=0' );
}
?>