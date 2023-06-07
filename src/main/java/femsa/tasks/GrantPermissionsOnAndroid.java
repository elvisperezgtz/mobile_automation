package femsa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class Grant implements Task {
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

    @Override
    @Step("{0} grants required device permissions")
    public <T extends Actor> void performAs(T actor) {
        EnvironmentVariables env = actor.recall("env");

        switch (env.getProperty("appium.platformVersion")) {
            case "13":
                actor.attemptsTo(
                        Click.on(WHILE_THE_APP_IS_IN_USE),


                );
        }
    }
}
