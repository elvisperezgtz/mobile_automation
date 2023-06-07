package femsa.tasks;

import femsa.utils.Validate;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static femsa.user_interfaces.AuthorizeDeviceUI.*;
import static femsa.user_interfaces.ProfileUI.AUTHORIZE_DEVICE;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Authorize implements Task {

    private boolean connectDevice;
    private boolean authorizeDevice;


    @Override
    @Step("{0} authorize his device")
    public <T extends Actor> void performAs(T actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        actor.attemptsTo(
                Click.on(AUTHORIZE_DEVICE),
                Click.on(START),
                Check.whether(Validate.isAndroid())
                        .andIfSo(GrantPermissions.forAndroidPlatformVersion(env.getProperty("appium.platformVersion")))
                        .otherwise(/*GrantPermissions.forIos()*/),
                WaitUntil.the(DEVICES_FOUND, isVisible()).forNoMoreThan(ofSeconds(30)),
                Check.whether(connectDevice)
                        .andIfSo(Click.on(CONNECT)),
                Check.whether(authorizeDevice)
                        .andIfSo(Click.on(AUTHORIZE_DEVICE_BUTTON.waitingForNoMoreThan(ofSeconds(15))))

        );
    }

    public static Authorize with() {
        return Tasks.instrumented(Authorize.class);
    }

    public Authorize connectDevice(boolean connectDevice) {
        this.connectDevice = connectDevice;
        return this;
    }

    public Authorize authorizeDevice(boolean authorizeDevice) {
        this.authorizeDevice = authorizeDevice;
        return this;
    }

}
