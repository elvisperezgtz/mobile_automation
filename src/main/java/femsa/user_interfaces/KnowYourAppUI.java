package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class KnowYourAppUI {

    public static final Target KNOW_YOUR_APP_TITLE = Target.the("Title")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ONBOARDING_COLUMN_PAGES\"]/android.widget.TextView[1]"))
            .locatedForIOS(By.id(""));

    public static final Target DAILY_EARNINGS_TITLE = Target.the("Title for the card")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"ONBOARDING_TEXT_SUBTITLE\"]"))
            .locatedForIOS(By.id(""));

     public static final Target DAILY_EARNINGS_SUBTITLE = Target.the("Subtitle for the card")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"ONBOARDING_TEXT_SUBTITLE\"]"))
            .locatedForIOS(By.id(""));

     public static final Target CONTINUE_BUTTON = Target.the("Button Continue")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Continuar']"))
            .locatedForIOS(By.id(""));

}
