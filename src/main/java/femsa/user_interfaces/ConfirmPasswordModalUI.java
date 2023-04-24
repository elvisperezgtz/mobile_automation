package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmPasswordModalUI {
    public static final Target PASSWORD = Target.the("password input")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeOther[@name=\"CONFIRMPSS_PSS_TEXTFIELD\"]/XCUIElementTypeSecureTextField"));

    public static final Target CONFIRMA_TU_CONTRASENIA = Target.the("titulo Confirma tu contrasenia")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Confirma tu contrase\u00f1a']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='CONFIRMPSS_TITLE_LABEL']"));


    public static final Target CANCELAR = Target.the("boton Cancelar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cancelar']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"CONFIRMPSS_CANCEL_BTN\"]"));

    public static final Target CONTINUE = Target.the("Continue button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Continuar']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"CONFIRMPSS_SAVE_BTN\"]"));

    public static final Target ERROR_MESSAGE = Target.the("wrong password error message")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Contraseña incorrecta']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"Contraseña incorrecta\"]"));

    public static final Target TITLE = Target.the("modal title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Confirma tu contraseña']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"CONFIRMPSS_TITLE_LABEL\"]"));

}
