
<?php
$error = "";
if (isset($_COOKIE["user"])) {
    header("Location: admin.php");
}
if (isset($_REQUEST['error'])) {
    $error = "<font color=orange><h3>Invalid UserName or Password...</h3></font>";
}
?>
<body>


    <div style="padding: 10px 0 0 100px;border: 1px #60676a solid; border-radius: 10px 10px 10px 10px;">

        <div id="login-box" style="">

            <H2 style="padding-left: 40px;">Login</H2>
            <?php echo $error; ?>
            <br />
            <form id=myform action=login.php methos=post>
                <div id="login-box-name">Username:</div><div id="login-box-field"><input name="uname" type="text" class="form-login" title="Username" value="" size="30" maxlength="2048" /></div>
                <div id="login-box-name">Password:</div><div id="login-box-field"><input name="pass" type="password" class="form-login" title="Password" value="" size="30" maxlength="2048" /></div>
                <!--<span class="login-box-options"><input type="checkbox" name="1" value="1"> Remember Me <a href="#" style="margin-left:30px;">Forgot password?</a></span>-->
                <a onclick="$('#myform').submit();" class=" btn  ">Login&nbsp;&nbsp;&nbsp;<i class="icon-login"></i></a>&nbsp;&nbsp;&nbsp;
            </form>





        </div>

    </div>













</body>
