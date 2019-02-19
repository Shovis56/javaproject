package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Statement;


public class RecipeDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public RecipeDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    private void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    private void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertRecipe(Recipe recipe) throws SQLException {
        String sql = "INSERT INTO recipe (recipeName, ingredient, quantity, quantityUnit) VALUES (?, ?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, recipe.getRecipeName());
        statement.setString(2, recipe.getIngredient());
        statement.setString(3, recipe.getQuantity());
        statement.setString(4, recipe.getQuantityUnit());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Recipe> listAllRecipes() throws SQLException {
        List<Recipe> listRecipe = new ArrayList<>();

        String sql = "SELECT * FROM recipe";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("recipe_id");
            String recipeName = resultSet.getString("recipeName");
            String ingredient = resultSet.getString("ingredient");
            String quantity = resultSet.getString("quantity");
            String quantityUnit = resultSet.getString("quantityName");

            Recipe recipe = new Recipe(id, recipeName, ingredient, quantity, quantityUnit);
            listRecipe.add(recipe);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listRecipe;
    }

    public boolean deleteRecipe(Recipe recipe) throws SQLException {
        String sql = "DELETE FROM recipe where recipe_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, recipe.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateRecipe(Recipe recipe) throws SQLException {

        String sql = "UPDATE recipe SET recipeName =?, ingredient = ?, quantity =?, quantityUnit =?";
        sql += " WHERE recipe_id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, recipe.getRecipeName());
        statement.setString(2, recipe.getIngredient());
        statement.setString(3, recipe.getQuantity());
        statement.setString(4, recipe.getQuantityUnit());
        statement.setInt(5, recipe.getId());


        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Recipe getRecipe(int id) throws SQLException {
        Recipe recipe = null;
        String sql = "SELECT * FROM recipe WHERE recipe_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String recipeName = resultSet.getString("recipeName");
            String ingredient = resultSet.getString("ingredient");
            String quantity = resultSet.getString("quantity");
            String quantityUnit = resultSet.getString("quantityUnit");

            recipe = new Recipe(id, recipeName, ingredient, quantity, quantityUnit);
        }

        resultSet.close();
        statement.close();

        return recipe;
    }
}