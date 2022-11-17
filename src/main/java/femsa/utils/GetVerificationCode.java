package femsa.utils;

public class GetVerificationCode {
    public static String fromSMS(String sms){
        String[] code;
        code = sms.split("is");
        code = (code[code.length - 1].replace(".", "").split(" "));
        return code[1];
    }
}
