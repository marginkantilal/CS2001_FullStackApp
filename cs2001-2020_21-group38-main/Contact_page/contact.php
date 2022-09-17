<?php include 'sendemail.php'; ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="contact.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Footer css  -->
    <link rel="stylesheet" href="footer.css">
    <script src="nav.js"></script>
    <!-- navigation bar css  -->
    <link rel="stylesheet" href="nav.css">
    <link rel="stylesheet" href="footer.css">

    <!-- script to call other HTML files -->
    <script>
        $(function() {
            $('#footer').load('footer.html')
            $('#navigation').load('nav.html')
        });
    </script>
</head>

<body>

    <div id='navigation'></div>




    <!--alert messages start-->
    <?php echo $alert; ?>
    <!--alert messages end-->


<div class="content">
<div class="text-left">
<h2 style="text-align: center; margin-bottom:-4px;">GET IN TOUCH</h2>
<p style="text-align: center; padding:4%; font-size:14px; line-height:1.5; width: 100%; font-family:sans-serif; margin-bottom:5px;">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, <br> when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
</div>
</div>





<div class="container features">
		<div class="row" style="margin-bottom:75px;">
			<div class="col-lg-4 col-md-4 col-sm-12" style="font-size:14px; margin-left:5px; font-family:sans-serif; ">
				<h3> <br> <br> Information </h3>
				<p> <br>  First line of address <br> Second line of address <br> London, Postcode <br> EcoFriendBrunel@gmail.com <br> Number: 020 41665 651</p>
</div>

    <!--contact section start-->
<div class="col-lg-4 col-md-4 col-sm-12">
    <div class="contact-section" style = "width:500px;">
	<h2 style="text-align:center;">Contact Us</h2>
      <div class="contact-form" style = "background-color:#EAEDED;">
  
        <form class="contact" action="" method="post">
          <input type="text" name="name" class="text-box" placeholder="Your Name" required>
          <input type="email" name="email" class="text-box" placeholder="Your Email Address" required>
          <textarea name="message" rows="5" placeholder="Your message" required></textarea>
          <input type="submit" name="submit" class="send-btn" value="Send">
        </form>

      </div>
    </div>
</div>
</div>
    <!--contact section end-->

    <script type="text/javascript">
    if(window.history.replaceState){
      window.history.replaceState(null, null, window.location.href);
    }
    </script>







    <div id='footer'></div>



</body>


</html>