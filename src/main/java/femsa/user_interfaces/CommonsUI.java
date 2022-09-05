package femsa.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CommonsUI {
    public static final Target SMS = Target.the("Notificacion SMS")
            .locatedForAndroid(By.id("android:id/message_text"))
            .locatedForIOS(By.xpath(""));
}
