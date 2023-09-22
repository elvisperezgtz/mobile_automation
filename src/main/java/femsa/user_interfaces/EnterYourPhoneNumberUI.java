package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EnterYourPhoneNumberUI {

    public static final Target TITLE = Target.the("Enter your phone number title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"REGISTER_TITLE_LABEL\"]"));

    public static final Target PHONE_NUMBER = Target.the("Phone number")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeOther[@name=\"REGISTER_PHONE_TEXTFIELD\"]/XCUIElementTypeTextField"));

    public static final Target TERMS_AND_CONDITION = Target.the("Terms conditions")
            .locatedForAndroid(By.xpath("//android.widget.CheckBox[@content-desc=\"REGISTERPHONENUMBER_CHECKBOX_TERMSANDCONDITIONS\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeScrollView[@name=\"REGISTER_SCROLLVIEW\"]/XCUIElementTypeOther/XCUIElementTypeButton[1]"));

    public static final Target SEND_CODE = Target.the("Send code button")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"REGISTERPHONENUMBER_COLUMN\"]/android.view.View[5]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"REGISTER_SENDSMS_BTN\"]"));

    public static final Target THE_NUMBER_IS_INCORRECT = Target.the("The number is incorrect")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath(""));

    public static final Target THIS_NUMBER_CANNOT_BE_REGISTERED = Target.the("Message: This number cannot be registered")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"OUTLINE_TEXTFIELD\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"No se puede registrar este número\"]"));

    public static final Target HELP = Target.the("Help button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"helpIcon\"]"));

    public static final Target HELP_TITLE = Target.the("Help title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cómo usar mi dispositivo de cobro SPIRO']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"helpIcon\"]"));

    public static final Target BACK = Target.the("Back button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"backWhite\"]"));

}
