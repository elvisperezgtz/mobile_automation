package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditPersonalInformationUI {
    public static final Target FIRST_NAME = Target.the("first name")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeTextField[@name=\"PROFILE_PERSONALDATA_NAME_TEXTFIELD\"]"));

    public static final Target LAST_NAME = Target.the("last name")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeTextField[@name=\"PERSONALDATA_LAST_NAME_TEXTFIELD\"]"));

    public static final Target EMAIL = Target.the("email field")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[3]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeTextField[@name=\"PERSONALDATA_EMAIL_TEXTFIELD\"]"));

    public static final Target EDIT = Target.the("edit ")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='BUTTON_EDIT']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"PROFILE_PERSONALDATA_BTN_SAVE\"]"));

    public static final Target GUARDAR_CAMBIOS = Target.the("boton guardar cambios")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='GUARDAR CAMBIOS']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"Guardar\"]"));

    public static final Target CANCEL = Target.the("Cancel button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cancelar' or @text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTINUAR = Target.the("boton CONTINUAR")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CONTINUAR']"))
            .locatedForIOS(By.xpath(""));

    public static final Target LOGO = Target.the("logo")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"EDIT_CONSTRAINT_CONTENT\"]/android.view.View/android.widget.ScrollView/android.widget.TextView"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"PROFILE_PERSONALDATA_TITLE_LABEL\"]"));

    public static final Target MENSAJE_CAMPO_OBLIGATORIO = Target.the("alerta Campo obligatorio")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Este campo es obligatorio']"))
            .locatedForIOS(By.xpath(""));

    public static final Target INVALID_EMAIL_FORMAT = Target.the("alerta Formato de email incorrecto")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Formato de email incorrecto']"))
            .locatedForIOS(By.xpath(""));
    public static final Target BACK = Target.the("Back button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target SAVE = Target.the("Save button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Guardar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target THIS_EMAIL_ALREADY_HAS_AN_ACCOUNT = Target.the("Message This email already has an account")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Este email ya tiene una cuenta']"))
            .locatedForIOS(By.xpath(""));

    public static final Target YOU_HAVE_UPDATED_YOUR_DATA = Target.the("Message You have updated your data")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Actualizaste tus datos']"))
            .locatedForIOS(By.xpath(""));
}
