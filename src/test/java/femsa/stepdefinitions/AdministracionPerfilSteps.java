package femsa.stepdefinitions;

import femsa.tasks.Confirmar;
import femsa.tasks.Navegar;
import femsa.user_interfaces.AdministracionPerilUI;
import femsa.user_interfaces.ClabeInterbancariaUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static femsa.user_interfaces.AdministracionPerilUI.*;
import static femsa.user_interfaces.ClabeInterbancariaUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AdministracionPerfilSteps {
    @When("{actor} ingresa a la opcion datos bancarios")
    public void elvisIngresaALaOpcionDatosBancarios(Actor actor) {
        actor.attemptsTo(
                Navegar.aAdministracionDePerfil()
        );

    }

    @Then("{actor} deberia ver los datos registrados Nombre del titular {string} y cuenta clabe {string}")
    public void elvisDeberiaVerLosDatosRegistradosNombreDelTitularYCuentaClabe(Actor actor,String titular, String cuentaClabe) {
        actor.attemptsTo(
                Ensure.that(NOMBRE_TITULAR).text().isEqualToIgnoringCase(titular),
                Ensure.that(CLABE_INTERBANCARIA).text().isEqualToIgnoringCase(cuentaClabe)
        );
    }

    @When("{actor} quiere editar sus datos bancarios")
    public void elvisQuiereEditarSusDatosBancarios(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR)
        );
    }

    @Then("{actor} deberia poder ver la pantalla de confirmacion de contrasenia")
    public void elvisDeberiaPoderVerLaPantallaDeConfirmacionDeContrasenia(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CONFIRMA_TU_CONTRASENIA, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(CONFIRMA_TU_CONTRASENIA).isDisplayed()
        );
    }

    @And("{actor} cancela la Confirmacion de la contrasenia")
    public void elvisCancelaLaConfirmacionDeLaContrasenia(Actor actor) {
        actor.attemptsTo(Click.on(CANCELAR));
    }

    @And("{actor} confirma la contrasenia {string}")
    public void elvisConfirmaLaContrasenia(Actor actor, String contrasenia) {
        actor.attemptsTo(Enter.theValue(contrasenia).into(CONTRASENIA));
    }

    @Then("{actor} deberia poder ver que los campos CLABE y Titular se pueden editar")
    public void elvisDeberiaPoderVerQueLosCamposCLABEYTitularSePuedenEditar(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(NOMBRE_TITULAR,isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(NOMBRE_TITULAR).isEnabled(),
                Ensure.that(CLABE_INTERBANCARIA).isEnabled()
        );
    }
}
