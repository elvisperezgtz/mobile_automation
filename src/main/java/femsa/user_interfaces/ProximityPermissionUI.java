package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProximityPermissionUI {

    public static final Target TITLE = Target.the("Proximity permission title")
            .locatedForAndroid(By.id("com.android.permissioncontroller:id/permission_message"))
            .locatedForIOS(By.xpath(""));

    public static final Target ALLOW = Target.the("Allow button")
            .locatedForAndroid(By.id("com.android.permissioncontroller:id/permission_allow_button"))
            .locatedForIOS(By.xpath(""));

    public static final Target DO_NOT_ALLOW = Target.the("Do not allow")
            .locatedForAndroid(By.id("com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button"))
            .locatedForIOS(By.xpath(""));

}
