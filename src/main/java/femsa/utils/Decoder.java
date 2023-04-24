package femsa.utils;

import java.util.Base64;

public class Decoder {
    public static String decode(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input.getBytes());
        return new String(decodedBytes);
    }
}