package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.IntroDispositivoUI.CONECTAR_DISPOSITIVO;
import static femsa.user_interfaces.IntroDispositivoUI.YA_LO_TENGO;

public class Vincular {
    public static Performable dispositivoMpos() {
        return Task.where(
                "{0} vincula su movil con el dispositivo MPOS",
                Click.on(YA_LO_TENGO),
                Click.on(CONECTAR_DISPOSITIVO),
                Permitir.usarUbicacion(),
                Conectar.elDispositivoMpos()
        );
    }

    public static Performable dispositivoMposAceptandoElUsoDeLocalizacionYBluetooth() {
        return Task.where(
                "{0} vincula su movil con el dispositivo MPOS cuando el bluetooth esta desactivado",
                Click.on(YA_LO_TENGO),
                Click.on(CONECTAR_DISPOSITIVO),
                Permitir.activarBlueTooth(),
                Permitir.usarUbicacion(),
                Conectar.elDispositivoMpos()
        );
    }
}
