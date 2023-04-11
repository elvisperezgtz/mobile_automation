package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.DoYouWantToGoModalUI.EXIT_WITHOUT_SAVING;
import static femsa.user_interfaces.EditPersonalInformationUI.CANCEL;

public class Refuse {
    public static Performable toSaveEditedData(){
        return Task.where("{0} refuses to save the edited data",
                Click.on(CANCEL),
                Click.on(EXIT_WITHOUT_SAVING));
    }
}
