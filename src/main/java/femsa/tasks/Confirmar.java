package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.ConfirmarContraseniaUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Confirmar {
    public static Performable contrasenia(String contrasenia){
        return Task.where("{0} confirma su contrasenia",
                WaitUntil.the(CONFIRMA_TU_CONTRASENIA, isVisible()).forNoMoreThan(ofSeconds(10)),
                Enter.theValue(contrasenia).into(CONTRASENIA),
                Click.on(CONTINUAR)
        );
    }

}
