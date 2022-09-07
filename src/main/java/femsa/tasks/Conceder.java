package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Conceder {
    public static Performable permisosConBlueToothActivado() {
        return Task.where(
                "{0} vincula su movil con el dispositivo MPOS",
                Navegar.aVincularDispositivoMpos(),
                Permitir.usarUbicacion()
        );
    }

    public static Performable permisosConBluetoothDesactivado() {
        return Task.where(
                "{0} vincula su movil con el dispositivo MPOS cuando el bluetooth esta desactivado",
                Navegar.aVincularDispositivoMpos(),
                Permitir.activarBlueTooth(),
                Permitir.usarUbicacion()

        );
    }
}
