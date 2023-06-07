package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LocationPermissionsUI {

    public static final Target TITLE = Target.the("Location permission title")
            .locatedForAndroid(By.id("com.android.permissioncontroller:id/permission_message"))
            .locatedForIOS(By.xpath(""));

    public static final Target WHILE_THE_APP_IS_IN_USE = Target.the("While the app is in use button")
            .locatedForAndroid(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
            .locatedForIOS(By.xpath(""));

    public static final Target ONLY_THIS_TIME = Target.the("Only this time button")
            .locatedForAndroid(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button"))
            .locatedForIOS(By.xpath(""));

    public static final Target DO_NOT_ALLOW = Target.the("Do not allow button")
            .locatedForAndroid(By.id("com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button"))
            .locatedForIOS(By.xpath(""));

}
