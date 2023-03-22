package femsa.utils;

import static femsa.utils.GetProperty.fromPropertyFile;

public class Validate {
    private Validate() {
    }

    public static Boolean isIOS() {
        return fromPropertyFile("serenity.properties", "appium.platformName").equalsIgnoreCase("ios");
    }

    public static Boolean isAndroid() {
        return fromPropertyFile("serenity.properties", "appium.platformName").equalsIgnoreCase("android");
    }

}
