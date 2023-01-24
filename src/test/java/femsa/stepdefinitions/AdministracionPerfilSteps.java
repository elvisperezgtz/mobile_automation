package femsa.stepdefinitions;

import femsa.tasks.*;
import femsa.user_interfaces.AdministracionPerilUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static femsa.user_interfaces.AdministracionPerilUI.PREGUNTAS_FRECUENTES;
import static femsa.user_interfaces.ClabeInterbancariaUI.*;
import static femsa.user_interfaces.ConfirmarContraseniaUI.CONFIRMA_TU_CONTRASENIA;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AdministracionPerfilSteps {
    @When("{actor} ingresa a la opcion datos bancarios")
    public void elvisIngresaALaOpcionDatosBancarios(Actor actor) {
        actor.attemptsTo(
                Navegar.aLaPantallaDeDatosBancarios()
        );
    }

    @Then("{actor} deberia ver los datos registrados Nombre del titular {string} y cuenta clabe {string}")
    public void elvisDeberiaVerLosDatosRegistradosNombreDelTitularYCuentaClabe(Actor actor, String titular, String cuentaClabe) {
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
        actor.attemptsTo(Confirmar.contrasenia(contrasenia));
    }

    @Then("{actor} deberia poder ver que los campos CLABE y Titular se pueden editar")
    public void elvisDeberiaPoderVerQueLosCamposCLABEYTitularSePuedenEditar(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(NOMBRE_TITULAR, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(NOMBRE_TITULAR).isEnabled(),
                Ensure.that(CLABE_INTERBANCARIA).isEnabled()
        );
    }

    @Then("{actor} debaria ver el mensaje Contraseña incorrecta")
    public void elvisDebariaVerElMensajeContraseñaIncorrecta(Actor actor) {
        actor.attemptsTo(
                Ensure.that(CONTRASENIA_INCORRECTA).isDisplayed()
        );
    }

    @And("{actor} cancela la actualizacion de los datos bancarios")
    public void elvisCancelaLaActualizacionDeLosDatosBancarios(Actor actor) {
        actor.attemptsTo(
                Cancelar.laActualizacionDeDatosBancarios()
        );
    }

    @Then("{actor} deberia ver la pantalla de datos bancarios con los campos deshabilitados")
    public void elvisDeberiaVerLaPantallaDeDatosBancariosConLosCamposDesabilitados(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(NOMBRE_TITULAR, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(NOMBRE_TITULAR).not().isEnabled(),
                Ensure.that(CLABE_INTERBANCARIA).not().isEnabled()
        );
    }

    @And("{actor} cancela la actualizacion de datos pero continua editando")
    public void elvisCancelaLaActualizacionDeDatosPeroContinuaEditando(Actor actor) {
        actor.attemptsTo(
                Cancelar.laActualizacionDeDatosBancariosYSeguirEditando()
        );
    }

    @And("{actor} intenta guardar los datos actualizados y cancela el guardado de datos")
    public void elvisIntentaGuardarLosDatosActualizadosYCancelaElGuardadoDeDatos(Actor actor) {
        actor.attemptsTo(Cancelar.guardadoDeDatos());
    }

    @When("{actor} edita sus datos bancarios con clabe {string} y titular {string}")
    public void elvisEditaSusDatosBancariosConClabeYTitular(Actor actor, String clabe, String titular) {
        actor.remember("clabe", clabe);
        actor.remember("titular", titular);
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia(theActorInTheSpotlight().recall("contrasenia"))
        );
        actor.attemptsTo(Editar.losDatosBancarios(clabe, titular));

    }

    @Then("{actor} deberia poder ver el mensaje de guardado con exito")
    public void elvisDeberiaPoderVerElMensajeDeGuardadoConExito(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(MENSAJE_GUARDADO_EXITOSO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(MENSAJE_GUARDADO_EXITOSO).isDisplayed()
        );
    }

    //TODO Guardar estos datos en un archivo y modificarlos automaticamente
    @And("{actor} deberia poder ver los datos actualizados correctamente")
    public void elvisDeberiaPoderVerLosDatosActualizadosCorrectamente(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(NOMBRE_TITULAR, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(NOMBRE_TITULAR).not().isEnabled(),
                Ensure.that(CLABE_INTERBANCARIA).not().isEnabled(),
                Ensure.that(NOMBRE_TITULAR).text().isEqualToIgnoringCase(actor.recall("titular")),
                Ensure.that(CLABE_INTERBANCARIA).text().isEqualToIgnoringCase(actor.recall("clabe"))

        );
    }

    @And("{actor} ingresa a la opcion de Administracion de Perfil")
    public void elvisIngresaALaOpcionDeAdministracionDePerfil(Actor actor) {
        actor.attemptsTo(Navegar.aLaPantallaAdministracionDePerfil());
    }

    @When("{actor} ingresa a la pantalla de administracion de perfil")
    public void elvisIngresaALaPantallaDeAdministracionDePerfil(Actor actor) {
        actor.attemptsTo(
                Navegar.aLaPantallaAdministracionDePerfil()
        );
    }

    @When("{actor} ingresa a la opcion Ayuda")
    public void elvisIngresaALaOpcionAyuda(Actor actor) {
        actor.attemptsTo(
                Ingresar.aLaPantallaAyuda()
        );
    }

    @Then("{actor} deberia ver la pantalla de FAQ's")
    public void elvisDeberiaVerLaPantallaDeFAQS(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PREGUNTAS_FRECUENTES, isCurrentlyVisible()).forNoMoreThan(Duration.ofSeconds(10))
                        .then(Ensure.that(PREGUNTAS_FRECUENTES).isDisplayed())
        );
    }

    @When("{actor} ingresa a la opcion datos personales")
    public void elvisIngresaALaOpcionDatosPersonales(Actor actor) {
        actor.attemptsTo(Navegar.aLaPantallaDeDatosPersonales());
    }

    @Then("{actor} deberia poder ver el numero de telefono registrado")
    public void elvisDeberiaPoderVerElNumeroDeTelefonoRegistrado(Actor actor) {
        actor.attemptsTo(Ensure.that(AdministracionPerilUI.NUMERO_TELEFONICO).isDisplayed());

    }
}
