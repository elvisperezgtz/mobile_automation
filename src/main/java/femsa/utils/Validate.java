package femsa.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;

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

    public static boolean isKeyboardShown() {
        boolean isShow;
        if (Boolean.TRUE.equals(isAndroid())) {
            isShow = GetProxiesDriver.forAndroid().isKeyboardShown();
        } else {
            isShow = GetProxiesDriver.forIos().isKeyboardShown();
        }
        return isShow;
    }

}
