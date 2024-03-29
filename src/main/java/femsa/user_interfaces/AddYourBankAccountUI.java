package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddYourBankAccountUI {

    private AddYourBankAccountUI() {
    }

    public static final Target TITLE = Target.the("Title of the Add your bank account screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"BANKING_TITLE_LABEL\"]"));

    public static final Target FULL_NAME_OF_THE_HOLDER = Target.the("Full name of the holder field")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeOther[@name=\"BANKING_NAME_TEXTFIELD\"]/XCUIElementTypeTextField"));

    public static final Target CLABE = Target.the("Interbank CLABE field")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeOther[@name=\"BANKING_CLABE_TEXTFIELD\"]/XCUIElementTypeTextField"));

    public static final Target CONTINUE = Target.the("Continue button")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[1]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"BANKING_CONTINUE_BTN\"]"));

    public static final Target DO_IT_LATER = Target.the("Do it later button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Hacerlo más tarde']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"BANKING_DOITLATER_BTN\"]"));

    public static final Target HELP = Target.the("Help button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"helpIcon\"]"));

    public static final Target CONFIRM_CONTINUE = Target.the("Confirm continue button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CONTINUAR']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"Continuar\"]"));

    public static final Target NO_INTERNET_CONNECTION = Target.the("Message No internet connection")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"DONGLE_MESSAGE_VALIDATION\"]/android.widget.TextView"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"No tienes conexión a internet\"]"));

}
