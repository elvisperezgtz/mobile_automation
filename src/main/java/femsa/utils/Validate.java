package femsa.utils;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

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

    public static boolean isKeyboardShown (WebDriver facade){
       WebDriver driver= ((WebDriverFacade) facade).getProxiedDriver();
        return ((IOSDriver)driver).isKeyboardShown();
    }
}
