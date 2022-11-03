package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdministracionPerilUI {

    public static final Target CLABE = Target.the("boton Clabe")
            .locatedForAndroid(By.xpath("(//android.widget.TextView[@content-desc='TEXT_TITLE'])[2]"))
            .locatedForIOS(By.xpath(""));





}
