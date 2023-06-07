package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ActivateBluetoothUI {

    public static final Target TITLE = Target.the("Activate bluetooth title")
            .locatedForAndroid(By.id("android:id/message"))
            .locatedForIOS(By.xpath(""));

    public static final Target REJECT = Target.the("Reject button")
            .locatedForAndroid(By.id("android:id/button2"))
            .locatedForIOS(By.xpath(""));

    public static final Target ALLOW = Target.the("Allow button")
            .locatedForAndroid(By.id("android:id/button1"))
            .locatedForIOS(By.xpath(""));

}
