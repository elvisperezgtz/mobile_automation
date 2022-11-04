package femsa.stepdefinitions;

import femsa.tasks.Navegar;
import femsa.user_interfaces.DocumentosUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static femsa.user_interfaces.DocumentosUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DocumentosLegales {

    @And("{actor} ingresa a la opcion de Documentos legales")
    public void elvisIngresaALaOpcionDeDocumentosLegales(Actor actor) {
        actor.attemptsTo(
                Navegar.aLaPantallaDocumentosLegales()
        );
    }

    @Then("{actor} deberia poder ver las opciones de Terminos y condiciones y Politica de Privacidad")
    public void elvisDeberiaPoderVerLasOpcionesDeTerminosYCondicionesYPoliticaDePrivacidad(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(AVISO_PRIVACIDAD, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(AVISO_PRIVACIDAD).isDisplayed(),
                Ensure.that(TERMINOS_CONDICIONES).isDisplayed()
        );
    }

    @When("{actor} ingresa al documento Terminos y condiciones")
    public void elvisIngresaAlDocumentoTerminosYCondiciones(Actor actor) {
        actor.attemptsTo(
                Click.on(TERMINOS_CONDICIONES)
        );
    }

    @Then("{actor} deberia ver el documento de terminos y condiciones")
    public void elvisDeberiaVerElDocumentoDeTerminosYCondiciones(Actor actor) {
        actor.attemptsTo(Ensure.that(TITULO_TERMINOS_CONDICIONES).isDisplayed());
    }

    @When("{actor} ingresa al documento Aviso de privacidad")
    public void elvisIngresaAlDocumentoAvisoDePrivacidad(Actor actor) {
        actor.attemptsTo(Click.on(AVISO_PRIVACIDAD));
    }

    @Then("{actor} deberia ver el documento de Aviso de privacidad")
    public void elvisDeberiaVerElDocumentoDeAvisoDePrivacidad(Actor actor) {
        actor.attemptsTo(Ensure.that(TITULO_AVISO_PRIVACIDAD).isDisplayed());
    }
}
