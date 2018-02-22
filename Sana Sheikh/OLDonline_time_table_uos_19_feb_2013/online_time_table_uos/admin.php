<!DOCTYPE html>
<?php 
require_once "DatabaseManager.php";
$user_data_row;
$user = "";
if(isset($_COOKIE["user"])){
$user_id = $_COOKIE["user"];
$user_data = DatabaseManager::getUserInfo($user_id);
if($user_data_row = mysqli_fetch_array($user_data)){
$user = $user_data_row['username'];
}
else{
//	header("Location: index.php?error=1");
}
}
else{
	header("Location: index.php?error=1");
}
?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Tabbed Forms And Tab Controls Live Preview</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="styles/bootstrap.min.css" rel="stylesheet" />
    <link href="styles/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="css/preview.min.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css' />
    <link href="styles/font-awesome.min.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery-1.3.2.js"></script>

    <!--[if IE 7]>
        <link href="styles/font-awesome-ie7.min.css" rel="stylesheet" />
    <![endif]-->
    <!--[if IE 8]>
        <style type="text/css">
        .navbar-inner{
            filter:none;
        }
         </style>
        <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body class=" ">
<script type="text/javascript">

	setTeacher();
	function setTeacher(){
		$.post("teacher.php",{dept_id : <?php echo $user_data_row['department_dept_id']; ?>}, function(response){
			setTimeout("finishAjax('tab-content', '"+escape(response)+"')", 400);
		});
	}
	function setPrograms(){
		$.post("programs.php",{dept_id : <?php echo $user_data_row['department_dept_id']; ?>}, function(response){
			setTimeout("finishAjax('tab-content', '"+escape(response)+"')", 400);
		});
	}
    function setCourse(){
		$.post("course.php",{dept_id : <?php echo $user_data_row['department_dept_id']; ?>}, function(response){
			setTimeout("finishAjax('tab-content', '"+escape(response)+"')", 400);
		});
	}
    function setPart(){
		$.post("part.php",{dept_id : <?php echo $user_data_row['department_dept_id']; ?>}, function(response){
			setTimeout("finishAjax('tab-content', '"+escape(response)+"')", 400);
		});
	}
    function setTimes(){
		$.post("times.php",{dept_id : <?php echo $user_data_row['department_dept_id']; ?>}, function(response){
			setTimeout("finishAjax('tab-content', '"+escape(response)+"')", 400);
		});
	}
    function setTimetable(){
		$.post("time_table.php",{dept_id : <?php echo $user_data_row['department_dept_id']; ?>}, function(response){
			setTimeout("finishAjax('tab-content', '"+escape(response)+"')", 400);
		});
	}
    function setRooms(){
		$.post("room.php",{dept_id : <?php echo $user_data_row['department_dept_id']; ?>}, function(response){
			setTimeout("finishAjax('tab-content', '"+escape(response)+"')", 400);
		});
	}
    function finishAjax(id, response){
        $('#loader').hide();
        $('#'+id).html(unescape(response));
        $('#'+id).fadeIn();
    }
</script>
   
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">Online Time Table</a>
                <div class="nav-collapse collapse navbar-responsive-collapse">
                    <ul class="nav">
							
							<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user"></i>&nbsp;<?php echo $user; ?><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="nav-header">user</li>
                                <li><a href="settings.php">Settings</a></li>
                                <li><a href="logout.php">Log Out</a></li>
                                <li><a href="help.php">help</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#s" class="dropdown-toggle" data-toggle="dropdown">BG Color<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="color-swatch">
                                    <div data-color="#c69c6d" title="Pale Worm Brown" data-class=""></div>
                                    <div data-color="#8c6239" title="Medium Warm Brown" data-class=""></div>
                                    <div data-color="#c7b299" title="Pale Cool Brown" data-class=""></div>
                                    <div data-color="rgb(102, 199, 235)" title="Pure Cyan" data-class=""></div>
                                    <div data-color="#00a651" title="Pure Green" data-class=""></div>
                                    <div data-color="#00a99d" title="Pure Green Cyan" data-class=""></div>
                                    <div data-color="#8dc63f" title="Pure Pea Green" data-class=""></div>
                                    <div data-color="rgb(241, 176, 72)" title="Orange" data-class=""></div>
                                    <div data-color="rgb(219, 124, 128)" title="Light Red" data-class=""></div>
                                    <div data-color="#A6A4CA" title="Light Violet" data-class=""></div>
                                    <div data-color="rgb(245,245,245)" title="Grey 5%" data-class="light"></div>
                                    <div data-color="rgb(215, 215, 215)" title="Grey 20%" data-class="light"></div>
                                    <div data-color="rgb(172, 172, 172)" title="Grey 40%" data-class=""></div>
                                    <div data-color="rgb(125, 125, 125)" title="Grey 60%" data-class=""></div>
                                    <div data-color="rgb(99, 99, 99)" title="Grey 70%" data-class=""></div>
                                    <div data-color="rgb(70, 70, 70)" title="Grey 80%" data-class=""></div>
                                    <div data-color="rgb(54, 54, 54)" title="Grey 85%" data-class=""></div>
                                    <div data-color="rgb(37, 37, 37)" title="Grey 90%" data-class=""></div>
                                    <!--div[data-color="#"]*15-->

                                </li>

                            </ul>

                        </li>
                        <li></li>


                    </ul>
                </div>
                <!-- /.nav-collapse -->
            </div>
        </div>
        <!-- /navbar-inner -->
    </div>


    <div class="divider large visible-desktop"></div>
    <div class="divider  hidden-desktop"></div>

    <div class="container">



        <div class="row-fluid" id="demo-1">
            <div class="span10 offset1">
                <h4>Online Time Table Management System</h4>
                <div class="tabbable custom-tabs tabs-animated  flat flat-all hide-label-980 shadow track-url auto-scroll">
                    <ul class="nav nav-tabs">
                        <li class="active"><a onclick="setTeacher()" href="#teacher" data-toggle="tab" class="active "><i class="icon-user"></i>&nbsp;<span>Teacher</span></a></li>
                        <li><a href="#" onclick="setPrograms()" data-toggle="tab"><i class="icon-th-large"></i>&nbsp;<span>Programs</span></a></li>
                        <li><a href="#" onclick="setPart()" data-toggle="tab"><i class="icon-th-list"></i>&nbsp;<span>Part</span></a></li>
                        <li><a href="#" onclick="setCourse()" data-toggle="tab"><i class="icon-th"></i>&nbsp;<span>Courses</span></a></li>
                        <li><a href="#" onclick="setTimes()" data-toggle="tab"><i class="icon-time"></i>&nbsp;<span>Times</span></a></li>
                        <li><a href="#" onclick="setRooms()" data-toggle="tab"><i class="icon-qrcode"></i>&nbsp;<span>Rooms</span></a></li>
                        <li><a href="#" onclick="setTimetable()" data-toggle="tab"><i class="icon-time"></i>&nbsp;<span>Time Table</span></a></li>
                    </ul>
                    <div id="tab-content" class="tab-content ">
                        <div class="tab-pane active" id="teacher">
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="divider bottom-preview"></div>

        <div class="divider bottom-preview"></div>
        <div class="divider bottom-preview"></div>
        <div id="demo-8" class="row-fluid">
            <div class="span12 features">
                <!--ul.unstyled.icons-ul>li.icon-li>i.icon-ok.icon-li-->
                <div class="row-fluid">
                    <div class="span6">
                        <h4>Features</h4>
                        <!--div.tabbable.custom-tabs.shadow.-->
                        <ul class="unstyled icons-ul">

                            <li><i class="icon-chevron-sign-right icon-li"></i>Three Themes Included Light,BLack,Grey</li>
                            <li><i class="icon-chevron-sign-right icon-li"></i>Responsive</li>
                            <li><i class="icon-chevron-sign-right icon-li"></i>Also Works As A Modal Popup</li>
                            <li><i class="icon-chevron-sign-right icon-li"></i>Dropdowns In Tabs</li>
                            <li><i class="icon-chevron-sign-right icon-li"></i>Works With Any Type Of Content</li>
                            <li><i class="icon-chevron-sign-right icon-li"></i>361 Icons To Choose From</li>
                            <li><i class="icon-chevron-sign-right icon-li"></i>Can Be Targeted From Cross Site(Track Url Method)
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="divider x-large"></div>
        <div class="divider large"></div>

    </div>



    <script src="scripts/jquery-1.9.1.min.js"></script>
    <script src="scripts/bootstrap.min.js"></script>
    <script src="scripts/tabs-addon.js"></script>

    <script type="text/javascript">
        $(function ()
        {
            $("a[href^='#demo']").click(function (evt)
            {
                evt.preventDefault();
                var scroll_to = $($(this).attr("href")).offset().top;
                $("html,body").animate({ scrollTop: scroll_to - 80 }, 600);
            });
            $("a[href^='#bg']").click(function (evt)
            {
                evt.preventDefault();
                $("body").removeClass("light").removeClass("dark").addClass($(this).data("class")).css("background-image", "url('bgs/" + $(this).data("file") + "')");
                console.log($(this).data("file"));


            });
            $("a[href^='#color']").click(function (evt)
            {
                evt.preventDefault();
                var elm = $(".tabbable");
                elm.removeClass("grey").removeClass("dark").removeClass("dark-input").addClass($(this).data("class"));
                if (elm.hasClass("dark dark-input"))
                {
                    $(".btn", elm).addClass("btn-inverse");
                }
                else
                {
                    $(".btn", elm).removeClass("btn-inverse");

                }

            });
            $(".color-swatch div").each(function ()
            {
                $(this).css("background-color", $(this).data("color"));
            });
            $(".color-swatch div").click(function (evt)
            {
                evt.stopPropagation();
                $("body").removeClass("light").removeClass("dark").addClass($(this).data("class")).css("background-color", $(this).data("color"));
            });
            $("#texture-check").mouseup(function (evt)
            {
                evt.preventDefault();

                if (!$(this).hasClass("active"))
                {
                    $("body").css("background-image", "url(bgs/n1.png)");
                }
                else
                {
                    $("body").css("background-image", "none");
                }
            });

            $("a[href='#']").click(function (evt)
            {
                evt.preventDefault();

            });

            $("a[data-toggle='popover']").popover({
                trigger:"hover",html:true,placement:"top"
            });
        });

    </script>
<div id=null></div>
</body>
</html>
