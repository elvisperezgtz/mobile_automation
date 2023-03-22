package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResetPasswordUI {

    public static final Target RESET_PASSWORD_TITLE = Target.the("title")
            .locatedForAndroid(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.q0/android.view.View/android.view.View/android.view.View/android.widget.TextView[1]"))
            .locatedForIOS(By.xpath(""));

    public static final Target HELP = Target.the("help button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_HELP\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target BACK = Target.the("back button")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"ICONBUTTON_BACK\"]"))
            .locatedForIOS(By.xpath(""));

    public static final Target PHONE_NUMBER = Target.the("phone number field")
            .locatedForAndroid(By.xpath("//android.view.View[@content-desc=\"REGISTERPHONENUMBER_COLUMN_PHONENUMBER\"]/android.widget.EditText[2]/android.view.View[2]"))
            .locatedForIOS(By.xpath(""));

    public static final Target CONTINUE = Target.the("Continue button")
            .locatedForAndroid(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.q0/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.Button"))
            .locatedForIOS(By.xpath(""));

}
