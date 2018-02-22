<?php
session_start();
session_destroy();
header( 'Location: \train_management' );
?>