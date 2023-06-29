package femsa.user_interfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    private LoginUI() {
    }

    public static final Target EMAIL_OR_PHONE_NUMBER = Target.the("Email or phone number field")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeTextField)[1]"));

    public static final Target PASSWORD = Target.the("password field")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath("////XCUIElementTypeSecureTextField"));

    public static final Target LOGIN = Target.the("login button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='BUTTON_CONCEPT']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"Ingresar\"]"));

    public static final Target LOGGING_IN = Target.the("logging in message")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_MESSAGE_VALIDATION']/android.widget.TextView"))
            .locatedForIOS(By.xpath("//*[@label='Iniciando sesión']"));

    public static final Target ERROR_MESSAGE = Target.the("error message")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_MESSAGE_VALIDATION']/android.widget.TextView"))
            .locatedForIOS(By.xpath("//XCUIElementTypeApplication[@name=\"FEMSA B2B\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther"));

    public static final Target HELP = Target.the("help button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.name("helpIcon"));

    public static final Target HELP_TITLE = Target.the("help title")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Aviso de privacidad'])[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target FORGOT_PASSWORD = Target.the("forgot password button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Olvidé mi contraseña']"))
            .locatedForIOS(By.name("Olvidé mi contraseña"));

    public static final Target BACK = Target.the("back button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"single back purple\" or @name='backWhite']"));

    public static final Target ALERT = Target.the("alert message")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"PAYMENT_CONSTRAINT_CONTENT\"]/android.widget.ScrollView/android.widget.TextView[3]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@label='Este campo es obligatorio']"));

    public static final Target WRONG_DATA = Target.the("Wrong data")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Datos incorrectos']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"Datos incorrectos\"]"));

}
