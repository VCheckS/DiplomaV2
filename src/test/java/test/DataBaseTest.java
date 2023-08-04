package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.SqlHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import page.DashBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class DataBaseTest {

    @BeforeAll
    @SneakyThrows
    static void setUPAll() throws SQLException {


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
    @SneakyThrows
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
    @SneakyThrows
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
