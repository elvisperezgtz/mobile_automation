package femsa.tasks;

import femsa.user_interfaces.ActivateBluetoothUI;
import femsa.user_interfaces.LocationPermissionsUI;
import femsa.user_interfaces.ProximityPermissionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

public class GrantPermissionsOnAndroid implements Task {

    private boolean activateBluetooth;
    private boolean grantLocation;
    private boolean grantProximity;

    public static Performable permisosConBlueToothActivado() {
        return Task.where(
                "{0} vincula su movil con el dispositivo MPOS",
                Navigate.aVincularDispositivoMpos(),
                Permitir.usarUbicacion()
        );
    }

    public static Performable permisosConBluetoothDesactivado() {
        return Task.where(
                "{0} vincula su movil con el dispositivo MPOS cuando el bluetooth esta desactivado",
                Navigate.aVincularDispositivoMpos(),
                Permitir.activarBlueTooth(),
                Permitir.usarUbicacion()
        );
    }
    //TODO review this class to eliminate

    @Override
    @Step("{0} grants required device permissions")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Check.whether(grantLocation)
                        .andIfSo(Click.on(LocationPermissionsUI.WHILE_THE_APP_IS_IN_USE))
                        .otherwise(Click.on(LocationPermissionsUI.DO_NOT_ALLOW)),
                Check.whether(grantProximity)
                        .andIfSo(Click.on(ProximityPermissionUI.ALLOW))
                        .otherwise(Click.on(ProximityPermissionUI.DO_NOT_ALLOW)),
                Check.whether(activateBluetooth)
                        .andIfSo(Click.on(ActivateBluetoothUI.ALLOW))
                        .andIfSo(Click.on(ActivateBluetoothUI.REJECT))
        );

    }

    public static GrantPermissionsOnAndroid with() {
        return Tasks.instrumented(GrantPermissionsOnAndroid.class);
    }

    public GrantPermissionsOnAndroid activateBluetooth(boolean activateBluetooth) {
        this.activateBluetooth = activateBluetooth;
        return this;
    }

    public GrantPermissionsOnAndroid grantLocation(boolean grantLocation) {
        this.grantLocation = grantLocation;
        return this;
    }

    public GrantPermissionsOnAndroid grantProximity(boolean grantProximity) {
        this.grantProximity = grantProximity;
        return this;
    }

}
