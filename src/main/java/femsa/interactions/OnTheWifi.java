package femsa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class OnTheWifi implements Interaction {
    private String deviceName;
    private static final Logger LOGGER = Logger.getLogger(OnTheWifi.class.getName());

    public OnTheWifi(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    @Step("{0} turns on the wifi")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Turning on the wifi...");
        actor.attemptsTo(
                Execute.theAdbCommand("adb -s " + deviceName + " shell svc wifi enable")
        );
    }
}
