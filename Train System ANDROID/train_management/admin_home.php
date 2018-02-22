<?php
session_start();
if(!isset($_SESSION['admin'])){
    header('Location: \train_management');
}
?>
<html>
<head>
<link rel="icon" href="../img/favicon.ico" />
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
<?php
if(isset($_GET['page']))$page = $_GET['page'];
else{$page = 'welcome.php';}
echo "<iframe src=$page width=900 height=500 aligh=center></iframe>";
?>
<div class="clearDiv"></div>

</div><!-- END of PAGECONTENT -->

</div><!-- END of CONTENT -->

<?php
include("_footer.shtml");
//echo("<h1>$body</h1>");
?>

<!--#include virtual="_footer.shtml" -->
</div><!-- END of CENTERWRAP -->

</div><!-- END of WRAPPER -->

</body>
</html>