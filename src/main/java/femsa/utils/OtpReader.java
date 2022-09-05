package femsa.utils;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OtpReader {

    public static String getOtpFromNotification(WebDriver webDriver) throws IOException {

        WebDriver driver = ((WebDriverFacade) webDriver).getProxiedDriver();
        ((AndroidDriver) driver).openNotifications();
        final Target otpElement = Target.the("Notificacion SMS")
                .locatedForAndroid(By.id("android:id/message_text"))
                .locatedForIOS(By.xpath(""));

        WaitUntil.the(otpElement, WebElementStateMatchers.isPresent()).forNoMoreThan(Duration.ofSeconds(90));
        String otpMessage = otpElement.resolveFor(theActorInTheSpotlight()).getText();
        String otp = StringUtils.substringBetween(otpMessage, "es", ".");
        String cmd = "adb shell input keyevent 4";
        Runtime.getRuntime().exec(cmd);
        return otp;
    }
}
