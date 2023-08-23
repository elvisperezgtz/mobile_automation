package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class YouDoNotHaveInternetConnectionModalUI {
    public static final Target TITLE = Target.the("Title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='No tienes conexión a internet']"))
            .locatedForIOS(By.id(""));

    public static final Target TRY_AGAIN = Target.the("Try again button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Volver a intentar']"))
            .locatedForIOS(By.id(""));

    public static final Target DO_IT_LATER = Target.the("Do it later")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Hacerlo más tarde']"))
            .locatedForIOS(By.id(""));



}
