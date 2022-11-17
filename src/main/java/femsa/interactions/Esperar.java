package femsa.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static java.time.Duration.ofMinutes;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static femsa.user_interfaces.RegistroUI.REENVIAR_SMS;

public class Esperar {
    public static Performable queTermineLaCuentaRegresiva(){
        return Task.where("{0} espera que termine la cuenta regresiva",
                WaitUntil.the(REENVIAR_SMS, isVisible()).forNoMoreThan(ofMinutes(3))
                );
    }
}
