package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static femsa.user_interfaces.EditBusinessDataUI.EDIT;
import static femsa.user_interfaces.EditBusinessDataUI.BUSINESS_NAME;

public class Modificar {
    public static Performable nombreDeNegocio(String nombreNegocio){
        return Task.where("{0} modifica el nombre del negocio",
                Click.on(EDIT),
                Confirm.thePassword("Femsa123"),
                Enter.theValue(nombreNegocio).into(BUSINESS_NAME),
                Save.theEditedInformation()
                );
    }
}
