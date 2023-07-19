package femsa.utils;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class StringGenerator {

    private StringGenerator(){

    }
    public static String generateRandomString(int length, boolean specialChars, boolean numbers) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (specialChars) {
            allowedChars += "!@#$%^&*()_+-=[]{};:,.<>/?";
        }
        if (numbers) {
            allowedChars += "0123456789";
        }
        String randomString = "";
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * allowedChars.length());
            randomString += allowedChars.charAt(randomIndex);
        }
        return randomString;
    }

    public static String withOnlyRandomNumbers(int length) {
        String allowedChars = "0123456789";

        String randomString = "";
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * allowedChars.length());
            randomString += allowedChars.charAt(randomIndex);
        }
        return randomString;
    }
    public static String buildPassword(int lowercase, int capital, int numbers, int special) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbersChars = "0123456789";
        String specialChars = "!@#$%^&*()_+-=[]{};:,.<>/?";

        List<String> randomString = new ArrayList<>();
        for (int i = 0; i < lowercase; i++) {
            int randomIndex = (int) (Math.random() * lowercaseChars.length());
            randomString.add(String.valueOf(lowercaseChars.charAt(randomIndex)));
        }
        for (int i = 0; i < capital; i++) {
            int randomIndex = (int) (Math.random() * capitalChars.length());
            randomString.add(String.valueOf(capitalChars.charAt(randomIndex)));
        }
        for (int i = 0; i < numbers; i++) {
            int randomIndex = (int) (Math.random() * numbersChars.length());
            randomString.add(String.valueOf(numbersChars.charAt(randomIndex)));
        }
        for (int i = 0; i < special; i++) {
            int randomIndex = (int) (Math.random() * specialChars.length());
            randomString.add(String.valueOf(specialChars.charAt(randomIndex)));
        }
        Collections.shuffle(randomString);
        return Joiner.on("").join(randomString);
    }

}
