<?php
$teacher_id = $_REQUEST['teacher_id'];
$name=$_REQUEST['name'];
$fname=$_REQUEST['fname'];
$surname=$_REQUEST['surname'];
$nic=$_REQUEST['nic'];
$mobile_no=$_REQUEST['mobile_no'];
$password=$_REQUEST['password'];
$pay_scill=$_REQUEST['pay_scill'];
$email=$_REQUEST['email'];
$name_code=$_REQUEST['name_code'];

require_once 'DatabaseManager.php';

    DatabaseManager::updateTeacher($teacher_id,$name,$fname,$surname,$nic,$mobile_no,$password,$pay_scill,$email,$name_code);
?>