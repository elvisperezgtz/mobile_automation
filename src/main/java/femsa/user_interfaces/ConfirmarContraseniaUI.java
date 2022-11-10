package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmarContraseniaUI {
    public static final Target CONTRASENIA = Target.the("campo contrasenia")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONFIRMA_TU_CONTRASENIA = Target.the("titulo Confirma tu contrasenia")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Confirma tu contrase\u00f1a']"))
            .locatedForIOS(By.xpath("//android.widget.TextView[@text='Ingresar']"));


    public static final Target CANCELAR = Target.the("boton Cancelar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cancelar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTINUAR = Target.the("boton Continuar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Continuar']"))
            .locatedForIOS(By.xpath(""));

}
