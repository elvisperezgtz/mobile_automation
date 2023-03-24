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

    public static final Target EMAIL = Target.the("campo email")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[3]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeTextField[@name=\"PERSONALDATA_EMAIL_TEXTFIELD\"]"));

    public static final Target EDITAR = Target.the("boton editar")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='BUTTON_EDIT']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"PROFILE_PERSONALDATA_BTN_SAVE\"]"));

    public static final Target GUARDAR_CAMBIOS = Target.the("boton guardar cambios")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='GUARDAR CAMBIOS']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"Guardar\"]"));

    public static final Target CANCELAR = Target.the("boton cancelar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTINUAR = Target.the("boton CONTINUAR")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CONTINUAR']"))
            .locatedForIOS(By.xpath(""));

    public static final Target LOGO = Target.the("logo")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='EDIT_CONSTRAINT_CONTENT']/android.widget.ScrollView/android.widget.TextView"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"PROFILE_PERSONALDATA_TITLE_LABEL\"]"));

    public static final Target MENSAJE_CAMPO_OBLIGATORIO = Target.the("alerta Campo obligatorio")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Este campo es obligatorio']"))
            .locatedForIOS(By.xpath(""));

    public static final Target MENSAJE_FORMATO_INCORRECTO = Target.the("alerta Formato de email incorrecto")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Formato de email incorrecto']"))
            .locatedForIOS(By.xpath(""));
  public static final Target ATRAS = Target.the("boton atras")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(By.xpath(""));

}
