package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ModalCerrarSesionUI {

    public static final Target CANCELAR = Target.the("boton cancelar cerrar sesion")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));

    public static final Target SI_CERRAR_SESION = Target.the("boton Si cerrar sesion")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SÍ, CERRAR SESIÓN']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Si, cerrar sesión']"));

}
