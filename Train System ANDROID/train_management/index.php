<?php
if(isset($_COOKIE['admin']) && isset($_COOKIE['pass'])){
    header( 'Location: http://localhost/onlineTest/admin/admin_home.php');
}
?>
<html>
<head>
<link rel="icon" href="img/favicon.ico" />
<link rel="shortcut icon" href="img/favicon.ico" />
<!-- Traing reservation System -->
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/print.css" rel="stylesheet" type="text/css" media="print" />

<!--[if IE 6]>
<link href="../css/ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!-- Traing reservation System -->

</head>
<body>
<div id="skipnav">
	<a href="#skip">Skip to main content</a>
	<hr />
</div>


<!-- BEGIN Train Reservation System BAR -->
<?php
include("_branding.php");
?>

<div id="wrapper">

<div id="centerwrap">
<?php
include("_header.php");
?>

<div id="content">
  <!-- BEGIN Editing content -->
<div id="pageContent">




    <div class="login">
      <h1> Admin Login </h1>
      <form method="post" action="login.php">
        <p><input type="text" name="user" value="" placeholder="Username or Email"></p>
        <p><input type="password" name="pass" value="" placeholder="Password"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Remember me on this computer
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
      </form>
    </div>

    <div class="login-help">
      <p>Forgot your password? <a href="index.php">Click here to reset it</a>.</p>
    </div>
  </section>




<div class="clearDiv"></div>
</div><!-- END of PAGECONTENT -->

</div><!-- END of CONTENT -->


<!--#include virtual="_footer.shtml" -->
</div><!-- END of CENTERWRAP -->

</div><!-- END of WRAPPER -->

</body>
</html>