package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosNegocioUI {

    public static final Target NOMBRE_NEGOCIO = Target.the("campo Nombre negocio")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='EDIT_CONSTRAINT_CONTENT']/android.widget.ScrollView/android.widget.EditText[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target ACTIVIDAD_DE_TU_NEGOCIO= Target.the("campo Actividad de tu negocio")
            .locatedForAndroid(By.xpath("(//android.view.View[@content-desc='REGISTERDATA_DROPDOWNMENU_BUSINESS'])[1]/android.widget.EditText/android.view.View[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CODIGO_POSTAL= Target.the("campo codigo postal")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc='EDIT_CONSTRAINT_CONTENT']/android.widget.ScrollView/android.widget.EditText[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target EDITAR= Target.the("boton Editar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Editar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CANCELAR= Target.the("boton Editar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cancelar']"))
            .locatedForIOS(By.xpath(""));

    public static final Target GUARDAR= Target.the("boton Editar")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Guardar']"))
            .locatedForIOS(By.xpath(""));

}