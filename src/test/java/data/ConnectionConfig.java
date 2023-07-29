package data;


import lombok.SneakyThrows;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionConfig {
    private ConnectionConfig() {

    }

    @SneakyThrows
    public static DataSource createSqlDataSource() {
        String url = "jdbc:mysql://localhost:3306/app";
        String username = "app";
        String password = "pass";
        return createDataSource(url, username, password);
    }

    @SneakyThrows
    public static DataSource createPostgresDataSource() {
        String url = "jdbc:postgresql://localhost:5432/app";
        String username = "app";
        String password = "pass";
        return createDataSource(url, username, password);
    }

    private static DataSource createDataSource(String url, String username, String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @SneakyThrows
    public static DataSource getDataSource() {
        String db = System.getProperty("t.db", "sql");
        if ("postgres".equalsIgnoreCase(db)) {
            return createPostgresDataSource();
        } else {
            return createSqlDataSource();
        }
    }

}