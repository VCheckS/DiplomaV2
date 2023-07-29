package data;


import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.Connection;

public class SqlHelper {
    private static QueryRunner runner = new QueryRunner();
    private static DataSource dataSource;

    public static void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    @SneakyThrows
    public static String getStatusPayment() {

        var dbType = System.getProperty("t.db", "sql");

        if ("postgres".equalsIgnoreCase(dbType)) {
            String statusSQL = "SELECT pe.status FROM payment_entity pe ORDER BY created DESC LIMIT 1";
            try (Connection conn = dataSource.getConnection()) {
                return runner.query(conn, statusSQL, new ScalarHandler<>());
            }
        } else {
            String statusSQL = "SELECT pe.status FROM payment_entity pe ORDER BY created DESC LIMIT 1";
            try (Connection conn = dataSource.getConnection()) {
                return runner.query(conn, statusSQL, new ScalarHandler<>());
            }
        }
    }

    @SneakyThrows
    public static String getStatusCredit() {
        String dbType = System.getProperty("t.db", "sql");

        if ("postgres".equalsIgnoreCase(dbType)) {
            String statusSQL = "SELECT cre.status FROM credit_request_entity cre ORDER BY created DESC LIMIT 1";
            try (Connection conn = dataSource.getConnection()) {
                return runner.query(conn, statusSQL, new ScalarHandler<>());
            }
        } else {
            String statusSQL = "SELECT cre.status FROM credit_request_entity cre ORDER BY created DESC LIMIT 1";
            try (Connection conn = dataSource.getConnection()) {
                return runner.query(conn, statusSQL, new ScalarHandler<>());
            }
        }

    }


}
