package femsa.utils;

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

}