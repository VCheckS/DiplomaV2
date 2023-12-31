package data;


import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlHelper {
    private static QueryRunner runner = new QueryRunner();

    @SneakyThrows
    public static String getStatusPayment() {
        var url = System.getProperty("url");
        var login = System.getProperty("login");
        var password = System.getProperty("password");
        var statusSQL = "SELECT pe.status FROM payment_entity pe ORDER BY created DESC LIMIT 1";

        Connection conn = DriverManager.getConnection(url, login, password);
        return runner.query(conn, statusSQL, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getStatusCredit() {
        var url = System.getProperty("url");
        var login = System.getProperty("login");
        var password = System.getProperty("password");
        var statusSQL = "SELECT cre.status FROM credit_request_entity cre ORDER BY created DESC LIMIT 1";

        Connection conn = DriverManager.getConnection(url, login, password);
        return runner.query(conn, statusSQL, new ScalarHandler<>());
    }

}
