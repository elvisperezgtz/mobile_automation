package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI {

    public static final Target COBRAR = Target.the("boton Cobrar- Home")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Cobrar']"));

    public static final Target INICIO = Target.the("boton Inicio- Home")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Inicio']"));

    public static final Target MOVIMIENTOS_HOY = Target.the("texto Movimientos hoy")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Movimientos hoy']"));

    public static final Target PERFIL = Target.the("administracion de perfil")
            .locatedForAndroid(By.xpath("(//android.view.View[@content-desc='title'])[3]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Perfil']"));



}
