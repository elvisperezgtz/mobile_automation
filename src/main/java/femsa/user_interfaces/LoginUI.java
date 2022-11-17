package femsa.user_interfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    public static final Target EMAIL_O_NUMERO = Target.the("campo email o numero")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeTextField[@name='LOGIN_TEXTFIELD_EMAIL']"));

    public static final Target CONTRASENIA = Target.the("campo contrasenia")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeSecureTextField[@name='LOGIN_TEXTFIELD_PASSWORD']"));

    public static final Target INICIAR_SESION = Target.the("boton iniciar sesion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='BUTTON_CONCEPT']"))
            .locatedForIOS(By.xpath("///XCUIElementTypeButton[@name='LOGIN_BTN_SIGNIN']"));

    public static final Target INICIANDO_SESION = Target.the("mensaje iniciando sesion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_MESSAGE_VALIDATION']/android.widget.TextView"))
            .locatedForIOS(By.xpath("//XCUIElementTypeApplication[@name=\"FEMSA B2B\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther"));

    public static final Target MENSAJE_ERROR = Target.the("mensaje de error usuario no registrado")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_MESSAGE_VALIDATION']/android.widget.TextView"))
            .locatedForIOS(By.xpath("//XCUIElementTypeApplication[@name=\"FEMSA B2B\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther"));

    public static final Target AYUDA = Target.the("boton Ayuda de la pantalla login")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target TITULO_AYUDA = Target.the("titulo Ayuda de la pantalla login")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Aviso de privacidad'])[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target OLVIDE_MI_CONTRASENIA = Target.the("opcion olvide mi contrasenia")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Olvidé mi contraseña']"))
            .locatedForIOS(By.xpath(""));


}
