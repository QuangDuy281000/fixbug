package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    public static Connection CreateConnection() {
        Connection conn = null;
        String url = "jdbc:sqlserver://nienluannam3.mssql.somee.com";
        String user = "leduy_SQLLogin_1";
        String password = "57cevjojjc";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
