package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection conn;
    public DBConnector(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/MyRecipeBook?useLegacyDatetimeCode=false&serverTimezone=UTC", "root","joshsar56");
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn()
    {

        return this.conn;
    }

}
