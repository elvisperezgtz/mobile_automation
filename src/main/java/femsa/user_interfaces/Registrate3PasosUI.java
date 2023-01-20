package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Registrate3PasosUI {
    public static final Target EMPEZAR_REGISTRO = Target.the("boton Empezar mi registro")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Empezar mi registro']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Empezar mi registro   ']"));

    public static final Target YA_TENGO_CUENTA = Target.the("boton Ya tengo cuenta")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text = 'Ya tengo cuenta']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@label='Ya tengo cuenta']"));

    public static final Target TITULO = Target.the("titulo Registrate en 3 pasos")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"ONBOARDING_TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@label='Ya tengo cuenta']"));
}
