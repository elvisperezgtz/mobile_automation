package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PerfilUI {
    public static final Target LOGO_ANDROID =  Target.the("Logo android")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='{0}']"))
            .locatedForIOS(By.xpath(""));

    public static final Target LOGO_IOS =  Target.the("Logo ios")
            .locatedBy("");

}
