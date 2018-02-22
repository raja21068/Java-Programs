    <option value="">Please select...</option>
<?php
  require './class.DatabaseManager.php';
  $train_id = $_POST['train_id'];
  $from = $_POST['from'];
  $to_cities = DatabaseManager::getCitiesGoTo($train_id, $from);
  while($row = mysqli_fetch_array($to_cities)){
    echo '<option value="'.$row[1].'">'.$row[0].'</option>';
  }
?>
