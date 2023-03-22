package femsa.stepdefinitions;

import femsa.tasks.Navegar;
import femsa.user_interfaces.LoginUI;
import femsa.user_interfaces.RegisterInThreeStepsUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AyudaSteps {

    @Given("{actor} ingresa a la pantalla de inicio de sesion")
    public void elvisIngresaALaPantallaDeInicioDeSesion(Actor actor) {
        actor.wasAbleTo(Navegar.aLaPantallaDeLogin());
    }

    @When("{actor} ingresa a la ayuda de la pantalla de inicio de sesion")
    public void elvisIngresaALaAyudaDeLaPantallaDeInicioDeSesion(Actor actor) {
        actor.attemptsTo(
                Click.on(LoginUI.HELP)
        );
    }


    @When("{actor} ingresa a la ayuda de la pantalla recuperar contrasenia")
    public void elvisIngresaALaAyudaDeLaPantallaRecuperarContrasenia(Actor actor) {
        actor.attemptsTo(
                Click.on(LoginUI.FORGOT_PASSWORD),
                Click.on(LoginUI.HELP)
        );
    }

    @Then("{actor} deberia ver que se muestre la ayuda")
    public void elvisDeberiaVerQueSeMuestreLaAyuda(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginUI.HELP_TITLE, isVisible()).forNoMoreThan(ofSeconds(5)),
                Ensure.that(LoginUI.HELP_TITLE).isDisplayed()
        );
    }

    @When("{actor} ingresa a la ayuda de la pantalla Ingresa tu numero")
    public void elvisIngresaALaAyudaDeLaPantallaIngresaTuNumero(Actor actor) {
        actor.attemptsTo(
                Click.on(RegisterInThreeStepsUI.BEGIN_REGISTRATION),
                Click.on(LoginUI.HELP)
        );
    }
}
