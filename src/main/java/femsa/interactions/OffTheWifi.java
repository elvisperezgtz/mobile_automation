package femsa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class OffTheWifi implements Interaction {
    private static final Logger LOGGER = Logger.getLogger(OffTheWifi.class.getName());
    private String deviceName;

    public OffTheWifi(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    @Step("{0} turns off the wifi")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Turning off the wifi...");
        actor.attemptsTo(
                Execute.theAdbCommand("adb -s " + deviceName + " shell svc wifi disable")
        );
    }

}
