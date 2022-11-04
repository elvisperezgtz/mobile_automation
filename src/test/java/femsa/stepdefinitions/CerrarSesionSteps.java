package femsa.stepdefinitions;

import femsa.tasks.Cerrar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.LoginUI.CONTRASENIA;
import static femsa.user_interfaces.LoginUI.EMAIL_O_NUMERO;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarSesionSteps {

    @When("{actor} cierra la sesion de la app")
    public void elvisCierraLaSesionDeLaApp(Actor actor) {
        actor.attemptsTo(
                Cerrar.sesion()
        );
    }

    @Then("{actor} deberia ver la pantalla de inicio de sesion")
    public void elvisDeberiaVerLaPantallaDeInicioDeSesion(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(EMAIL_O_NUMERO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(EMAIL_O_NUMERO).isDisplayed(),
                Ensure.that(CONTRASENIA).isDisplayed()
        );
    }
}
