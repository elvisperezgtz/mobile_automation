package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditBusinessDataUI {

    public static final Target BUSINESS_NAME = Target.the("Business name field")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target BUSINESS_ACTIVITY = Target.the("Business activity")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target POSTAL_CODE = Target.the("postal code field")
            .locatedForAndroid(By.xpath("(//android.widget.EditText)[3]"))
            .locatedForIOS(By.xpath(""));

    public static final Target EDIT = Target.the("Edit button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Editar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CANCEL = Target.the("Cancel button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cancelar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target GUARDAR= Target.the("boton Guardar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Guardar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target TITLE = Target.the("title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Tu negocio']"))
            .locatedForIOS(By.xpath(""));
    public static final Target WRONG_POSTAL_CODE =  Target.the("Wrong postal code message")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Este código postal es incorrecto']"))
            .locatedForIOS(By.xpath(""));

    public static final Target BACK = Target.the("Back button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='ICONBUTTON_BACK']"))
            .locatedForIOS(By.xpath(""));
}
