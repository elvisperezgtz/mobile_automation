package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogoutUI {

    public static final Target CANCEL = Target.the("Cancel")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='CANCELAR']"))
            .locatedForIOS(By.xpath(""));

    public static final Target YES_LOGOUT = Target.the("Yes, logout")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SÍ, CERRAR SESIÓN']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Si, cerrar sesión']"));

    public static final Target TITLE = Target.the("Title Do you want to logout?")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SÍ, CERRAR SESIÓN']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name='Si, cerrar sesión']"));


}
