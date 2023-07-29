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


    public static String getLastTwoDigitsOfYear() {

        var currentYear = Year.now().getValue();

        var lastTwoDigitsOfYear = currentYear % 100;


        return String.valueOf(lastTwoDigitsOfYear);
    }
    public static String getNextYear() {

        var currentYear = Year.now().getValue();

        var lastTwoDigitsOfYear = currentYear % 100+1;


        return String.valueOf(lastTwoDigitsOfYear);
    }
    public static String limitYear() {

        var currentYear = Year.now().getValue();

        var lastTwoDigitsOfYear = currentYear % 100+6;


        return String.valueOf(lastTwoDigitsOfYear);
    }


    public static String  getApprovedCardInfo() {
        return ("4444 4444 4444 4441");
    }

    public static String  getDeclinedCardInfo() {
        return ("4444 4444 4444 4442");
    }

    public static String  getUnknownCardInfo() {
        return ("1111 1111 1111 1111");
    }



    private static Faker faker = new Faker(new Locale("en"));

    public static String generateRandomName() {
        return faker.name().fullName();
    }


    public static String generateCvcCode() {
        return faker.number().digits(3);
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




