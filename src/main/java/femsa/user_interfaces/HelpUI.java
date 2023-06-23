package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HelpUI {
    public static final Target HELP_TITLE = Target.the("Help title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cómo usar mi dispositivo de cobro SPIRO']"))
            .locatedForIOS(By.id(""));

    public static final Target CLOSE = Target.the("Close button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(By.id(""));
}
