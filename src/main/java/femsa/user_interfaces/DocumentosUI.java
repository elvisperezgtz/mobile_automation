package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DocumentosUI {
    public static final Target AVISO_PRIVACIDAD = Target.the("opcion Aviso de privacidad")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Aviso de privacidad']"))
            .locatedForIOS(By.xpath(""));

    public static final Target TERMINOS_CONDICIONES = Target.the("opcion Terminos y condiciones")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'rminos y condiciones')]"))
            .locatedForIOS(By.xpath(""));

 public static final Target TITULO_TERMINOS_CONDICIONES = Target.the("titulo del documento Terminos y condiciones")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Terminos y condiciones'])[2]"))
            .locatedForIOS(By.xpath(""));

 public static final Target TITULO_AVISO_PRIVACIDAD = Target.the("titulo del documento Aviso de privacidad")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@text='Aviso de privacidad'])[2]"))
            .locatedForIOS(By.xpath(""));

}
