package femsa.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PhoneNumberGenerator {


    public static long generateNumbers(String filePath) throws IOException {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            long lastPhoneNumber;
            if (!lines.isEmpty()) {
                lastPhoneNumber = Long.parseLong(lines.get(lines.size() - 1));
            } else {
                lastPhoneNumber = 3000000000L;
                Files.writeString(path, lastPhoneNumber + "\n");
            }
            long newNumber = lastPhoneNumber + 1;
            Files.writeString(path, newNumber + "\n", StandardOpenOption.APPEND);
            return newNumber;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Last phone number  ====== " + getLastPhoneNumber("src/test/resources/data/phone_numbers/luis_phone_numbers.txt"));
        long generateNewNumber = generateNumbers("src/test/resources/data/phone_numbers/luis_phone_numbers.txt");

        System.out.println("New number generate and stored in the phone numbers onboading file " + generateNewNumber);
    }

    public static String getLastPhoneNumber(String filePath) throws RuntimeException {
        long lastPhoneNumber = 0;
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            if (!lines.isEmpty()) {
                lastPhoneNumber = Long.parseLong(lines.get(lines.size() - 1));
            }
            return String.valueOf(lastPhoneNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
