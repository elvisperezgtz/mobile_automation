package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AlreadyHaveYourDeviceUI {
    public static final Target TITLE = Target.the("Title of the Already have your device? screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath(""));
    public static final Target I_HAVE_IT = Target.the("I have it button of the Already have your device? screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Ya lo tengo']"))
            .locatedForIOS(By.xpath(""));
    public static final Target I_DONT_HAVE = Target.the("I don't have it yet button of the Already have your device? screen")
            .locatedForAndroid(By.xpath(""))
            .locatedForIOS(By.xpath(""));
}
