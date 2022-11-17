package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.CobroUI.CANCELAR;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Cacelar {
    public static Performable elReintentoDeCobro(){
        return Task.where("{0} cancela el reintento de cobro",
                WaitUntil.the(CANCELAR, isVisible()).forNoMoreThan(ofSeconds(15))
                        .then(Click.on(CANCELAR))
        );
    }
}
