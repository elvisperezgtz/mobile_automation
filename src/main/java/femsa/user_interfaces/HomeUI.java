package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI {

    public static final Target COBRAR = Target.the("boton Cobrar- Home")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Cobrar']"));

    public static final Target HOME = Target.the("Home")
            .locatedForAndroid(By.xpath("(//android.view.View[@content-desc=\"title\"])[1]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Inicio']"));

    public static final Target MOVIMIENTOS_HOY = Target.the("texto Movimientos hoy")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='Movimientos hoy']"));

    public static final Target PROFILE = Target.the("Profile")
            .locatedForAndroid(By.xpath("(//android.view.View[@content-desc='title'])[3]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Perfil']"));

    public static final Target BUSINESS_NAME =  Target.the("nombre del negocio")
            .locatedForAndroid(By.xpath("(//android.widget.TextView)[15]"))
            .locatedForIOS(By.xpath(""));
}
