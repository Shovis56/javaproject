<!DOCTYPE html>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Bare Pantry: Guide to finding new recipes</title>

</head>
<style>
  body{
            background-image: url('kitchen.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center center;

     }


  h1{

    color: #AF7595;
    font-family: 'Open Sans', Arial, sans-serif;

    }

  footer{
        background: #3AB8C4;
        padding: 6px;
        color: #AED4E6;
        font-family: 'Open Sans', Arial, sans-serif;
        font-size: 16px;

    }
</style>

<body>



    <!-- // Intro -->
   <header>
           <img src='pantry.png' alt="Bare Pantry">

       </header>


   <main>
        <!-- // Intro -->

   <center>
   <h1> Looking for a new recipe! Click to add the ingredients you have and we will do the rest! </h1>



        <h2>Categories</h2>
        <p>Select from the different categories and find the ingredients you have to try new recipes!</p>

<form method="post" action="SelectIngredient">
<br>
<

<label class="container">Butter
  <input type="checkbox">
  <span class="checkmark"></span>
</label>
<label class="container">Milk
  <input type="checkbox">
  <span class="checkmark"></span>
</label>
<label class="container">Egg
  <input type="checkbox">
  <span class="checkmark"></span>
</label>





    <label class="container">Brown Sugar
      <input type="checkbox">
      <span class="checkmark"></span>
    </label>
    <label class="container">Sugar
      <input type="checkbox">
      <span class="checkmark"></span>
    </label>

<label class="container">Vanilla
  <input type="checkbox">
  <span class="checkmark"></span>
</label>

</select>
<br><br>
<input type="submit">
</form>
</center>

    </main>

    <!-- //Footer -->
 <footer>

     <p> Copyright 2018 by Sara Hovis </p>

</footer>

</body>


</html>