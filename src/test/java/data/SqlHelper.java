package data;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlHelper {
    private QueryRunner sqlQueryRunner;
    private QueryRunner postgresQueryRunner;
    private static QueryRunner runner = new QueryRunner();

    public static SqlHelper() {
        try {
            Connection sqlConnection = ConnectionConfig.getConnSql();
            this.sqlQueryRunner = new QueryRunner((DataSource) sqlConnection);

            Connection postgresConnection = ConnectionConfig.getConnPostgres();
            this.postgresQueryRunner = new QueryRunner((DataSource) postgresConnection);
        } catch (SQLException e) {

        }
    }


    public static String getStatusPayment() {
        var statusSQL = "SELECT pe.status FROM payment_entity pe order by created DESC  LIMIT 1";
        try (var conn = ConnectionConfig.getConnSql()) {
            var status = runner.query(conn, statusSQL, new ScalarHandler<String>());
            return status;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static String getStatusCreditSql() {
        var sql = System.getProperty("t.sql");
        var statusSQL = "SELECT cre.status FROM credit_request_entity cre order by created DESC  LIMIT 1";
        try (var conn = ConnectionConfig.getConnSql()) {
            var status = runner.query(conn, statusSQL, new ScalarHandler<String>());

            return status;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static String getStatusCreditPostgres() {
        var postgres = System.getProperty("t.postgres");
        var statusPostgres = "SELECT cre.status FROM credit_request_entity cre order by created DESC  LIMIT 1";
        try (var conn = ConnectionConfig.getConnPostgres()) {
            var status = runner.query(conn, statusPostgres, new ScalarHandler<String>());

            return status;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }


}

