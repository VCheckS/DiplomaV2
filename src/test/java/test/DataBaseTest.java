package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.errorprone.annotations.Var;
import data.ConnectionConfig;
import data.DataHelper;
import data.SqlHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.DashBoard;

import javax.sql.DataSource;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class DataBaseTest {
    private static DataSource dataSource;
    @BeforeAll
    static void setUPAll() {
        var dbType = System.getProperty("t.db", "postgres");
        System.setProperty("t.db", dbType);

        var postgres = System.getProperty("t.postgres", "false");
        System.setProperty("t.postgres", postgres);

        var sql = System.getProperty("t.sql", "false");
        System.setProperty("t.sql", sql);


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        dataSource = ConnectionConfig.getDataSource();
        SqlHelper.setDataSource(dataSource);
    }

    @BeforeEach
    void setUp() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
        Configuration.timeout = 15000;
    }

    @AfterAll
    static void cleanUp() {
        SelenideLogger.removeListener("AllureSelenide");
    }


    @Test

    public void TestApprovedCardCredit()  throws SQLException {

        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
        String status = SqlHelper.getStatusCredit();
        System.out.println("Статус кредита: " + status);
        Assertions.assertEquals("APPROVED", status);
    }

    @Test

    public void TestApprovedCardPayment()  throws SQLException {

        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
        String status = SqlHelper.getStatusPayment();
        System.out.println("Статус кредита: " + status);
        Assertions.assertEquals("APPROVED", status);
    }
}
