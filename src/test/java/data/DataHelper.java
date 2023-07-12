package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }


    public static int getLastTwoDigitsOfYear() {

        int currentYear = Year.now().getValue();

        // Извлекаем последние две цифры
        int lastTwoDigitsOfYear = currentYear % 100;


        return lastTwoDigitsOfYear;
    }

    @Value
    public static class CardInfo {
        String cardNumber;

    }

    public static CardInfo getApprovedCardInfo() {
        return new CardInfo("4444 4444 4444 4441");
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo("4444 4444 4444 4442");
    }

    public static CardInfo getUnknownCardInfo() {
        return new CardInfo("1111 1111 1111 1111");
    }


    private static Faker faker = new Faker(new Locale("en"));

    public static String generateRandomName() {
        return faker.name().fullName();
    }

    @Value
    public static class CvcCode {
        String code;
    }

    public static String generateCvcCode() {

        String randomNumber = faker.number().digits(3);


        return randomNumber;
    }

    public static String generateRandomMonth() {

        int randomMonth = faker.number().numberBetween(1, 13);
        String formattedMonth = String.format("%02d", randomMonth);


        return formattedMonth;
    }

    public static String text() {
        Faker faker = new Faker();

        String text = faker.lorem().characters(1000);
        return text;
    }

    public static String currentMonth() {

        LocalDate currentDate = LocalDate.now();
        String month = currentDate.format(DateTimeFormatter.ofPattern("MM"));

        return month;
    }

}




