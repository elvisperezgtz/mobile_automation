package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static femsa.user_interfaces.ClabeInterbancariaUI.CONTINUAR;
import static femsa.user_interfaces.ClabeInterbancariaUI.CONTRASENIA;

public class Confirmar {
    public static Performable contrasenia(String contrasenia){
        return Task.where("{0} confirma su contrasenia",
                Enter.theValue(contrasenia).into(CONTRASENIA),
                Click.on(CONTINUAR)
        );
    }
}
