package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditBankAccountUI {
    public static final Target ACCOUNT_HOLDER = Target.the("Holer name")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CLABE = Target.the("Clabe")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTINUAR = Target.the("boton Continuar")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target HACERLO_MAS_TARDE = Target.the("boton Hacerlo mas tarde")
            .locatedForAndroid(By.xpath("(//android.widget.Button)[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target MENSAJE = Target.the("mensaje de confirmacion de vinculacion de la cuenta Clabe")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'CLABE')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CANCELAR = Target.the("boton Cancelar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Cancelar')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ACEPTAR = Target.the("boton Aceptar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Aceptar')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target TITULO = Target.the("titulo Ya casi terminas")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Ya casi')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ALERTA_LONGITUD = Target.the("alerta La CLABE debe tener 18 dígitos")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"EDIT_CONSTRAINT_CONTENT\"]/android.widget.ScrollView/android.widget.TextView[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ACTUALIZACION_EXITOSA= Target.the("Actualizaste tus datos")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Actualizaste tus datos']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONFIRMAR = Target.the("boton Confirmar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'CONFIRMAR')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target BOTON_CANCELAR = Target.the("boton cancelar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'CANCELAR')]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CLABE_MUST_HAVE_18_DIGITS =Target.the("The CLABE must have 18 digits")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text,'La Clabe debe tener 18 dígitos']"))
            .locatedForIOS(By.xpath(""));
}
