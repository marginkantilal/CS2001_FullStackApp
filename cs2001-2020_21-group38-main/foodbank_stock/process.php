<?php
session_start();

$mysqli = new mysqli('172.31.82.135:3306', 'root', 'Ecofriend38', 'ecofriend');//database connection
//declare variables
$update=false;
$quantity='';
$item='';
$id=0;


if (isset($_POST['save'])){
  $item = $_POST['item'];
  $quantity = $_POST['quantity'];

  $mysqli->query("INSERT INTO foodbank_stock (item, quantity) VALUES('$item', '$quantity')") or
  die($mysqli->error);

  $_SESSION['message']="Record has been saved";
  $_SESSION['msg_type'] ="success";//used for bootstrap alert-success

  header("location: index.php");
}//save POST function, grabs data from fields, puts in variable and inserts to database using mysql
//then return to index page
//success notification upon successful save


if(isset ($_GET['delete'])){
  $id =$_GET['delete'];
  $mysqli->query("DELETE FROM foodbank_stock WHERE id=$id")or die($mysqli->error());

  $_SESSION['message']="Record has been deleted!";
  $_SESSION['msg_type'] ="danger";//used for bootstrap alert-danger
  header("location: index.php");
}//if the delete button is pressed get id of the row and delete that row in database
//notify user of sixxesful delete

if(isset($_GET['edit'])){
  $id=$_GET['edit'];
  $update=true;//edit button changes to update
  $result = $mysqli->query("SELECT * FROM foodbank_stock WHERE id=$id") or die($mysqli->error());

    $row = $result->fetch_array();
    $item = $row['item'];
    $quantity=$row['quantity'];
}//if edit is clicked, data is fetched from database for that row and inserted into the fields


if (isset($_POST['update'])){
  $id=$_POST['id'];
  $item=$_POST['item'];
  $quantity=$_POST['quantity'];

  $mysqli->query("UPDATE foodbank_stock SET item='$item', quantity='$quantity' WHERE id=$id") or die ($mysqli->error());
  $_SESSION['message'] = "Record has been updated!";
  $_SESSION['msg_type'] = "warning";//bootstrap alert-warning

  header("location: index.php");//return to index page
}//takes current data in fields and replaces in database for the selected edit row




?>