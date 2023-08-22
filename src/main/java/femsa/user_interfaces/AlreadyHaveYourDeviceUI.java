package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AlreadyHaveYourDeviceUI {
    public static final Target TITLE = Target.the("Title of the Already have your device? screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"TEXT_TITLE\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"INTROMPOS_TITLE_LABEL\"]"));
    public static final Target I_HAVE_IT = Target.the("I have it button of the Already have your device? screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Ya lo tengo']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"INTROMPOS_HAVEDEVICE_BTN\"]"));
    public static final Target I_DO_NOT_HAVE_YET = Target.the("I don't have it yet button of the Already have your device? screen")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='Aún no lo tengo']"))
            .locatedForIOS(By.xpath("//XCUIElementTypeButton[@name=\"INTROMPOS_NOTHAVEDEVICE_BTN\"]"));
}
