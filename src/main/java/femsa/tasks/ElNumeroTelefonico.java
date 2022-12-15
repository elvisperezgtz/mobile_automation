package femsa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static femsa.user_interfaces.RegistroUI.*;
import static java.time.Duration.ofSeconds;

public class ElNumeroTelefonico implements Task {
    private String numeroTelefonico;

    public ElNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    @Step("{0} se registra en la app con el numero telefonico #numeroTelefonico")
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(
                Empezar.registro(),
                Enter.theValue(numeroTelefonico).into(TELEFONO.waitingForNoMoreThan(ofSeconds(15))),
                Click.on(ACEPTO),
                Click.on(ENVIAR_CODIGO_SMS)
        );
    }


}
