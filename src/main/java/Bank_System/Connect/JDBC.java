package Bank_System.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static Connection connect;

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/bankdb?autoReconnect=true&useSSL=false";
            String userName = "root";
            String passWord = "12345678";
            connect = DriverManager.getConnection(dbUrl,userName,passWord);
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return connect;
    }
    public void close() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
