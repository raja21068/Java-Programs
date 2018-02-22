<?php
$qdate = date("Y-m-d");
if(isset($_GET['operation']) && $_GET['operation']=='insert'){
$body='ticket_operation_insert.php';
$script_function = '<script></script>';
}
else{
$body='ticket_pages.php';
$script_function = '<script>    

    $(function() {
        
    });

</script>';
}
if(isset($train_id))$train_id = $_GET['train_id'];else$train_id=1;
if(isset($_GET['date'])){$qdate = $_GET['date'];}
?>
<!DOCTYPE html>
<html dir="">
<head>
            <meta charset="UTF-8">
        
    <meta http-equiv="X-UA-Compatible" content="IE=8, IE=9, IE=10">
            <title>ticket</title>
    
    <script type="text/javascript" src="jquery-1.3.2.js"></script>
    <link rel="stylesheet" type="text/css" href="components/css/main.css" />
    <link rel="stylesheet" type="text/css" href="components/css/user.css" />

    <script src="components/js/jquery/jquery.min.js"></script>
    <script src="components/js/libs/amplify.store.js"></script>
    <script src="components/js/bootstrap/bootstrap.js"></script>

    <script type="text/javascript" src="components/js/require-config.js"></script>
            <script type="text/javascript" data-main="pgui.list-page-main" src="components/js/require.js"></script>
    
    <script>
        require(['pgui.layout'], function(layout_manager){
            layout_manager.fixLayout();
        });
    </script>

        <script>function EditValidation(fieldValues, errorInfo) { ; return true; }  function InsertValidation(fieldValues, errorInfo) { ; return true; } function EditForm_EditorValuesChanged(sender, editors) { ; return true; } function InsertForm_EditorValuesChanged(sender, editors) { ; return true; } function EditForm_Initialized(editors) { ; return true; } function InsertForm_Initialized(editors) { ; return true; }</script>
<?php
echo $script_function; 
?>
</head>
<body>

<div class="navbar" id="navbar">
    <div class="navbar-inner">
        <div class="container">
                        <div class="pull-left"></div>
            
                </div>
    </div>
</div>



<div class="container-fluid">
    <div class="row-fluid">
                <div class="span3 expanded" id="side-bar">

            <div class="sidebar-nav-fixed">
                <a href="#" class="close" style="margin: 4px 4px 0 0"><i class="icon-chevron-left"></i></a>
                <div class="content">
                    
    <div class="sidebar-nav">
    <ul class="nav nav-list pg-page-list">

        <li class="nav-header">Train List</li>

<?php
        require_once 'class.DatabaseManager.php';
    $trains = DatabaseManager::getTrains();
    while($row = mysqli_fetch_array($trains)){
        echo '<li>
            <a href="ticket.php?train_id='.$row['train_id'].'&date='.$qdate.'" title="train_id">
                <i class="page-list-icon"></i>
                '.$row['train_name'].'
            </a>
        </li>';
    }

?>
                                
    </ul>
</div>


                </div>
            </div>

            <script>
            $('.sidebar-nav-fixed').css('top',
                Math.max(0, $('#navbar').outerHeight() - $(window).scrollTop())
            );
            $('#navbar img').load(function() {
                $('.sidebar-nav-fixed').css('top',
                    Math.max(0, $('#navbar').outerHeight() - $(window).scrollTop())
                );
            });
            $(window).scroll(function() {
                $('.sidebar-nav-fixed').css('top',
                        Math.max(0, $('#navbar').outerHeight() - $(window).scrollTop())
                );
            });
            //$('#content').css('top', $('.navbar-fixed-top').height() + 10);
            //$('#side-bar').css('top', $('.navbar-fixed-top').height() - 10);
            </script>

        </div>
                <div class="span9" id="content-block">
                        <script>
            var sideBarContainer = $('#side-bar');
            var sidebar = $('#side-bar .sidebar-nav-fixed');
            var toggleButton = sidebar.find('a.close');
            var toggleButtonIcon = toggleButton.children('i');

            function hideSideBar() {
                sideBarContainer.removeClass('expanded');
                sidebar.children('.content').hide();
                sideBarContainer.width(20);
                toggleButtonIcon.removeClass('icon-chevron-left');
                toggleButtonIcon.addClass('icon-chevron-right');
                $('#content-block').css('left', 0);
                $('#content-block').addClass('span10');
                $('#content-block').removeClass('span9');
            }

            function showSideBar() {
                sideBarContainer.addClass('expanded');
                sidebar.children('.content').show();
                sideBarContainer.width(240);
                toggleButtonIcon.addClass('icon-chevron-left');
                toggleButtonIcon.removeClass('icon-chevron-right');
                $('#content-block').css('left', 240);
                $('#content-block').removeClass('span10');
                $('#content-block').addClass('span9');
            }

            
                            
                if (amplify.store('side-bar-collapsed')) {
                    hideSideBar();
                }
                
                        


            toggleButton.click(function(e) {
                e.preventDefault();
                if (sideBarContainer.hasClass('expanded')) {
                    hideSideBar();
                    amplify.store('side-bar-collapsed', true);
                }
                else {
                    showSideBar();
                    amplify.store('side-bar-collapsed', false);
                }
            });
            </script>
<?php
include($body);
//echo("<h1>$body</h1>");
?>
            <hr>
            <footer><p>    
</p></footer>
        </div>


    </div>
</div>

<div id="pg-change-password-dialog" class="modal hide">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><i class="icon-remove"></i></button>
        <h3 id="pg-change-password-dialog-header-user" class="hide">Change your password</h3>
        <h3 id="pg-change-password-dialog-header-admin" class="hide">Change password for user '<span data-bind="text: changePasswordUser.name"></span>'</h3>
    </div>

    <div class="modal-body">

        <form class="form-horizontal">
            <fieldset>
                <div class="control-group hide" id="pg-change-password-dialog-current-password-control-group">
                    <label class="control-label" for="pg-change-password-dialog-current-password">Current password</label>
                    <div class="controls">
                        <input id="pg-change-password-dialog-current-password"
                               type="password"
                               name="currentPassword"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="pg-change-password-dialog-new-password">New password</label>
                    <div class="controls">
                        <input id="pg-change-password-dialog-new-password"
                               type="password"
                               name="newPassword"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="pg-change-password-dialog-confirmed-password">Confirm password</label>
                    <div class="controls">
                        <input id="pg-change-password-dialog-confirmed-password"
                               type="password"
                               name="confirmedPassword"/>
                    </div>
                </div>
                <div class="control-group">
                    <div class="alert alert-error" id="pg-change-password-dialog-confirmed-password-error">
                        <p>Passwords do not match. Please try again.</p>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>

    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary" id="pg-change-password-dialog-ok-button">Change password</a>
    </div>
</div>
<script type="text/javascript" src="components/js/pg.user_management_api.js"></script>
<script type="text/javascript" src="components/js/pgui.change_password_dialog.js"></script>
<script type="text/javascript" src="components/js/pgui.password_dialog_utils.js"></script>
<script type="text/javascript" src="components/js/pgui.self_change_password.js"></script>

</body>
</html>