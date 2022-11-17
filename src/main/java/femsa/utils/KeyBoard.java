package femsa.utils;

public class KeyBoard {
    public static String getKeyEventCode(char number) {
        String code = null;
        switch (number) {
            case '0':
                code = "KEYCODE_0";
                break;
            case '1':
                code = "KEYCODE_1";
                break;
            case '2':
                code = "KEYCODE_2";
                break;
            case '3':
                code = "KEYCODE_3";
                break;
            case '4':
                code = "KEYCODE_4";
                break;
            case '5':
                code = "KEYCODE_5";
                break;
            case '6':
                code = "KEYCODE_6";
                break;
            case '7':
                code = "KEYCODE_7";
                break;
            case '8':
                code = "KEYCODE_8";
                break;
            case '9':
                code = "KEYCODE_9";
                break;
            default:
                break;
        }
        return code;
    }
}
