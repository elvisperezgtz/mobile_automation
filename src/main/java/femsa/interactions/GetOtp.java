package femsa.interactions;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static femsa.user_interfaces.CommonsUI.SMS;

public class GetOtp implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = ((WebDriverFacade) BrowseTheWeb.as(actor).getDriver()).getProxiedDriver();
        ((AndroidDriver) driver).openNotifications();



        actor.attemptsTo(WaitUntil.the(SMS, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(90)));

        String otpMessage = SMS.resolveFor(theActorInTheSpotlight()).getText();
        System.out.println(otpMessage);
        String[] code;
        code = otpMessage.split(" es ");
        code = (code[code.length - 1].replace(".", "").split(" "));
        String otp = code[0];
        String cmd = "adb shell input keyevent 4";
        actor.attemptsTo(Ejecutar.elComandoAdb(cmd));

        actor.remember("otp", otp);
    }

    public static GetOtp fromSMS() {
        return Tasks.instrumented(GetOtp.class);
    }
}
