package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateYourPasswordUI {

    public static final Target TITLE = Target.the("Title of the screen to create your password")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeTextField)[1]"));
    public static final Target HELP_ICON = Target.the("Help icon on the screen to create your password")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.xpath(""));
    public static final Target PASSWORD_TEXTBOX = Target.the("Text box to enter password")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"CREATECODE_COLUMN\"]/android.widget.EditText"))
            .locatedForIOS(By.xpath(""));
    public static final Target PASSWORD_DISPLAY_BUTTON = Target.the( "Button to show or hide the password in the edit text field")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"CREATECODE_COLUMN\"]/android.widget.EditText/android.view.View[2]/android.widget.CheckBox"))
            .locatedForIOS(By.xpath(""));
    public static final Target CONTINUE_BUTTON = Target.the("Continue button on the screen create your password")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"CREATECODE_COLUMN\"]/android.view.View[2]/android.widget.Button"))
            .locatedForIOS(By.xpath(""));

}
