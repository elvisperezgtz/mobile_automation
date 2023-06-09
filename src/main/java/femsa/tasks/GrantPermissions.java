package femsa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class GrantPermissions implements Task {

    private static final Logger LOGGER = Logger.getLogger(GrantPermissions.class.getName());
    private String androidVersion;
    private boolean isBluetoothActive;

    public GrantPermissions(String androidVersion, boolean isBluetoothActive) {
        this.androidVersion = androidVersion;
        this.isBluetoothActive = isBluetoothActive;
    }

    @Override
    @Step("{0} grants all required permissions for an Android mobile with version #androidVersion")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("granting permissions required on an cellphone Android " + androidVersion);
        if (isBluetoothActive) {
            LOGGER.info("Bluetooth enabled workflow");
            switch (androidVersion) {
                case "13":
                case "12":

                    actor.attemptsTo(
                            Grant.locationPermission(true),
                            Grant.proximityPermission(true)
                    );
                    break;
                case "10":
                case "9":
                case "8":
                    actor.attemptsTo(
                            Grant.locationPermission(true)
                    );
                    break;
                default:

                    break;

            }
        } else {
            LOGGER.info("Bluetooth disable workflow");
            switch (androidVersion) {
                case "13":
                case "12":
                    actor.attemptsTo(
                            Grant.locationPermission(true),
                            Grant.proximityPermission(true),
                            Grant.bluetoothPermission(true)
                    );
                    break;
                case "10":
                case "9":
                case "8":
                    actor.attemptsTo(
                            Grant.bluetoothPermission(true),
                            Grant.locationPermission(true)
                    );
                    break;
                default:
                    LOGGER.info("Workflow undefined...");

                    break;
            }
        }

    }

    public static GrantPermissions forAndroidPlatformVersion(String androidVersion, boolean isBluetoothActive) {
        return Tasks.instrumented(GrantPermissions.class, androidVersion, isBluetoothActive);
    }
}
