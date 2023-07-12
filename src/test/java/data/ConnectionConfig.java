package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
    public static Connection getConnSql() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/app";
        String username = "app";
        String password = "pass";
        return DriverManager.getConnection(url, username, password);
    }

    public static Connection getConnPostgres() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/app";
        String username = "app";
        String password = "pass";
        return DriverManager.getConnection(url, username, password);
    }
}
