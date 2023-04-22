package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResetPasswordUI {

    public static final Target RESET_PASSWORD_TITLE = Target.the("title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Restablece tu contraseña']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"FORGOTPASSWORD_TITLE_LABEL\"]"));

    public static final Target HELP = Target.the("help button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.xpath("//*[@name='helpIcon']"));

    public static final Target BACK = Target.the("back button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"single back purple\"]"));

    public static final Target PHONE_NUMBER = Target.the("phone number field")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"REGISTERPHONENUMBER_COLUMN_PHONENUMBER\"]/android.widget.EditText[2]/android.view.View[2]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeOther[@name=\"FORGOTPASSWORD_PHONE_TEXTFIELD\"]/XCUIElementTypeTextField"));

    public static final Target CONTINUE = Target.the("Continue button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"BUTTON_CONCEPT\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"FORGOTPASSWORD_SENDSMS_BTN\"]"));

}
