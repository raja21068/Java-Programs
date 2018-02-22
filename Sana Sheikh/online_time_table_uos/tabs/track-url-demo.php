ï»¿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Tabbed Forms And Tab Controls Live Preview</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="styles/bootstrap.min.css" rel="stylesheet" />
    <link href="styles/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="css/preview.min.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css' />
    <link href="styles/font-awesome.min.css" rel="stylesheet" />

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
<body>
    <div class="divider large visible-desktop"></div>
    <div class="row-fluid" id="demo-1">
        <div class="span10 offset1">
            <div class="tabbable custom-tabs tabs-animated  flat flat-all hide-label-980 shadow track-url auto-scroll">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#panel1" data-toggle="tab" class="active "><i class="icon-lock"></i>&nbsp;<span>Login Panel</span></a></li>
                    <li><a href="#panel2" data-toggle="tab"><i class="icon-user"></i>&nbsp;<span>Register Panel</span></a></li>
                    <li><a href="#panel3" data-toggle="tab"><i class="icon-key"></i>&nbsp;<span>Forgot Password</span></a></li>
                    <li><a href="#panel4" data-toggle="tab"><i class="icon-envelope-alt"></i>&nbsp;<span>Contact Us</span></a></li>
                </ul>
                <div class="tab-content ">
                    <div class="tab-pane active" id="panel1">
                        <div class="row-fluid">
                            <div class="span5">
                                <h4><i class="icon-user"></i>&nbsp;&nbsp; Login Here</h4>

                                <label>Username</label>
                                <input type="text" class="input-block-level" />
                                <label>Password<a href="#" class="pull-right"><i class="icon-question-sign"></i>&nbsp;Forgot Password</a> </label>
                                <input type="password" class="input-block-level" />
                                <label>
                                    <button type="button" data-toggle="button" class="btn btn-mini custom-checkbox active"><i class="icon-ok"></i></button>
                                    &nbsp;&nbsp;&nbsp;Remember Me
                                </label>
                                <br />

                                <a href="#" class=" btn  ">Sign In&nbsp;&nbsp;&nbsp;<i class="icon-chevron-sign-right"></i></a>
                            </div>
                            <div class="span3">
                                <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Social</h4>
                                <div class="socials clearfix">
                                    <a class="icon-facebook facebook"></a>
                                    <a class="icon-twitter twitter"></a>
                                    <a class="icon-google-plus google-plus"></a>
                                    <a class="icon-pinterest pinterest"></a>
                                    <a class="icon-linkedin linked-in"></a>
                                    <a class="icon-github github"></a>
                                </div>
                            </div>
                            <div class="span4">
                                <h4><i class="icon-question"></i>&nbsp;&nbsp;Registration</h4>
                                <div class="box">
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit fusce vel.
                                    </p>
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit fusce vel sapien elit in.
                                    </p>
                                </div>
                                <div class="box">
                                    Don't Have An Account.<br />
                                    Click Here For <a href="#" data-toggle="tab">Free Register</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="panel2">
                        <div class="row-fluid">
                            <div class="span5">
                                <h4><i class="icon-user"></i>&nbsp;&nbsp; Register Here</h4>


                                <label>Username</label>
                                <input type="text" class="input-block-level" />
                                <label>Password </label>
                                <input type="password" class="input-block-level" />
                                <label>Repeat Password</label>
                                <input type="password" class="input-block-level" />
                                <label>
                                    <button type="button" data-toggle="button" class="btn btn-mini custom-checkbox active"><i class="icon-ok"></i></button>
                                    &nbsp;&nbsp;&nbsp;I Aggree With <a href="#">Terms &amp; Conditions</a>
                                </label>
                                <br />

                                <a href="#" class=" btn  ">Register Now&nbsp;&nbsp;&nbsp;<i class="icon-chevron-sign-right"></i></a>

                            </div>
                            <div class="span3">
                                <h4><i class="icon-expand-alt"></i>&nbsp;&nbsp;Social</h4>
                                <div class="socials clearfix">
                                    <a class="icon-facebook facebook"></a>
                                    <a class="icon-twitter twitter"></a>
                                    <a class="icon-google-plus google-plus"></a>
                                    <a class="icon-pinterest pinterest"></a>
                                    <a class="icon-linkedin linked-in"></a>
                                    <a class="icon-github github"></a>
                                </div>
                            </div>
                            <div class="span4">
                                <h4><i class="icon-question"></i>&nbsp;&nbsp;Login</h4>
                                <div class="box">
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit fusce vel.
                                    </p>
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit fusce vel sapien elit in.
                                    </p>
                                </div>
                                <div class="box">
                                    Already Have An Account.<br />
                                    Click Here For <a href="#" data-toggle="tab">Login</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="tab-pane" id="panel3">
                        <div class="row-fluid">
                            <div class="span5">
                                <h4><i class="icon-unlock"></i>&nbsp;&nbsp;Password Recovery</h4>

                                <label>Email</label>
                                <input type="text" class="input-block-level" />
                                <label>Security Question</label>
                                <select class="input-block-level">
                                    <option disabled="disabled" selected="selected" />---Select---
                                    <option />Which Is Your First Mobile
                                    <option />What Is Your Pet Name
                                    <option />What Is Your Mother Name
                                    <option />Which Is Your First Game
                                </select>
                                <label>Answer</label>
                                <input type="text" class="input-block-level" />
                                <br />
                                <br />
                                <a href="#" class=" btn  ">Recover Password&nbsp;&nbsp;&nbsp;<i class="icon-chevron-sign-right"></i></a>
                            </div>
                            <div class="span7">
                                <h4><i class="icon-question"></i>&nbsp;&nbsp;Help</h4>
                                <div class="box">
                                    <p>Getting Error With Password Recovery Click Here For <a href="#">Support</a></p>
                                    <ul>


                                        <li>Vestibulum pharetra lectus montes lacus!</li>
                                        <li>Iaculis lectus augue pulvinar taciti.</li>
                                    </ul>

                                </div>
                                <div class="box">
                                    <ul>
                                        <li>Potenti facilisis felis sociis blandit euismod.</li>
                                        <li>Odio mi hendrerit ad nostra.</li>
                                        <li>Rutrum mi commodo molestie taciti.</li>
                                        <li>Interdum ipsum ad risus conubia, porttitor.</li>
                                        <li>Placerat litora, proin hac hendrerit ac volutpat.</li>
                                        <li>Ornare, aliquam condimentum  habitasse.</li>
                                    </ul>

                                </div>
                            </div>
                        </div>


                    </div>
                    <div id="panel4" class="tab-pane">
                        <div class="row-fluid">
                            <div class="span5">
                                <h4><i class="icon-envelope-alt"></i>&nbsp;&nbsp;Contact Us</h4>
                                <label>Name</label>
                                <input type="text" value="" id="" class="input-block-level" />
                                <label>Email</label>
                                <input type="text" value="" id="Text1" class="input-block-level" />
                                <label>Mobile No</label>
                                <input type="text" value="" id="Text2" class="input-block-level" />
                                <label>Message</label>
                                <textarea class="input-block-level" rows="5"></textarea>
                                <a href="#" class=" btn ">Send Message&nbsp;&nbsp;&nbsp;<i class="icon-chevron-sign-right"></i></a>
                                <br class="visible-phone" />
                                <br class="visible-phone" />
                            </div>
                            <div class="span7">
                                <div class="row-fluid">
                                    <div class="span12">
                                        <h4><i class="icon-location-arrow"></i>&nbsp;&nbsp;Locate Us</h4>

                                        <div class="map"></div>

                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6">
                                        <h4><i class="icon-envelope-alt"></i>&nbsp;&nbsp;Contact Us</h4>
                                        <address>
                                            <strong>Full Name</strong><br />
                                            <a href="mailto:#">first.last@example.com</a>
                                        </address>
                                    </div>
                                    <div class="span6">
                                        <h4><i class="icon-location-arrow"></i>&nbsp;&nbsp;Our Address</h4>

                                        <address>
                                            <strong>Twitter, Inc.</strong><br />
                                            795 Folsom Ave, Suite 600<br />
                                            San Francisco, CA 94107<br />
                                            <abbr title="Phone">P:</abbr>
                                            (123) 456-7890
                                        </address>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
    <div class="divider large visible-desktop"></div>
    <div class="row-fluid">
        <div class="span10 offset1">
            <div class="well" style="color:rgb(90,90,90)">
                <p>This Mehtod Is Also Able To Scroll Page(Optional) If The Tab Panel Is Below In The Page</p>
                <p>Try To Make Changes In Url Panel Id As Follow  OR click associated Link</p>
                <dl class="dl-horizontal">
                    <dt>Login Panel(TAB)</dt>
                    <dd><a href="track-url-demo.html#panel1" target="_blank">#panel1</a></dd>
                    <dt>Register Panel(TAB)</dt>
                    <dd><a href="track-url-demo.html#panel2" target="_blank">#panel2</a></dd>
                    <dt>Recovery Panel(TAB)</dt>
                    <dd><a href="track-url-demo.html#panel3" target="_blank">#panel3</a></dd>
                    <dt>Contact Panel(TAB)</dt>
                    <dd><a href="track-url-demo.html#panel4" target="_blank">#panel4</a></dd>
                </dl>
            </div>

        </div>
    </div>

    <div class="divider large visible-desktop"></div>

    <div class="divider"></div>
    <script src="scripts/jquery-1.9.1.min.js"></script>
    <script src="scripts/bootstrap.min.js"></script>
    <script src="scripts/tabs-addon.js"></script>
</body>
</html>
