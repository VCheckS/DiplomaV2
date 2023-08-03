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

public class NegativeTestsCredit {
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
    public void EmptyCardFieldCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();

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
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findMustBeFilledMessage("Поле обязательно для заполнения");
    }

    @Test
    public void EmptyMonthFieldCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setName();
        dashboard.setNextYear();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void EmptyYearFieldCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();

        dashboard.setName();
        dashboard.setRandomMonth();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyCvcFieldCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setNextYear();
        dashboard.setRandomMonth();

        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void InvalidCardFieldCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.setStringCard();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldCreditService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("Q,q");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldCreditService2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("!,@");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void InvalidMonthFieldCreditService3() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("~,й");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldCreditService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.stringYear("й, `");
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldCreditService2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.stringYear("!, @");
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldCreditService3() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.stringYear("Q, q");
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void InvalidNameFieldCreditService1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.stringName("Iva4 !##ноВ");
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCvcFieldCreditService() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.stringCvc("Q, !, @");
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void ScriptProtectionCardFieldCreditServ() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.scriptCard("<script> alert('Hello!');</script>");
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void textNameFieldCreditServ() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setRandomMonth();
        dashboard.setNextYear();
        dashboard.setNameLongText();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Превышена максимальная длина Имени");
    }

    @Test
    public void limitCheckMonthFieldCreditServ1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("0','0");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void limitCheckMonthFieldCreditServ2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.stringMonth("1','3");
        dashboard.setNextYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }

    @Test
    public void limitCheckYearFieldCreditServ1() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setCurrentMonth();
        dashboard.setYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findSuccessMessage("Успешно");
    }

    @Test
    public void limitCheckYearFieldCreditServ2() {
        DashBoard dashboard = new DashBoard();
        dashboard.clickCreditButton();
        dashboard.getApprovedCardInfo();
        dashboard.setCurrentMonth();
        dashboard.limitYear();
        dashboard.setName();
        dashboard.setCvc();
        dashboard.clickButtonCont();
        dashboard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }
}



