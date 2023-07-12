package data;

import java.security.SecureRandom;

public class StringGenerator {
    public static String stringCard() {

        String randomString = generateRandomString(16);
        return randomString;
    }

    public static String generateRandomString(int length) {

        char[] characters = {'!', '@', '#', '$', '%', '&', 'A', 'B', 'C', 'D', 'E', 'F'};


        SecureRandom random = new SecureRandom();


        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char randomChar = characters[randomIndex];
            stringBuilder.append(randomChar);
        }


        return stringBuilder.toString();
    }
}

