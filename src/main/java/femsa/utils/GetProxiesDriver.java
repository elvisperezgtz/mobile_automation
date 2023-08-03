package femsa.utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import static net.serenitybdd.core.Serenity.getDriver;
public class GetProxiesDriver {
    private GetProxiesDriver() {
    }
    public static AndroidDriver forAndroid() {
        return (AndroidDriver)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }
    public static IOSDriver forIos() {
        return (IOSDriver)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }
}