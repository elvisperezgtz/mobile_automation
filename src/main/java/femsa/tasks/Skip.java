package femsa.tasks;

import femsa.user_interfaces.AlreadyHaveYourDeviceUI;
import femsa.user_interfaces.GettingItIsEasyUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Skip {
    public static Performable linkingDeviceProcess(){
        return Task.where("{0} skip the linking device process",
                Click.on(AlreadyHaveYourDeviceUI.I_DO_NOT_HAVE_YET),
                Click.on(GettingItIsEasyUI.DO_IT_LATER));
    }
}
