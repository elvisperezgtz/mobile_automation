package femsa.user_interfaces.wallet;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IntroTutorialUI {
    public static final Target CONTINUE = Target.the("Continue intro")
            .locatedForAndroid(By.name(""))
            .locatedForIOS(By.name(""));

    public static final Target START = Target.the("Start intro")
            .locatedForAndroid(By.name(""))
            .locatedForIOS(By.name(""));


}
