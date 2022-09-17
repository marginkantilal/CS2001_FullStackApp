<?php

$mysqli = new mysqli('172.31.82.135:3306', 'root', 'Ecofriend38', 'ecofriend') or die (mysqli_error($mysqli));//connect to database, if failed output error
$result = $mysqli->query("SELECT * FROM foodbank_stock") or die ($mysqli->error);//outputs current database values
//outputs all items from database
 function pre_r($array){
  echo'<pre>';
  print_r($array);
  echo'</pre>';
 }

?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>StockList</title>
    <!-- CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css" />
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


  </head>  
    <body>

    <header>
      <h1>Foodbank Stock</h1>
    </header>

      <?php require_once 'process.php';
      ?>

      <?php
      if (isset($_SESSION['message'])):
      ?>

        <div class="alert alert-<?=$_SESSION['msg_type']?>"> <!-- bootstrapclass either alert-danger or alert-success -->
      
        <?php
          echo $_SESSION['message'];
          unset($_SESSION['message']);
        ?>
      
      </div>

      <?php endif ?>


      <div class = "container">
      <?php
      $mysqli = new mysqli('172.31.82.135:3306', 'root', 'Ecofriend38', 'ecofriend') or die (mysqli_error($mysqli));
      $result = $mysqli->query("SELECT * FROM foodbank_stock") or die ($mysqli->error);
      ?>

<!--  -->
      

        <div class="row justify-content-center">

        <form action="" method="POST"><!-- form and data sent using POST method -->
            <input type="hidden" name="id" value="<?php echo $id; ?>">
            <div class="form-group">
            <label>Item</label><!-- name field and text-->
            <input type="text" name="item" class="form-control" value="<?php echo $item;?>" placeholder="Enter your item">
            </div>

            <div class="form-group"><!-- quantity field and text-->
            <label>Quantity</label>
            <input type="text" name="quantity" class="form-control" value="<?php echo $quantity;?>" placeholder="Enter the quantity">
            </div>

            <div class="form-group"><!-- save button or update-->
            <?php if ($update==true):?><!-- if update is true button is update-->
            <button type="submit" class="btn btn-primary"  name="update">Update</button>
            <?php else:?><!-- otherwise button is save-->
            <button type="submit" class="btn btn-primary"  name="save">Save</button>
            <?php endif; ?>
            </div>

        </form>

        </div>

        <div class = "row justify-content-center"><!--div around table and centers -->
        <table class="table">
          <thead><!-- table headers -->
            <tr>
              <th>Item</th>
              <th>Quantity</th>
              <th colspan="2">Action</th>
            </tr>
          </thead>

        <?php
        while($row = $result->fetch_assoc()):?><!--recursivly outputs rows with associated data from database till all rows done-->
        <tr>
          <td><?php echo $row['item'];?></td>
          <td><?php echo $row['quantity'];?></td>
          <td>
            <a href="index.php?edit=<?php echo $row["id"];?>"
              class="btn btn-info">Edit</a><!-- if edit button pressed add row id to variable row -->
            <a href="process.php?delete=<?php echo $row["id"];?>"
              class="btn btn-danger">Delete</a><!-- if delete button pressed add row id to variable row -->

          </td>
        </tr>
        <?php endwhile; ?>

        </table>
      </div>
        </div> <!-- close div container -->
       
    </body>
</html>


