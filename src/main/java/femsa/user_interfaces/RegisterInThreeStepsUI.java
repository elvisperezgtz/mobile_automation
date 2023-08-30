package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterInThreeStepsUI {
    public static final Target BEGIN_REGISTRATION = Target.the("begin registration button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Empezar mi registro']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"TUTORIAL_REGISTER_BTN\"]"));

    public static final Target ALREADY_HAVE_ACCOUNT = Target.the("I already have an account button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text = 'Ya tengo cuenta']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@label='Ya tengo cuenta']"));

    public static final Target TITLE = Target.the("title register in three steps")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"ONBOARDING_TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@label='Ya tengo cuenta']"));
}
