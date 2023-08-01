package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.StringGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashBoard;

import static com.codeborne.selenide.Selenide.open;

public class NegotiveTestsPayment {
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
    public void EmptyCardFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getRandomMonth();
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyNameFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getRandomMonth();
        dashboard.getNextYear();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findMustBeFilledMessage("Поле обязательно для заполнения");
    }

    @Test
    public void EmptyMonthFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getName();
        dashboard.getNextYear();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyYearFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getRandomMonth();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyCvcFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getNextYear();
        dashboard.getRandomMonth();

        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCardFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getStringCard();
        dashboard.getRandomMonth();
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldPaymentService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("Q,q");
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void InvalidMonthFieldPaymentService2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();

        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("!,@");

        dashboard.getNextYear();

        dashboard.getName();

        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldPaymentService3() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("~,й");
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getRandomMonth();
        dashboard.stringYear("й, `");
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getRandomMonth();
        dashboard.stringYear("!, @");
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService3() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getRandomMonth();
        dashboard.stringName("Q, q");
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidNameFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getRandomMonth();
        dashboard.getNextYear();
        dashboard.stringName("Iva4 !##ноВ");
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCvcFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getRandomMonth();
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.stringCvc("Q, !, @");
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void ScriptProtectionCardFieldPaymentServ() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.scriptCard("<script> alert('Hello!');</script>");
        dashboard.getRandomMonth();
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void textNameFieldPaymentServ() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getRandomMonth();
        dashboard.getNextYear();
        dashboard.getNameLongText();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Превышена максимальная длина Имени");
    }


    @Test
    public void limitCheckMonthFieldPaymentServ1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("0','0");
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void limitCheckMonthFieldPaymentServ2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("1','3");
        dashboard.getNextYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }


    @Test
    public void limitCheckYearFieldPaymentServ1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getCurrentMonth();
        dashboard.getYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
    }


    @Test
    public void limitCheckYearFieldPaymentServ2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.getApprovedCardInfo();
        dashboard.getCurrentMonth();
        dashboard.limitYear();
        dashboard.getName();
        dashboard.getCvc();
        dashboard.clickButtonCont();
        dashboard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }
}
