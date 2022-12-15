package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.OnBoardingUI.EMPEZAR_REGISTRO;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Empezar {
    public static Performable registro() {
        return Task.where(
                WaitUntil.the(EMPEZAR_REGISTRO, isClickable()).forNoMoreThan(ofSeconds(15)),
                Click.on(EMPEZAR_REGISTRO));
    }
}
