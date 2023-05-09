package femsa.utils;

import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public class Validate {
    private Validate() {
    }

    public static Boolean isIOS() {
        EnvironmentSpecificConfiguration currentEnvironment = OnStage.theActorInTheSpotlight().recall("env");
        return currentEnvironment.getProperty("appium.platformName").equalsIgnoreCase("ios");
    }

    public static Boolean isAndroid() {
        EnvironmentSpecificConfiguration currentEnvironment = OnStage.theActorInTheSpotlight().recall("env");
        return currentEnvironment.getProperty("appium.platformName").equalsIgnoreCase("android");
    }

    public static boolean isKeyboardShown(WebDriver facade) {
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        return ((IOSDriver) driver).isKeyboardShown();
    }

}
