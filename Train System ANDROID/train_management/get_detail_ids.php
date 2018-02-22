<?php 
require_once './class.DatabaseManager.php';
?>

                <?php         
                    if(isset($_POST['train_id'])){ $train_id = $_POST['train_id']; }else{$train_id = 1;}
                    if(isset($_POST['date'])){$qdate = $_POST['date'];}else{$qdate = date("Y-m-d");}
                    $tickets;
                        $tickets = DatabaseManager::getTotalByBogie($train_id,$qdate,$_POST['bogie_id']);
                ?>

    <?php
         $ticket = array();
         $count = 0;
            echo '<option value="">please select...</option>';
         while($row = mysqli_fetch_array($tickets, MYSQL_NUM)){
            echo '<option value="'.$row[3].'">'.$row[3].'</option>';
        }
        ?>