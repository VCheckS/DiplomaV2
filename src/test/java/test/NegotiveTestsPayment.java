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
        DashBoard.clickButtonPayment();

        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyNameFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));

        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findMustBeFilledMessage("Поле обязательно для заполнения");
    }

    @Test
    public void EmptyMonthFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));

        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyYearFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);

        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void EmptyCvcFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);

        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCardFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = StringGenerator.stringCard();
        DashBoard.getCardInfo().setValue(cardNumber);
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldPaymentService1() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        DashBoard.getMonth().setValue("Q, q");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }

    @Test
    public void InvalidMonthFieldPaymentService2() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        DashBoard.getMonth().setValue("!, @");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidMonthFieldPaymentService3() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        DashBoard.getMonth().setValue("й, `");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService1() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        DashBoard.getYear().setValue("й, `");
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService2() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        DashBoard.getYear().setValue("!, @");
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidYearFieldPaymentService3() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        DashBoard.getYear().setValue("Q, q");
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidNameFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = StringGenerator.stringCard();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void InvalidCvcFieldPaymentService() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        DashBoard.getCvc().setValue("Q, !, @");
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void ScriptProtectionCardFieldPaymentServ() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        DashBoard.getCardInfo().setValue("<script> alert('Hello!');</script>");
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void textNameFieldPaymentServ() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.generateRandomMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.text();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Превышена максимальная длина Имени");
    }


    @Test
    public void limitCheckMonthFieldPaymentServ1() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        DashBoard.getMonth().setValue("0','0");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findWrongFormatMessage("Неверный формат");
    }


    @Test
    public void limitCheckMonthFieldPaymentServ2() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        DashBoard.getMonth().setValue("1','3");
        var year = DataHelper.getLastTwoDigitsOfYear() + 1;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }


    @Test
    public void limitCheckYearFieldPaymentServ1() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.currentMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear();
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findSuccessMessage("Успешно");
    }


    @Test
    public void limitCheckYearFieldPaymentServ2() {
        DashBoard dashboard = new DashBoard();
        DashBoard.clickButtonPayment();
        var cardNumber = DataHelper.getApprovedCardInfo();
        DashBoard.getCardInfo().setValue(String.valueOf(cardNumber));
        var month = DataHelper.currentMonth();
        DashBoard.getMonth().setValue(month);
        var year = DataHelper.getLastTwoDigitsOfYear() + 6;
        DashBoard.getYear().setValue(String.valueOf(year));
        var name = DataHelper.generateRandomName();
        DashBoard.getName().setValue(name);
        var cvc = DataHelper.generateCvcCode();
        DashBoard.getCvc().setValue(cvc);
        DashBoard.clickButtonCont();
        DashBoard.findInvalidCardExpirationDate("Неверно указан срок действия карты");
    }
}
