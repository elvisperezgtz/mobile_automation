package femsa.tasks;

import femsa.user_interfaces.ActivateBluetoothUI;
import femsa.user_interfaces.LocationPermissionsUI;
import femsa.user_interfaces.ProximityPermissionUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class Grant {

    public static Performable bluetoothPermission(boolean grantPermission) {
        return Task.where("{0} grants bluetooth permission",
                Check.whether(grantPermission)
                        .andIfSo(Click.on(ActivateBluetoothUI.ALLOW))
                        .otherwise(Click.on(ActivateBluetoothUI.REJECT))
        );
    }

    public static Performable locationPermission(boolean grantPermission) {
        return Task.where("{0} grants location permission",
                Check.whether(grantPermission)
                        .andIfSo(Click.on(LocationPermissionsUI.WHILE_THE_APP_IS_IN_USE))
                        .otherwise(Click.on(LocationPermissionsUI.DO_NOT_ALLOW))
        );
    }

    public static Performable proximityPermission(boolean grantPermission) {
        return Task.where("{0} grants proximity permission",
                Check.whether(grantPermission)
                        .andIfSo(Click.on(ProximityPermissionUI.ALLOW))
                        .otherwise(Click.on(ProximityPermissionUI.DO_NOT_ALLOW))
        );
    }
}
