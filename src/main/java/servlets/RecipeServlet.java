package servlets;

import database.RecipeDAO;
import database.Recipe;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class RecipeServlet extends HttpServlet {
    //  private static final long serialVersionUID = 1L;
    private RecipeDAO recipeDAO;


    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        recipeDAO = new RecipeDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertRecipe(request, response);
                    break;
                case "/delete":
                    deleteRecipe(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateRecipe(request, response);
                    break;
                default:
                    listRecipe(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listRecipe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Recipe> listRecipe = recipeDAO.listAllRecipes();
        request.setAttribute("listRecipe", listRecipe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("RecipeForm");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Recipe existingRecipe = recipeDAO.getRecipe(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RecipeForm");
        request.setAttribute("recipe", existingRecipe);
        dispatcher.forward(request, response);

    }

    private void insertRecipe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String recipeName = request.getParameter("recipeName");
        String ingredient = request.getParameter("ingredient");
        String quantity = request.getParameter("quantity");
        String quantityUnit = request.getParameter("quantityUnit");

        Recipe newRecipe = new Recipe(recipeName, ingredient, quantity, quantityUnit);
        recipeDAO.insertRecipe(newRecipe);
        response.sendRedirect("list");
    }

    private void updateRecipe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String recipeName = request.getParameter("recipeName");
        String ingredient = request.getParameter("ingredient");
        String quantity = request.getParameter("quantity");
        String quantityUnit = request.getParameter("quantityUnit");

        Recipe recipe = new Recipe(id, recipeName, ingredient, quantity, quantityUnit);
        recipeDAO.updateRecipe(recipe);
        response.sendRedirect("list");
    }

    private void deleteRecipe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Recipe recipe = new Recipe(id);
        recipeDAO.deleteRecipe(recipe);
        response.sendRedirect("list");
    }
}


