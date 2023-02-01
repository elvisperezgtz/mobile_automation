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

    public static final Target HIDE_KEYBOARD = Target.the("notificacion SMS iOS")
            .locatedForAndroid(By.id(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='btn keyboard ocultar']"));

    public static final Target OK_BLUETOOTH = Target.the("boton ok del modal acceder a bluetooth")
            .locatedForAndroid(By.id(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='OK']"));

    public static final Target EDITAR = Target.the("boton Editar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Editar']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='OK']"));

}
