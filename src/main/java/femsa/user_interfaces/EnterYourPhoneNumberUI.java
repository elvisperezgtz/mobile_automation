package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EnterYourPhoneNumberUI {

    public static final Target TITLE = Target.the("Enter your phone number title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target PHONE_NUMBER = Target.the("Phone number")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target TERMS_AND_CONDITION = Target.the("Terms conditions")
            .locatedForAndroid(By.xpath("//android.widget.CheckBox[@content-desc=\"REGISTERPHONENUMBER_CHECKBOX_TERMSANDCONDITIONS\"]"))
            .locatedForIOS(By.xpath(""));


    public static final Target CONTINUE = Target.the("Terms conditions")
            .locatedForAndroid(By.xpath("//android.widget.ScrollView[@content-desc=\"REGISTERPHONENUMBER_COLUMN\"]/android.view.View[5]/android.widget.Button"))
            .locatedForIOS(By.xpath(""));

    public static final Target THE_NUMBER_IS_INCORRECT = Target.the("The number is incorrect")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath(""));

    public static final Target THIS_NUMBER_CANNOT_BE_REGISTERED = Target.the("Message: This number cannot be registered")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"OUTLINE_TEXTFIELD\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target HELP = Target.the("Help button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target HELP_TITLE = Target.the("Help title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cómo usar mi dispositivo de cobro SPIRO']"))
            .locatedForIOS(By.xpath(""));
}
