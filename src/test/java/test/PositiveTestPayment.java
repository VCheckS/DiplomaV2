package test;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashBoard;

import static com.codeborne.selenide.Selenide.open;

public class PositiveTestPayment {
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
    public void positiveTestWithApprovedCardPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
    }

    @Test
    public void positiveTestWithUnknownCardPaymentService() {

        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setUnknownCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findErrorMessage("Ошибка");
    }

    @Test  //оформить ишью
    public void positiveTestWithDeclinedCardPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setDeclinedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findErrorMessage("Ошибка");
    }
}
