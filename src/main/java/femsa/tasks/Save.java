package femsa.tasks;

import femsa.user_interfaces.EditBankAccountUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.CommonsUI.CONTINUE;
import static femsa.user_interfaces.CommonsUI.SAVE;
import static femsa.user_interfaces.SaveModalUI.*;
import static java.time.Duration.ofSeconds;

public class Save {
    public static Performable theEditedInformation(){
        return Task.where("{0} saves the edited information",
                Click.on(SAVE.waitingForNoMoreThan(ofSeconds(15))),
                Click.on(CONTINUE)
        );
    }
    public static Performable datosBancarios(){
        return Task.where("{0} guarda los datos editados",
                Click.on(GUARDAR),
                Click.on(EditBankAccountUI.CONFIRMAR)
        );
    }
}
