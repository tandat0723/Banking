package Bank_System.Connect;


import java.sql.*;

public class ConnectDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306",
                "root",
                "12345678"
        );
    }
}
