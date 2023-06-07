package femsa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class GrantPermissions implements Task {

    private String androidVersion;

    public GrantPermissions(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    @Override
    @Step("{0} grants all required permissions for an Android mobile with version #androidVersion")
    public <T extends Actor> void performAs(T actor) {

        switch (androidVersion) {
            case "13":
                actor.attemptsTo(
                        Grant.locationPermission(true),
                        Grant.proximityPermission(true)
                );
                break;
            case "11":
                actor.attemptsTo(
                        Grant.bluetoothPermission(true),
                        Grant.locationPermission(true)
                );
                break;
            default:
                break;

        }
    }

    public static GrantPermissions forAndroidPlatformVersion(String androidVersion) {
        return Tasks.instrumented(GrantPermissions.class, androidVersion);
    }
}
