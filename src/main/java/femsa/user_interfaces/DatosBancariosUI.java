package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosBancariosUI {
    public static final Target NOMBRE_TITULAR = Target.the("campo Nombre completo del titular")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CLABE = Target.the("campo Clabe")
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




}
