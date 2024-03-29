package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EnterYourCodeUI {

    public static final Target WRITE_YOUR_CODE_TITLE = Target.the("Title: Write your code")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"CODEVERIFICATION_TITLE_LABEL\"]"));

    public static final Target SMS_CODE_BOXES = Target.the("SMS code boxes")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"SMSCODE_ROW_CONTAINER\"]/android.widget.EditText"))
            .locatedForIOS(By.xpath("//XCUIElementTypeTextField[@name=\"CODEVERIFICATION_ONE_TEXTFIELD\"]"));

    public static final Target THE_CODE_IS_INCORRECT = Target.the("The code is incorrect")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"SMSCODE_COLUMN_CONTAINER\"]/android.widget.TextView"))
            .locatedForIOS(By.xpath("//XCUIElementTypeTextField[@name=\"CODEVERIFICATION_ONE_TEXTFIELD\"]"));


}
