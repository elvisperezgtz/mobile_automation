package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GettingItIsEasyUI {
    public static final Target TITLE = Target.the("Title of the Getting it is easy screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target DO_IT_LATER = Target.the("Do it later button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Hacerlo más tarde']"))
            .locatedForIOS(By.xpath(""));

    public static final Target MORE_SOON = Target.the("More soon button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"DONGLE_BUTTON_GETIT_SHOP_ONLINE\"]"))
            .locatedForIOS(By.xpath(""));

}
