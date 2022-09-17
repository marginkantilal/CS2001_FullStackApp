<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">


   <!------------------------ Font Awesome --------------------------->

   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css ">
   <!------------------------ Google Font --------------------------->

   <link href="https://fonts.googleapis.com/css2?family=Alegreya+Sans+SC&family=Anton&family=Passion+One&display=swap" rel="stylesheet">

   <!------------------------ CSS --------------------------->
   <link rel="stylesheet" href="nav.css">
   <!------------------------ Javascript--------------------------->
   <script src="nav.js"></script>

  <!-- CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.js"></script>
  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <!-- JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="forum.js"></script>
  
  <link rel="stylesheet" href="forum.css">
  <link rel="stylesheet" href="footer.css">
  	<!-- naigation bar css  -->
	<link rel="stylesheet" href="nav.css">
  <title>Forum</title>

  <!-- script to call other HTML files -->
  <script>
		$(function(){
			$('#navigation').load('nav.html')
      $('#footer').load('footer.html')
		});
		</script>

</head>

<body>
  <!-- nav bar HTML-->
  <div id='navigation'></div>
  
  <div class="container text-center">
    <h1>Forum</h1>
  </div>

 
  <div class="row mb-5 mt-5"> 
    <div class="col-sm-3 text-center mx-auto">
        <div class="form mt-4">
          <!-- Create Topic form-->
          <form action="forumController.php" method="post">
            <div class="form-group"> 
                <label for="Category">Choose Category</label>
                <select class="form-control" id="selectCategoryC" name="categoryC">
                    <option id="organisation">organisatons</option>
                    <option>help</option>
                    <option>other</option>
                </select>
            </div>

            <div class="form-input">
                <label for="inputTopic">Enter Topic</label>
                <?php 
                  if(isset($_SESSION['how_many']))
                  {
                    echo'<p>'.$SESSION['how_many'].'</p>';
                    unset($_SESSION['how_many']);
                  }
                ?>
                <input type="text" class="form-control" id="topicNameC" name="topicC" placeholder="Topic">
            </div>

            <div class="form-group">
                <textarea class="form-control" id="discussionFieldC" name="textC" rows="3" placeholder="Here you can start your discussion."></textarea>
            </div>

            <button type="submit" class="btn btn-success mb-2" id="submit" onclick="createTopic()">Create Topic</button>
          </form>
        </div>

        <img src="logo.png" alt="ecofriend logo" width="280" class="img-fluid ml-4 mx-auto"/>

        <!-- Search Topic form-->
        <div class="form mb-4">
          <form action="forumController.php" method="post">
            <div class="form-group">
                <label for="Category">Choose Category</label>
                <select class="form-control" id="selectCategoryS" name="categoryS">
                    <option>organisatons</option>
                    <option>help</option>
                    <option>other</option>
                </select>
            </div>

            <div class="form-input">
                <label for="inputKeyword" id="keywordS">Enter Keyword</label>
                <input type="text" name="textS" class="form-control" placeholder="Keyword">
            </div>

            <button type="submit" class="btn btn-success mb-2 mt-2" onclick="searchTopic()">Search Topic</button>
          </form>
        </div>
    </div> 

    <!-- list of all topics on the forum-->
 	  <div class="col-sm-8 mx-auto">
      <div class="container">
        <table class="table table-hover" id="forumTable">
          <thead>
            <tr>
              <th>
                Topic
              </th>
              <th>
                <div class="dropdown">
                  <button class="btn btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Category
                  </button>
                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="categoryButton" oninput="">
                    <a class="dropdown-item" href="#">Organisatons</a>
                    <a class="dropdown-item" href="#">Help</a>
                    <a class="dropdown-item" href="#">Others</a>
                  </div>
                </div>
              </th>
              <th>
                <label for="myInput">
                <!-- Searching bar-->
                <input type="text" id="myInput" onkeyup="filterTable()" placeholder="Search for names.." title="Type in a name">
                </label>
              </th>
              <th>
                Replies
              </th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <a href="#">Discussion topic name</a>
              </td>
              <td>
                <a href="#">Help</a>
              </td>
              <td>
                <a href="#">user name1</a>
              </td>
              <td>
                7
              </td>
            </tr>
            <tr>
              <td>
                <a href="#">topic name</a>
              </td>
              <td>
                <a href="#">Organisatons</a>
              </td>
              <td>
                <a href="#">user name2</a>
              </td>
              <td>
                22
              </td>
            </tr>
            <tr>
              <td>
                <a href="#">topic discussion</a>
              </td>
              <td>
                <a href="#">Others</a>
              </td>
              <td>
                <a href="#">user name3</a>
              </td>
              <td>
                2
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div> 
  </div> 

<footer class="page-footer fixed-bottom">
   <div id='footer'></div>
</footer>

</body>
<!-- run included HTML -->
<script>
  includeHTML();
  </script> 
</html>