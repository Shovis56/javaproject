<!DOCTYPE html>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <
    <script>
        $(document).ready(function(){
            $("#vanilla").click(function(){


                $.get("/ajaxrecipes", function(data, status){


                if(status == "success")
                    alert("Data: " + data + "\nStatus: " + status);
                $.innerHTML()
                if(status == "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText)


                });
            });
        });
    </script>


    <title>Bare Pantry: Guide to finding new recipes</title>

</head>
<style>
  body{
            background-image: url('kitchen.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center center;

     }

.container{
    display: block;
    position: relative;
    padding-left:35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

.container input{
    position: absolute;
    opacity: 0;
    cursor: pointer;
    height: 0;
    width: 0;
}

.checkmark{
    position: absolute;
    top: 0;
    left: 0;
    height: 25 px;
    width: 25px;
    background-color: #eee;
}

.container: hover input ~ .checkmark{
    background-color: #ccc;

    }

.container input: checked ~ .checkmark{
    background-color: #2196F3;
}

.checkmark:after{
    content: "";
    position: absolute;
    display: none;
}

.container input:checked ~ .checkmark:after{
    display: block;
}

.container .checkmark:after {
    left: 9px;
    top: 5px;
    width: 5px;
    height: 10px;
    border: solid white:
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform:rotate(45deg);
    transform: rotate(45deg);
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


</table>
<h3> Dairy Selections: </h3>
Butter
<input type ="radio" name="ingredient" value="butter" />
Milk
<input type ="radio" name="ingredient" value="milk" />
Egg
<input type ="radio" name="ingredient" value="egg" />
</p>

<h3> Sweetener Selections: </h3>
Brown Sugar
<input type ="radio" name="ingredient" value="brown sugar" />
Sugar
<input type ="radio" name="ingredient" value="sugar" />
</p>

<h3> Spices Selections: </h3>
Vanilla
<input type ="radio" name="ingredient" id="vanilla" value="vanilla" />
</p>


 </form>
</center>

    </main>

    <!-- //Footer -->
 <footer>

    <center> <p> Copyright 2018 by Sara Hovis </p> </center>

</footer>

</body>


</html>