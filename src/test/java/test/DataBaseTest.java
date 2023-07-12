package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SqlHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.DashBoard;

import static com.codeborne.selenide.Selenide.open;

public class DataBaseTest {
    @BeforeAll
    static void setUPAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
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

    public void TestApprovedCardCreditSql() {

        var postgres = System.getProperty("t.postgres");
        var sql = System.getProperty("t.sql");
        if ("postgres".equals(postgres)) {

        } else if ("sql".equals(sql)) {

        } else {

        }

        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
        SqlHelper status = new SqlHelper();
        status.getStatusCreditSql();
        System.out.println("Статус кредита: " + status);
        Assertions.assertEquals("APPROVED", status);
    }

    @Test
    public void TestApprovedCardCreditPostgres() {
        String postgres = System.getProperty("t.postgres");
        String sql = System.getProperty("t.sql");
        if ("postgres".equals(postgres)) {

        } else if ("sql".equals(sql)) {

        } else {

        }
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        var cardNumber = DataHelper.getApprovedCardInfo();
        dashboard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        dashboard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        dashboard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        dashboard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        dashboard.getCvc().setValue(cvc);
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
        SqlHelper status = new SqlHelper();
        status.getStatusCreditPostgres();
        System.out.println("Статус кредита: " + status);
        Assertions.assertEquals("APPROVED", status);
    }
}
