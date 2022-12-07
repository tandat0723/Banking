package Bank_System.Connect;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = JDBC.getConnection(

        );
        System.out.println("Connecting success!!!");
    }
}
