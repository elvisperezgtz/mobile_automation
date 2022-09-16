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
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='ONBOARDING_COLUMN_BUTTONS']/android.view.View[1]/android.widget.Button"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Empezar mi registro   ']"));

    public static final Target YA_TENGO_CUENTA = Target.the("boton Ya tengo cuenta")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='ONBOARDING_BUTTON_LOGIN']"))
            .locatedForIOS(By.xpath(""));


}
