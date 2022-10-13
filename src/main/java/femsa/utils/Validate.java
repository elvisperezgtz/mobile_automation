package femsa.utils;

import static femsa.utils.GetProperty.fromPropertyFile;

public class Validate {
    public static Boolean isIOS() {

        return fromPropertyFile("serenity.properties", "appium.platformName").toLowerCase().equals("ios");
    }

    public static Boolean isAndroid() {
        return fromPropertyFile("serenity.properties", "appium.platformName").toLowerCase().equals("android");

    }

}
