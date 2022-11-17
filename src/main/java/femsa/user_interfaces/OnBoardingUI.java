package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OnBoardingUI {
    public static final Target CONTINUAR = Target.the("boton continuar")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='ONBOARDING_COLUMN_BUTTONS']/android.view.View/android.widget.Button"))
            .locatedForIOS(By.xpath(""));

    public static final Target TITULO = Target.the("titulo pantalla inicio")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc='ONBOARDING_TEXT_TITLE']"))
            .locatedForIOS(By.xpath(""));

    public static final Target EMPEZAR_REGISTRO = Target.the("boton Empezar mi registro")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Empezar mi registro']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Empezar mi registro   ']"));

    public static final Target YA_TENGO_CUENTA = Target.the("boton Ya tengo cuenta")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text = 'Ya tengo cuenta']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@label='Ya tengo cuenta']"));


}