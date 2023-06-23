package femsa.tasks;

import femsa.utils.Validate;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.AuthorizeDeviceUI.DEVICES_FOUND;
import static femsa.user_interfaces.ProfileUI.AUTHORIZE_DEVICE;
import static femsa.user_interfaces.TurnOnYourDeviceUI.START;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AuthorizeDevice {

    public static Performable withoutInternetConnection(String platformVersion) {
        return Task.where("{0} authorizes his device with his wifi off",
                Click.on(AUTHORIZE_DEVICE),
                Click.on(START),
                Check.whether(Validate.isAndroid())
                        .andIfSo(GrantPermissions.forAndroidPlatformVersion(platformVersion, true))
                        .otherwise(/*GrantPermissions.forIos()*/),
                WaitUntil.the(DEVICES_FOUND, isVisible()).forNoMoreThan(ofSeconds(30))
        );


    }
}
