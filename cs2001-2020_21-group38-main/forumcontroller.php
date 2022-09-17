<?php

session_start(); 

require_once "forum_connect.php";


// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);   //@ hides, can be replaced with try catch
// Check connection
if ($conn->connect_error) 
{
  die("Connection failed: " . $conn->connect_error);
} 
  $category=$_POST['categoryC'];
  $topic=$_POST['topicC'];
  $textField=$_POST['textC'];  
  //$username=$_POST['username'];

  //$topicExist = $conn->query("SELECT idforum FROM forum WHERE topic='$topic'");

  //echo $topicExist;
  //if(!$topicExist) throw new Exception ($conn->error);

  /*$how_many_exist = $topicExist->num_rows;

  if($how_many_exist>0)
  {
    $_SESSION['how_many']="We already have topic with such a name. Maybe you would like to check this out below?";
  }
  else
  {*/
    $sql = "INSERT INTO forum (category, topic, textField, username, replies)    /* query adding new row into table*/
    VALUES ('$category', '$topic', '$textField','user34', '0')";  //replies set to 0`, user taken from cookie?

    //header('Location: forum.php');


    if ($conn->query($sql) === TRUE) 
    {
      echo "New record created successfully";
    }
      else
    {
      echo "Error: " . $sql . "<br>" . $conn->error;
    }

//  }

$conn->close();

?>