package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.CobroUI.VOLVER_A_INTENTAR;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Reintentar {
    public static Performable elCobro(){
        return Task.where("{0} reintenta el cobro",
                WaitUntil.the(VOLVER_A_INTENTAR, isVisible()).forNoMoreThan(ofSeconds(15))
                        .then(Click.on(VOLVER_A_INTENTAR))
        );
    }
}
