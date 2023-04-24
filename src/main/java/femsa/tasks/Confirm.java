package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.ConfirmPasswordModalUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Confirm {
    public static Performable thePassword(String password){
        return Task.where("{0} confirms the password",
                WaitUntil.the(TITLE, isVisible()).forNoMoreThan(ofSeconds(10)),
                Enter.theValue(password).into(PASSWORD),
                Click.on(CONTINUE)
        );
    }

}
