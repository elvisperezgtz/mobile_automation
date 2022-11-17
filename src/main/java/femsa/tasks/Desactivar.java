package femsa.tasks;

import femsa.interactions.Ejecutar;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Desactivar {
    public static Performable blueTooth(){
        return Task.where(
                "{0} desactiva el bluetooth",
                Ejecutar.elComandoAdb("adb shell am start -a android.bluetooth.adapter.action.REQUEST_DISABLE"),
                Ejecutar.elComandoAdb("adb shell input keyevent 22 "),
                Ejecutar.elComandoAdb("adb shell input keyevent 22 "),
                Ejecutar.elComandoAdb("adb shell input keyevent 66 ")
        );
    }
}
