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

}
