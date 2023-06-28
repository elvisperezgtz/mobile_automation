package femsa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.logging.Logger;

public class Reject implements Task {


    private static final Logger LOGGER = Logger.getLogger(Reject.class.getName());
    private String androidVersion;
    private boolean isBluetoothActive;

    public Reject(String androidVersion, boolean isBluetoothActive) {
        this.androidVersion = androidVersion;
        this.isBluetoothActive = isBluetoothActive;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("rejecting  permissions required on an cellphone Android " + androidVersion);
        if (isBluetoothActive) {
            LOGGER.info("Bluetooth enabled workflow");
            switch (androidVersion) {
                case "13":
                case "12":
                    actor.attemptsTo(
                            Grant.locationPermission(false),
                            Grant.proximityPermission(false)
                    );
                    break;
                case "10":
                case "9":
                case "8":
                    actor.attemptsTo(
                            Grant.locationPermission(false)
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
                            Grant.locationPermission(false),
                            Grant.proximityPermission(false)
                    );
                    break;
                case "10":
                case "9":
                case "8":
                    actor.attemptsTo(
                            Grant.bluetoothPermission(false)
                    );
                    break;
                default:
                    LOGGER.info("Workflow undefined...");
                    break;
            }
        }
    }

    public static Reject permissionAndroid(String androidVersion, boolean isBluetoothActive) {
        return Tasks.instrumented(Reject.class, androidVersion, isBluetoothActive);
    }
}
