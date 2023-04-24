package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Begin {
    public static Performable registration() {
        return Task.where("{0 begins registration process}",
                WaitUntil.the(BEGIN_REGISTRATION, isClickable()).forNoMoreThan(ofSeconds(15)),
                Click.on(BEGIN_REGISTRATION));
    }
}
