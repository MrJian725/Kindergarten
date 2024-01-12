package utils;


import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class JdbcUtils {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/kindergarten?useUnicode=true&characterEncoding=UTF-8&useSSL=FALSE";
    private static String username = "root";
    private static String password = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    public static void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
