package femsa.stepdefinitions;

import femsa.tasks.Navegar;
import femsa.user_interfaces.LoginUI;
import femsa.user_interfaces.OnBoardingUI;
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
                Click.on(LoginUI.AYUDA)
        );
    }


    @When("{actor} ingresa a la ayuda de la pantalla recuperar contrasenia")
    public void elvisIngresaALaAyudaDeLaPantallaRecuperarContrasenia(Actor actor) {
        actor.attemptsTo(
                Click.on(LoginUI.OLVIDE_MI_CONTRASENIA),
                Click.on(LoginUI.AYUDA)
        );
    }

    @Then("{actor} deberia ver que se muestre la ayuda")
    public void elvisDeberiaVerQueSeMuestreLaAyuda(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginUI.TITULO_AYUDA, isVisible()).forNoMoreThan(ofSeconds(5)),
                Ensure.that(LoginUI.TITULO_AYUDA).isDisplayed()
        );
    }

    @When("{actor} ingresa a la ayuda de la pantalla Ingresa tu numero")
    public void elvisIngresaALaAyudaDeLaPantallaIngresaTuNumero(Actor actor) {
        actor.attemptsTo(
                Click.on(OnBoardingUI.EMPEZAR_REGISTRO),
                Click.on(LoginUI.AYUDA)
        );
    }
}
