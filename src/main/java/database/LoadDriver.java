package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoadDriver {
    static Connection conn=null;
    public LoadDriver(){
        try{
            conn= DriverManager.getConnection("jdbc:mysql://8888", "root","hello123");
            if(conn !=null)
            {
                System.out.println("Connection success");

            }
            else {
                System.out.println("fail");}}
        catch(SQLException e){
            System.out.println("MYSQL failed");
            e.printStackTrace();
            return;}
    }

    public Connection getConn(){
    return conn;}
}
