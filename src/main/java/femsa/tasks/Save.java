package femsa.tasks;

import femsa.interactions.Hide;
import femsa.user_interfaces.EditBankAccountUI;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static femsa.user_interfaces.CommonsUI.*;
import static femsa.user_interfaces.SaveModalUI.*;
import static java.time.Duration.ofSeconds;

public class Save {
    public static Performable theEditedInformation(){
        return Task.where("{0} saves the edited information",
                Check.whether(Validate.isIOS())
                        .andIfSo(Hide.theKeyboard()),
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
