package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateYourPasswordUI {

    public static final Target TITLE = Target.the("Title")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"CREATECODE_COLUMN\"]/android.widget.EditText"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeTextField)[1]"));

}
