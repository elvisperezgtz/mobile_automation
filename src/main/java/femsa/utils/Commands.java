package femsa.utils;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public class Commands {
    public static void execute(String commando) {
        String os= System.getProperty("os.name").toLowerCase();
        if (os.equals("mac os x")){
            try {
                Runtime.getRuntime().exec(new String[]{"bash", "-l", "-c",commando});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec(commando);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
