
<?php
$error = "";
if(isset($_COOKIE["user"])){
header("Location: admin.php");
}
if(isset($_REQUEST['error'])){
$error = "<font color=orange><h3>Invalid UserName or Password...</h3></font>";
}
?>
<body>


<div style="padding: 100px 0 0 250px;">


<div id="login-box">

<H2>Login</H2>
<?php echo $error; ?>
<br />
<br />
<form id=myform action=login.php methos=post>
<div id="login-box-name" style="margin-top:20px;">UserName:</div><div id="login-box-field" style="margin-top:20px;"><input name="uname" class="form-login" title="Username" value="" size="30" maxlength="2048" /></div>
<div id="login-box-name">Password:</div><div id="login-box-field"><input name="pass" type="password" class="form-login" title="Password" value="" size="30" maxlength="2048" /></div>
<br />
<span class="login-box-options"><input type="checkbox" name="1" value="1"> Remember Me <a href="#" style="margin-left:30px;">Forgot password?</a></span>
<br />
<br />
	<a onclick="$('#myform').submit();" class=" btn  ">Login&nbsp;&nbsp;&nbsp;<i class="icon-login"></i></a>&nbsp;&nbsp;&nbsp;
</form>





</div>

</div>













</body>
