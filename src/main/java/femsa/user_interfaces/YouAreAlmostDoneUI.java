package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class YouAreAlmostDoneUI {
    public static final Target TITLE = Target.the("Title of the You are almost done screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target GOT_IT = Target.the("Got it button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"CONGRATULATIONS_COLUMN_CONTAINER\"]/android.view.View/android.widget.TextView"))
            .locatedForIOS(By.xpath(""));
}
