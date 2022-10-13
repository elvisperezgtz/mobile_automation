package femsa.user_interfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    public static final Target EMAIL_O_NUMERO = Target.the("campo email o numero")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTRASENIA = Target.the("campo contrasenia")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target INICIAR_SESION = Target.the("boton iniciar sesion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='BUTTON_CONCEPT']"))
            .locatedForIOS(By.xpath(""));

    public static final Target INICIANDO_SESION = Target.the("mensaje iniciando sesion")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='SMSCODE_MESSAGE_VALIDATION']/android.widget.TextView"))
            .locatedForIOS(By.xpath(""));


}
