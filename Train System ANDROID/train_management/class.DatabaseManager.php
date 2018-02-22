<?php

class DatabaseManager{

    public static function confirmAdmin($user, $pass){
	include("db_connectin.php");
	$result = mysqli_query($con,"SELECT * FROM admin WHERE user_name = '$user' ");
	if($row = mysqli_fetch_array($result)){
	    if($row['password'] == $pass){
		mysqli_close($con);
		return $row['admin_id'];
	    }
	}
	mysqli_close($con);
        return -1;
    }

    public static function getGroupTicketReserved($train_id, $date){
	include("db_connectin.php");

        $query = "SELECT train_name, date_of_train, city_from, city_to, bogie_name, COUNT(ticket_id) FROM reserved WHERE train_id = $train_id AND CAST(date_of_train AS DATE)  = '$date' GROUP BY bogie_name, city_from, city_to ";
//        echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    
    public static function getCitiesGo($train_id, $from = "_from", $to = "_to"){
	include("db_connectin.php");
        $query = "SELECT * FROM  train_routes_cross "
                . "WHERE train_id = $train_id "
                . "AND _from < _to "
                . "AND _from = $from "
                . "AND _to = $to";
//        echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }

    
    public static function getCitiesGoFrom($train_id){
	include("db_connectin.php");

        $query = "SELECT city_from, _from FROM  `train_routes_cross` WHERE train_id = $train_id AND _from < _to GROUP BY city_from ORDER BY _from";
       // echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }

    public static function getCitiesGoTo($train_id, $from){
	include("db_connectin.php");

        $query = "SELECT city_to, _to FROM  `train_routes_cross` WHERE train_id = $train_id AND _from < _to AND $from < _to GROUP BY city_to ORDER BY _to";
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function getBogies($train_id, $date){
	include("db_connectin.php");
        $query = "SELECT b.bogie_name, shd.detail_id, b.bogies_id
FROM train tr, days d, schedule_detail shd, schedule sh, bogies b
WHERE 
    shd.schedule_id = sh.schedule_id
AND sh.train_id = tr.train_id
AND sh.day_id = d.days_id
AND shd.bogie_id = b.bogies_id 
AND tr.train_id = $train_id
AND CAST(d.date_of_train AS DATE)  = '$date'
GROUP BY b.bogies_id";
       // echo $query;
	$result = mysqli_query($con,$query);
	return $result;        
    }
        public static function getReservedTicketsByDetail_id($detail_id){
	include("db_connectin.php");
            $query = "SELECT 	t.detail_id, 
		s.seat_type, 
		COUNT(s.seat_type) as count, 
		b.bogies_id, 
		rfrom.junction_no as _from, 
		rto.junction_no as _to 

FROM ticket t, schedule_detail shd, seats s, bogies b, rout rfrom, rout rto 

WHERE 
t.from_rout_id = rfrom.rout_id AND 
t.to_rout_id = rto.rout_id AND 
t.detail_id = $detail_id AND 
t.seat_id = s.seat_id AND 
s.bogie_id = b.bogies_id AND 
b.bogies_id = shd.bogie_id AND
shd.detail_id = t.detail_id

GROUP BY rfrom.junction_no, rto.junction_no";
//        echo ">>>".$query;
	$result = mysqli_query($con,$query);
	return $result;
            
        }
        public static function getReservedTicketsAll($train_id,$qdate){
	include("db_connectin.php");
$query = "SELECT shd.detail_id, s.seat_type, s.seat_id , b.bogies_id, rfrom.junction_no as _from, rto.junction_no as _to FROM ticket t, schedule_detail shd, schedule sh, days d, seats s, bogies b, rout rfrom, rout rto
WHERE
t.from_rout_id = rfrom.rout_id
AND
t.to_rout_id = rto.rout_id
AND
t.detail_id = shd.detail_id
AND
shd.schedule_id = sh.schedule_id
AND
sh.train_id = $train_id 
AND
sh.day_id = d.days_id
AND
d.date_of_train = '$qdate'
AND
t.seat_id = s.seat_id
AND
s.bogie_id = b.bogies_id
AND
b.bogies_id = shd.bogie_id";
//        echo ">".$query;
	$result = mysqli_query($con,$query);
	return $result;
    }
        public static function getReservedTickets($train_id,$qdate){
	include("db_connectin.php");
//$query = "SELECT shd.detail_id, s.seat_type, COUNT(s.seat_type) as count, b.bogies_id FROM ticket t, schedule_detail shd, schedule sh, days d, seats s, bogies b
//WHERE
//t.detail_id = shd.detail_id
//AND
//shd.schedule_id = sh.schedule_id
//AND
//sh.train_id = $train_id 
//AND
//sh.day_id = d.days_id
//AND
//d.date_of_train = '$qdate'
//AND
//t.seat_id = s.seat_id
//AND
//s.bogie_id = b.bogies_id
//AND
//b.bogies_id = shd.bogie_id
//GROUP BY s.seat_type";
$query = "SELECT shd.detail_id, s.seat_type, COUNT(s.seat_type) as count, b.bogies_id, rfrom.junction_no as _from, rto.junction_no as _to FROM ticket t, schedule_detail shd, schedule sh, days d, seats s, bogies b, rout rfrom, rout rto
WHERE
t.from_rout_id = rfrom.rout_id
AND
t.to_rout_id = rto.rout_id
AND
t.detail_id = shd.detail_id
AND
shd.schedule_id = sh.schedule_id
AND
sh.train_id = $train_id 
AND
sh.day_id = d.days_id
AND
d.date_of_train = '$qdate'
AND
t.seat_id = s.seat_id
AND
s.bogie_id = b.bogies_id
AND
b.bogies_id = shd.bogie_id
GROUP BY rfrom.junction_no, rto.junction_no";
        //echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function getTotalByBogie($train_id, $date, $bogie="b.bogies_id"){
	include("db_connectin.php");

        $query = "SELECT tr.train_name, d.date_of_train, b.bogie_name, shd.detail_id, s.seat_type, COUNT(s.seat_type), b.bogies_id
FROM train tr, days d, schedule_detail shd, schedule sh, bogies b, seats s
WHERE shd.schedule_id = sh.schedule_id
AND sh.train_id = tr.train_id
AND sh.day_id = d.days_id
AND shd.bogie_id = b.bogies_id AND
tr.train_id = $train_id
AND CAST(d.date_of_train AS DATE)  = '$date'
AND b.bogies_id = $bogie
AND b.bogies_id = s.bogie_id 
GROUP BY shd.detail_id";
       // echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function getTotalByBogieType($train_id, $date, $bogie="b.bogies_id"){
	include("db_connectin.php");

        $query = "SELECT tr.train_name, d.date_of_train, b.bogie_name, shd.detail_id, s.seat_type, COUNT(s.seat_type), b.bogies_id
FROM train tr, days d, schedule_detail shd, schedule sh, bogies b, seats s
WHERE shd.schedule_id = sh.schedule_id
AND sh.train_id = tr.train_id
AND sh.day_id = d.days_id
AND shd.bogie_id = b.bogies_id AND
tr.train_id = $train_id
AND CAST(d.date_of_train AS DATE)  = '$date'
AND b.bogies_id = $bogie
AND b.bogies_id = s.bogie_id 
GROUP BY b.bogie_name, s.seat_type";
        //echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function getTotalByDetailAll($train_id, $date, $bogie, $detail_id){
	include("db_connectin.php");

        $query = "SELECT tr.train_name, d.date_of_train, b.bogie_name, shd.detail_id, s.seat_type, s.seat_id, b.bogies_id
FROM train tr, days d, schedule_detail shd, schedule sh, bogies b, seats s
WHERE shd.schedule_id = sh.schedule_id
AND sh.train_id = tr.train_id
AND sh.day_id = d.days_id
AND shd.bogie_id = b.bogies_id AND
tr.train_id = $train_id
AND CAST(d.date_of_train AS DATE)  = '$date'
AND b.bogies_id = $bogie
AND b.bogies_id = s.bogie_id 
AND shd.detail_id = $detail_id";
  //      echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    public static function getTotalByDetail($train_id, $date, $bogie, $detail_id){
	include("db_connectin.php");

        $query = "SELECT tr.train_name, d.date_of_train, b.bogie_name, shd.detail_id, s.seat_type, COUNT(s.seat_id), b.bogies_id
FROM train tr, days d, schedule_detail shd, schedule sh, bogies b, seats s
WHERE shd.schedule_id = sh.schedule_id
AND sh.train_id = tr.train_id
AND sh.day_id = d.days_id
AND shd.bogie_id = b.bogies_id AND
tr.train_id = $train_id
AND CAST(d.date_of_train AS DATE)  = '$date'
AND b.bogies_id = $bogie
AND b.bogies_id = s.bogie_id 
AND shd.detail_id = $detail_id
GROUP BY s.seat_type";
  //      echo $query;
	$result = mysqli_query($con,$query);
	return $result;
    }
    
    public static function getTicketReserved($train_id, $date){
	include("db_connectin.php");
        $query = "SELECT * FROM reserved WHERE train_id = $train_id AND CAST(date_of_train AS DATE)  = '$date'";
	$result = mysqli_query($con,$query);
	return $result;
/*	$query  = "SELECT t.ticket_id, t.seat_no, t.pessanger, tr.train_name, d.date_of_train, cf.city_from, ct.city_to, b.bogie_name
FROM 	
	ticket t, 
	train tr, 
	days d, 
	city cf, 
	city ct, 
	schedule_detail shd, 
	schedule sh, 
	rout from_rout, 
	rout to_rout,
        bogies b
WHERE
        t.detail_id = shd.detail_id AND 
        shd.schedule_id = sh.schedule_id AND 
        sh.train_id = tr.train_id AND
        sh.day_id = d.days_id AND
        t.from_rout_id = from_rout.rout_id AND
	from_rout.city_id = cf.city_id AND
        t.to_rout_id = to_rout.rout_id AND
	to_rout.city_id = ct.city_id AND
        shd.bogie_id = b.bogies_id";
  */
    }

    public static function getTrains(){
	include("db_connectin.php");
	$query  = "SELECT * FROM train";
	$result = mysqli_query($con,$query);
	return $result;
    }

    public static function getDates($train_id){
	include("db_connectin.php");
	$query  = "SELECT * FROM days WHERE date_of_train >= CAST(CURRENT_TIMESTAMP AS DATE)";
	$result = mysqli_query($con,$query);
	return $result;
    }

    public static function getTicketsForAdding($detail_id, $seat_type){
	include("db_connectin.php");
	$query  = "SELECT shd.detail_id, s.seat_id, s.seat_no, rfrom.junction_no as _from, rto.junction_no as _to
FROM schedule_detail shd, bogies b, seats s, rout rfrom, route rto
WHERE 
    shd.bogie_id = b.bogies_id
AND b.bogies_id = s.bogie_id
AND shd.detail_id = $detail_id
AND s.seat_type = '$seat_type'";
        
       // echo $query;
	$result = mysqli_query($con,$query);
	return $result;        
    }
    public static function getSheduleDetails($from, $to, $date, $train, $bogie){
	include("db_connectin.php");
	$query  = "SELECT shd.detail_id, b.no_of_seats
        FROM schedule_detail shd, schedule s, days d, bogies b 
        WHERE s.train_id = $train 
        AND s.day_id = d.days_id 
        AND d.date_of_train = '$date' 
        AND s.schedule_id = shd.schedule_id 
        AND shd.bogie_id = b.bogies_id
        AND shd.bogie_id = $bogie";
//        echo $query;
	$result = mysqli_query($con,$query);
	return $result;        
    }

    public static function get_from_to_routes($from, $to, $train){
        include 'db_connectin.php';
        $query = "SELECT rout_id FROM rout WHERE train_id = $train AND junction_no = $from";
        $from = mysqli_query($con, $query);
        $query = "SELECT rout_id FROM rout WHERE train_id = $train AND junction_no = $to";
        $to = mysqli_query($con, $query);
        $route = array();
        if($row = mysqli_fetch_array($from)){
            $route['from'] = $row['rout_id'];
        }
        if($row = mysqli_fetch_array($to)){
            $route['to'] = $row['rout_id'];
        }
        return $route;
    }
    
    public static function addTicket($from, $_to, $detail_id, $seat_id, $pessanger){
	include("db_connectin.php");
	$query = "INSERT INTO ticket (from_rout_id, to_rout_id, detail_id, seat_id, pessanger) VALUES ($from, $_to, $detail_id, $seat_id, '$pessanger')";
     //   echo($query);
	$a=   mysqli_query($con,$query);
	return $a;
    }


    public static function addChapter($book_id, $chapter){

    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
//	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    $query = "INSERT INTO chapter (book_id, chapter_name) VALUES ($book_id, '$chapter')";
//echo($query);
	$a=   mysqli_query($con,$query);
	}
	return $a;
    }

    public static function addAnswer($mcq_id, $answer, $isTrue){

    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
	   		echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    	$query = "INSERT INTO answers (mcq_id, answer, istrue) VALUES ($mcq_id, '$answer', $isTrue)";
			echo($query);
			$a = mysqli_query($con,$query);
		}
		return $a;
    }

    public static function addMcq($chapter_id, $mcq){

		$mcq_id;
    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
	    	echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    	$query = "INSERT INTO mcq (chapter_id, mcq) VALUES ($chapter_id, '$mcq')";
			echo($query);
			$a=   mysqli_query($con,$query);
			if($a == 1){
				$query = "SELECT * FROM mcq order by mcq_id desc limit 1";
				echo($query);
				$res = mysqli_query($con, $query);
				if($row = mysqli_fetch_array($res)){
					$mcq_id = $row['mcq_id'];
					return $mcq_id;
				}
			}
		}
    }

    public static function AssignTest($subject_id, $program_id, $student_id){

    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
	    	echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    	$query = "INSERT INTO test_registration (subject_id, program_id, student_id) VALUES ($subject_id, $program_id, $student_id)";
			echo($query);
			mysqli_query($con,$query);
		}
    }

    public static function updateTestRegistration($write, $wrong, $attempted, $is_appeared, $test_id){

    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    $query = "UPDATE test_registration SET write_answers=$write, wrong=$wrong, attempted=$attempted, is_appeared=$is_appeared WHERE registration_id=$test_id";
echo($query);
	$a=   mysqli_query($con,$query);
	}
	return $a;
    }

    public static function getisCorrect($answer_id){
		$istrue;
    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    $query = "SELECT istrue FROM answers WHERE answer_id=".$answer_id;
echo($query);
	$a=   mysqli_query($con,$query);
	if($row = mysqli_fetch_array($a)){
		$istrue = $row['istrue'];
	}
	}
	return $istrue;
    }

    public static function addBook($subject_id, $book){

    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    $query = "INSERT INTO book (book_name) VALUES ('$book')";
echo($query);
	$a=   mysqli_query($con,$query);
	if($a==1){
	$query = "SELECT * FROM book order by book_id desc limit 1";
	echo($query);
	$res = mysqli_query($con, $query);
	$book_id;
	if($row = mysqli_fetch_array($res)){
	$book_id = $row['book_id'];
	}
	$query = "INSERT INTO book_sub (book_id, subject_id) VALUES ($book_id, $subject_id)";
	echo($query);
	$a = mysqli_query($con, $query);
	}
	}
	return $a;
    }

    public static function updateStudent($std_id, $std_name, $roll, $pass, $programs, $semister){

    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    $query = "UPDATE student SET name='$std_name', roll='$roll',password='$pass',semister_id=$semister WHERE student_id=$std_id";
echo($query);
	$a=   mysqli_query($con,$query);
	}
	return $a;
    }


    public static function deleteStudent($std_id){

    	$con=mysqli_connect("localhost","root","","etest");
    	// Check connection
    	if (mysqli_connect_errno($con)){
	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
    	}
    	else{
	    $query = "DELETE FROM student WHERE student_id=$std_id";
echo($query);
	$a=   mysqli_query($con,$query);
	}
	return $a;
    }

}
?>