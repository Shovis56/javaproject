package servlets;

import database.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;







public class RecipeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        PrintWriter writer = response.getWriter();


      java.sql.PreparedStatement ps = null;
      ResultSet rs = null;

      try{

          Connection conn = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/servlet", "root", "joshsar56");



              String b = request.getParameter("butter");
              String m = request.getParameter("milk");
              String e = request.getParameter("egg");
              String bs = request.getParameter("brown suger");
              String s = request.getParameter("sugar");

//          PreparedStatement ps = conn
//                  .prepareStatement("insert into ");

          ps.setString(1,b);
          ps.setString(2,m);
          ps.setString(3,e);
          ps.setString(4,bs);
          ps.setString(5,s);

          int i = ps.executeUpdate();
          if(i>0)
              System.out.print("Here is your Recipe");
      }catch (Exception e2){
          System.out.println(e2);
      }

      writer.close();

    }

}
