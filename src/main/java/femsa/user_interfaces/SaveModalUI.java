package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SaveModalUI {
    private SaveModalUI() {
    }

    public static final Target SAVE = Target.the("Save button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Guardar' or @text='GUARDAR']"))
            .locatedForIOS(By.xpath(""));
   public static final Target CONTINUE = Target.the("Continue button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CONTINUAR' or @text='GUARDAR CAMBIOS']"))
            .locatedForIOS(By.xpath(""));

    public static final Target GUARDAR = Target.the("boton Guardar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Guardar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CANCELAR = Target.the("boton Cancelar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));
}
