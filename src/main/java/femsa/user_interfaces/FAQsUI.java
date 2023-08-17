package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FAQsUI {
    public static final Target TITLE = Target.the("Title of the FAQS screen")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath(""));
    public static final Target BUTTON_CLOSE = Target.the("Close button inside the FAQS screen")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(By.xpath(""));
}
