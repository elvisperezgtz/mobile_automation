package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TurnOnYourDeviceUI {
    private TurnOnYourDeviceUI() {
    }

    public static final Target TITLE = Target.the("title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target START = Target.the("start button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Comenzar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target LINK_LATER = Target.the("Link later button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Vincular más tarde']"))
            .locatedForIOS(By.xpath(""));

    public static final Target HELP = Target.the("Help button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.xpath(""));

}
