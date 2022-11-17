package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VinculacionExitosaUI {
    public static final Target FELICIDADES = Target.the("mensaje onboarding exitoso")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Felicidades')]"))
            .locatedForIOS(By.xpath(""));

public static final Target COMENZAR = Target.the("boton comenzar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'Comenzar')]"))
            .locatedForIOS(By.xpath(""));



}
