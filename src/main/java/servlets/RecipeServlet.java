package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import database.DBConnector;


public class RecipeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        ResultSet rs = null;
        Statement stmt = null;


        try {

            Connection conn = new DBConnector().getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT ingredient_name FROM ingredients");

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                writer.print(rs.getString("ingredient_name"));

            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());


        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx);
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx);
                }
            }
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();


        PreparedStatement statement = null;
        String sql = "INSERT INTO recipes (recipe_name) values (?)";
        String recipe_name = request.getParameter("recipeName");
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.prepareStatement(sql);
            statement.setString(1, recipe_name);
            int i = statement.executeUpdate();
            writer.print(i + " ");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }

    }
}


