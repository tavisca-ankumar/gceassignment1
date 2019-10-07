import java.sql.*;

public class DatabaseConnector {

    Connection sqlConnection;

    public DatabaseConnector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            sqlConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/anoop", "root", "root");
            System.out.println("Database connected");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
