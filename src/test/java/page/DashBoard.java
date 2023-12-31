package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import data.StringGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DashBoard {


        private SelenideElement buttonCredit = $x("//*[contains(text(), 'Купить в кредит')]");
        private SelenideElement buttonPayment = $x("//*[contains(text(), 'Купить')]");
        private SelenideElement cardInfo = $$(".input__control").get(0);
        private SelenideElement month = $$(".input__control").get(1);
        private SelenideElement year = $$(".input__control").get(2);

        private SelenideElement name = $$(".input__control").get(3);
        private SelenideElement cvc = $$(".input__control").get(4);
        private SelenideElement buttonCont = $$("button").find(exactText("Продолжить"));
        private SelenideElement errorMessage = $(byText("Ошибка"));
        private SelenideElement successMessage = $(byText("Успешно"));
        private SelenideElement wrongFormatMessage = $(byText("Неверный формат"));
        private SelenideElement mustBeFilledMessage = $(byText("Поле обязательно для заполнения"));
        private SelenideElement invalidCardExpirationDate = $(byText("Неверно указан срок действия карты"));

        public void findErrorMessage(String expectedText) {
                errorMessage.shouldHave(partialText(expectedText)).shouldBe(visible);
        }

        public void findSuccessMessage(String expectedText) {
                successMessage.shouldHave(partialText(expectedText)).shouldBe(visible);
        }

        public void findWrongFormatMessage(String expectedText) {
                wrongFormatMessage.shouldHave(partialText(expectedText)).shouldBe(visible);
        }

        public void findMustBeFilledMessage(String expectedText) {
                mustBeFilledMessage.shouldHave(partialText(expectedText)).shouldBe(visible);
        }

        public void findInvalidCardExpirationDate(String expectedText) {
                invalidCardExpirationDate.shouldHave(partialText(expectedText)).shouldBe(visible);
        }


        public void clickButtonPayment() {
                buttonPayment.click();
        }

        public void clickCreditButton() {
                buttonCredit.click();
        }

        public void setApprovedCardInfo() {

                cardInfo.setValue(DataHelper.getApprovedCardInfo());
        }
        public void setDeclinedCardInfo() {

                cardInfo.setValue(DataHelper.getDeclinedCardInfo());
        }
        public void setUnknownCardInfo() {

                cardInfo.setValue(DataHelper.getUnknownCardInfo());
        }
        public void setStringCard() {

                cardInfo.setValue(StringGenerator.stringCard());
        }

        public void setRandomMonth() {

                month.setValue(DataHelper.generateRandomMonth());
        }
        public void setCurrentMonth() {

                month.setValue(DataHelper.currentMonth());
        }

        public void setYear() {

                year.setValue(DataHelper.getLastTwoDigitsOfYear());
        }
        public void setNextYear() {

                year.setValue(DataHelper.getNextYear());
        }
        public void limitYear() {

                year.setValue(DataHelper.limitYear());
        }

        public void setName() {
                name.setValue(DataHelper.generateRandomName());

        }
        public void setNameLongText() {
                name.setValue(DataHelper.text());

        }

        public void setCvc() {
                cvc.setValue(DataHelper.generateCvcCode());
        }

        public void clickButtonCont() {
                buttonCont.click();
        }
        public  void fillInput(SelenideElement element, String value) {
                element.val(value);
        }

        public void stringMonth(String value) {
                fillInput(month, value);
        }
        public void stringYear(String value) {
                fillInput(year, value);
        }
        public void stringCvc(String value) {
                fillInput(cvc, value);
        }
        public void scriptCard(String value) {
                fillInput(cardInfo, value);
        }
        public void stringName(String value) {
                fillInput(name, value);
        }
}

