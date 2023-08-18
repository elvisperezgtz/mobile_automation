package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;

public class CommonsUI {
    private CommonsUI() {
    }

    public static final Target SMS = Target.the("Notificacion SMS")
            .locatedForAndroid(id("android:id/message_text"))
            .locatedForIOS(xpath("//*[contains(@label,'Your verification code is')]"));

    public static final Target SUGERENCIA_KEYBOARD = Target.the("Sugerencia desde el keyboard")
            .locatedForAndroid(id("android:id/message_text"))
            .locatedForIOS(xpath("//XCUIElementTypeOther[@name='sugerencia']"));

    public static final Target NOTIFICACION_IOS = Target.the("notificacion SMS iOS")
            .locatedForAndroid(id(""))
            .locatedForIOS(xpath("//XCUIElementTypeOther[@name='NotificationShortLookView']"));

    public static final Target HIDE_KEYBOARD = Target.the("notificacion SMS iOS")
            .locatedForAndroid(id(""))
            .locatedForIOS(xpath("//XCUIElementTypeButton[@name='btn keyboard ocultar']"));

    public static final Target OK_BLUETOOTH = Target.the("boton ok del modal acceder a bluetooth")
            .locatedForAndroid(id(""))
            .locatedForIOS(xpath("//XCUIElementTypeButton[@name='OK']"));

    public static final Target EDITAR = Target.the("boton Editar")
            .locatedForAndroid(xpath("//android.widget.TextView[@text='Editar']"))
            .locatedForIOS(xpath("//XCUIElementTypeButton[@name='OK']"));

    public static final Target THIS_FIELD_IS_REQUIRED = Target.the("Alert: this field is required")
            .locatedForAndroid(xpath("//android.widget.TextView[@text='Este campo es obligatorio']"))
            .locatedForIOS(xpath("//XCUIElementTypeStaticText[@name=\"Este campo es obligatorio\"]"));

    public static final Target EDIT = Target.the("edit ")
            .locatedForAndroid(xpath("//android.view.View[@content-desc='BUTTON_EDIT']"))
            .locatedForIOS(xpath("//XCUIElementTypeButton[@name=\"PROFILE_PERSONALDATA_CONTINUE_BTN\"]"));

    public static final Target CANCEL = Target.the("Cancel button")
            .locatedForAndroid(xpath("//android.widget.TextView[@text='Cancelar' or @text='CANCELAR']"))
            .locatedForIOS(name("PROFILE_PERSONALDATA_CANCEL_BTN"));

    public static final Target BACK = Target.the("Back button")
            .locatedForAndroid(xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(xpath("//XCUIElementTypeButton[@name=\"backWhite\"]"));

    public static final Target SAVE = Target.the("Save button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"BUTTON_SAVE\"]"))
            .locatedForIOS(By.name("PROFILE_PERSONALDATA_SAVE_BTN"));

    public static final Target CONTINUE = Target.the("Confirm save button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CONTINUAR' or @text='GUARDAR CAMBIOS' or @text='CONFIRMAR']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"GUARDAR CAMBIOS\" or @label='CONFIRMAR']"));

}
