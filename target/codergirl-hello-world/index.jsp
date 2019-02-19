<!DOCTYPE html>

<html>
<head>
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
   <h1> Looking for a new recipe! </h1>
   <h2>
        <a href="/new"> Add Your Favorite Recipe </a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list"> List All Favorite Recipes </a>

        </h2>
   </center>

   <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Recipes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Recipe</th>
                <th>Ingredients</th>
                <th>Quantity </th>
                <th>Measurements</th>
            </tr>
            <c:forEach var="recipe" items="${listRecipe}">
                <tr>
                    <td><c:out value= "${recipe.id}" /></td>
                    <td><c:out value= "${recipe.recipeName}" /></td>
                    <td><c:out value= "${recipe.ingredient}" /></td>
                    <td><c:out value= "${recipe.quantity}" /></td>
                    <td><c:out value= "${recipe.quantityUnit}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${recipe.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${recipe.id}' />">Delete</a>
                    </td>
                 </tr>
             </c:forEach>
          </table>
        </div>

        </main>

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