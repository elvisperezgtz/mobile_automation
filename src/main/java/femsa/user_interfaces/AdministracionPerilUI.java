package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdministracionPerilUI {

    public static final Target CLABE = Target.the("boton Clabe")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@content-desc='TEXT_TITLE'])[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target DOCUMENTOS_LEGALES = Target.the("boton Documentos Legales")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Documentos legales']"))
            .locatedForIOS(By.xpath(""));

    public static final Target CERRAR_SESION = Target.the("boton cerrar sesion")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Cerrar sesión']"))
            .locatedForIOS(By.xpath(""));

     public static final Target CANCELAR = Target.the("boton cancelar cerrar sesion")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));

     public static final Target SI_CERRAR_SESION = Target.the("boton Si cerrar sesion")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SÍ, CERRAR SESIÓN']"))
            .locatedForIOS(By.xpath(""));



}
