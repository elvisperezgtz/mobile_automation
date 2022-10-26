package femsa.tasks;

import femsa.user_interfaces.CommonsUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Habilitar {
    public static Performable elBlueTooth(){
        return Task.where("{0} concede el acceso a Bluetooth",
                Click.on(CommonsUI.OK_BLUETOOTH));
    }
}
