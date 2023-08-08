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
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyNameFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findMustBeFilledMessage("Поле обязательно для заполнения");
    }

    @Test
    public void EmptyMonthFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setName();
        dashboard.setNextYear();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyYearFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setRandomMonth();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyCvcFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setNextYear();
        dashboard.setRandomMonth();

        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCardFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setStringCard();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldPaymentService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.stringMonth("Q,q");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void InvalidMonthFieldPaymentService2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();

        dashboard.setApprovedCardInfo();
        dashboard.stringMonth("!,@");

        dashboard.setNextYear();

        dashboard.setName();

        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldPaymentService3() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.stringMonth("~,й");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.stringYear("й, `");
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.stringYear("!, @");
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService3() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.stringName("Q, q");
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidNameFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.stringName("Iva4 !##ноВ");
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCvcFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.stringCvc("Q, !, @");
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void ScriptProtectionCardFieldPaymentServ() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.scriptCard("<script> alert('Hello!');</script>");
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void textNameFieldPaymentServ() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setNameLongText();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Превышена максимальная длина Имени");
    }


    @Test
    public void limitCheckMonthFieldPaymentServ1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.stringMonth("0','0");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void limitCheckMonthFieldPaymentServ2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.stringMonth("1','3");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }


    @Test
    public void limitCheckYearFieldPaymentServ1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setCurrentMonth();
        dashboard.setYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
    }


    @Test
    public void limitCheckYearFieldPaymentServ2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickButtonPayment();
        dashboard.setApprovedCardInfo();
        dashboard.setCurrentMonth();
        dashboard.limitYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }
}
