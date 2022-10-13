package femsa.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CommonsUI {
    public static final Target SMS = Target.the("Notificacion SMS")
            .locatedForAndroid(By.id("android:id/message_text"))
            .locatedForIOS(By.xpath("//*[contains(@label,'Your verification code is')]"));

    public static final Target SUGERENCIA_KEYBOARD = Target.the("Sugerencia desde el keyboard")
            .locatedForAndroid(By.id("android:id/message_text"))
            .locatedForIOS(By.xpath("//XCUIElementTypeOther[@name='sugerencia']"));

    public static final Target NOTIFICACION_IOS = Target.the("notificacion SMS iOS")
            .locatedForAndroid(By.id(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeOther[@name='NotificationShortLookView']"));

}
