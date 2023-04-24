package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OnBoardingUI {
    public static final Target CONTINUE = Target.the("continue button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='ONBOARDING_COLUMN_BUTTONS']/android.view.View/android.widget.Button"))
            .locatedForIOS(By.xpath(""));

    public static final Target TITLE = Target.the(" home screen title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc='ONBOARDING_TEXT_TITLE']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"TUTORIALCELL_TEXT_LABEL\"]"));

}
