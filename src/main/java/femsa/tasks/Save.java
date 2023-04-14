package femsa.tasks;

import femsa.user_interfaces.DatosBancariosUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.SaveModalUI.*;

public class Save {
    public static Performable theEditedInformation(){
        return Task.where("{0} saves the edited information",
                Click.on(SAVE),
                Click.on(CONTINUE)
                );
    }
    public static Performable datosBancarios(){
        return Task.where("{0} guarda los datos editados",
                Click.on(GUARDAR),
                Click.on(DatosBancariosUI.CONFIRMAR)
        );
    }
}
