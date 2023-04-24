package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SaveModalUI {
    private SaveModalUI() {
    }


    public static final Target GUARDAR = Target.the("boton Guardar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Guardar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CANCELAR = Target.the("boton Cancelar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));
}
