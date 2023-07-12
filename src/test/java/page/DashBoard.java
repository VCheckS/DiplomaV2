package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DashBoard {


        private static SelenideElement buttonCredit = $x("//*[contains(text(), 'Купить в кредит')]");
        private static SelenideElement buttonPayment = $x("//*[contains(text(), 'Купить')]");
        private static SelenideElement cardInfo = $$(".input__control").get(0);
        private static SelenideElement month = $$(".input__control").get(1);
        private static SelenideElement year = $$(".input__control").get(2);

        private static SelenideElement name = $$(".input__control").get(3);
        private static SelenideElement cvc = $$(".input__control").get(4);
        private static SelenideElement buttonCont = $$("button").find(exactText("Продолжить"));
        private static SelenideElement errorMessage = $(byText("Ошибка"));
        private static SelenideElement successMessage = $(byText("Успешно"));
        private static SelenideElement wrongFormatMessage = $(byText("Неверный формат"));
        private static SelenideElement mustBeFilledMessage = $(byText("Поле обязательно для заполнения"));
        private static SelenideElement invalidCardExpirationDate = $(byText("Неверно указан срок действия карты"));

        public static void findErrorMessage(String expectedText) {
                errorMessage.shouldHave(partialText(expectedText)).shouldBe(visible);
        }

        public static void findSuccessMessage(String expectedText) {
                successMessage.shouldHave(partialText(expectedText)).shouldBe(visible);
        }

        public static void findWrongFormatMessage(String expectedText) {
                wrongFormatMessage.shouldHave(partialText(expectedText)).shouldBe(visible);
        }

        public static void findMustBeFilledMessage(String expectedText) {
                mustBeFilledMessage.shouldHave(partialText(expectedText)).shouldBe(visible);
        }

        public static void findInvalidCardExpirationDate(String expectedText) {
                invalidCardExpirationDate.shouldHave(partialText(expectedText)).shouldBe(visible);
        }


        public static void clickButtonPayment() {
                buttonPayment.click();
        }

        public static void clickCreditButton() {
                buttonCredit.click();
        }

        public static SelenideElement getCardInfo() {
                return cardInfo;
        }

        public static SelenideElement getMonth() {
                return month;
        }

        public static SelenideElement getYear() {
                return year;
        }

        public static SelenideElement getName() {
                return name;
        }

        public static SelenideElement getCvc() {
                return cvc;
        }

        public static void clickButtonCont() {
                buttonCont.click();
        }
}
