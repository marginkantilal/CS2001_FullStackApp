<?php

require_once "forum_connect.php";

// Create connection
$conn = @new mysqli($servername, $username, $password, $dbname);   //@ hides unwanted details from user
// Check connection
if ($conn->connect_error) 
{
  die("Connection failed: " . $conn->connect_error);
} 
  //$category=$_POST['categoryC'];

  $sql = "SELECT* FROM forum";   
  
  if ($conn->query($sql) === TRUE) 
  {
    echo '<table>
    <tr>
    <td>Forename</td>
    <td>Surname</td>
    </tr>
    <tr>
    <td>'.$result["forename"].'</td>
    <td>'.$result["surname"].'</td>
    </tr>
    </table>';
  }
  else
  {
    echo "Error: " . $sql . "<br>" . $conn->error;
  }
  
  $conn->close();

?>