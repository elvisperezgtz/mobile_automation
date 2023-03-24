package femsa.stepdefinitions;

import femsa.interactions.Clear;
import femsa.interactions.Hide;
import femsa.tasks.Borrar;
import femsa.tasks.Confirmar;
import femsa.tasks.Editar;
import femsa.tasks.Guardar;
import femsa.user_interfaces.AdministracionPerilUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static femsa.user_interfaces.ConfirmarContraseniaUI.CONFIRMA_TU_CONTRASENIA;
import static femsa.user_interfaces.EditPersonalInformationUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosPersonalesSteps {
    @Then("{actor} deberia ver sus datos personales registrados")
    public void elvisDeberiaVerSusDatosPersonalesRegistrados(Actor actor, DataTable datosPersonales) {
        List<Map<String, String>> rows = datosPersonales.asMaps(String.class, String.class);

        actor.attemptsTo(
                Ensure.that(FIRST_NAME).text().isEqualToIgnoringCase(rows.get(0).get("Nombre")),
                Ensure.that(LAST_NAME).text().isEqualToIgnoringCase(rows.get(0).get("Apellidos")),
                Ensure.that(EMAIL).text().isEqualToIgnoringCase(rows.get(0).get("Email"))
        );
    }

    @When("{actor} intenta editar sus datos personales")
    public void elvisIntentaEditarSusDatosPersonales(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR)
        );
    }

    @Then("{actor} deberia ver la solicitud de confirmacion de su contrasenia")
    public void elvisDeberiaVerLaSolicitudDeConfirmacionDeSuContrasenia(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CONFIRMA_TU_CONTRASENIA, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(CONFIRMA_TU_CONTRASENIA).isDisplayed()
        );
    }

    @When("{actor} edita sus datos personales")
    public void elvisEditaSusDatosPersonales(Actor actor, DataTable datosPersonales) {
        List<Map<String, String>> rows = datosPersonales.asMaps(String.class, String.class);
        actor.attemptsTo(
                Editar.datosPersonales(rows.get(0).get("Nombre"), rows.get(0).get("Apellidos"), rows.get(0).get("Email"))
        );
    }

    @Then("{actor} deberia ver los cambios aplicados a sus datos personales")
    public void elvisDeberiaVerLosCambiosAplicadosASusDatosPersonales(Actor actor, DataTable datosPersonales) {
        List<Map<String, String>> rows = datosPersonales.asMaps(String.class, String.class);
        actor.attemptsTo(
                Ensure.that(FIRST_NAME).text().isEqualToIgnoringCase(rows.get(0).get("Nombre")),
                Ensure.that(LAST_NAME).text().isEqualToIgnoringCase(rows.get(0).get("Apellidos")),
                Ensure.that(EMAIL).text().isEqualToIgnoringCase(rows.get(0).get("Email"))
        );
    }

    @Then("{actor} deberia ver la imagen de perfil compuesta por la primera letra del nombre y del apellido")
    public void elvisDeberiaVerLaImagenDePerfilCompuestaPorLaPrimeraLetraDelNombreYDelApellido(Actor actor) {

        String primeraLetra = String.valueOf(FIRST_NAME.resolveFor(actor).getText().charAt(0));
        String segundaLetra = String.valueOf(LAST_NAME.resolveFor(actor).getText().charAt(0));
        String logo = primeraLetra.concat(segundaLetra);
        actor.attemptsTo(
                Ensure.that(LOGO).text().isEqualTo(logo)
        );
    }

    @When("{actor} borra el contenido del campo Nombre e intenta guardar")
    public void elvisBorraElContenidoDelCampoNombreEIntentaGuardar(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123"),
                Borrar.campoEnDatosPersonales(FIRST_NAME)
        );
    }

    @Then("{actor} deberia ver la alerta Este campo es obligatorio")
    public void elvisDeberiaVerLaAlertaEsteCampoEsObligatorio(Actor actor) {

    }

    @When("{actor} borra el contenido del campo Apellidos e intenta guardar")
    public void elvisBorraElContenidoDelCampoApellidosEIntentaGuardar(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123")
        );
        actor.attemptsTo(
                Borrar.campoEnDatosPersonales(LAST_NAME)
        );
    }

    @Then("{actor} deberia ver la alerta {string}")
    public void elvisDeberiaVerLaAlerta(Actor actor, String error) {
        actor.attemptsTo(
                Ensure.that(MENSAJE_CAMPO_OBLIGATORIO).text().isEqualTo(error)
        );
    }

    @When("{actor} borra el contenido del campo Email e intenta guardar")
    public void elvisBorraElContenidoDelCampoEmailEIntentaGuardar(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123")
        );
        actor.attemptsTo(
                Borrar.campoEnDatosPersonales(EMAIL)
        );
    }

    @When("{actor} cambia el correo registrado por otro correo registrado previamente")
    public void elvisCambiaElCorreoRegistradoPorOtroCorreoRegistradoPreviamente(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123")
        );
        actor.attemptsTo(
                Clear.textBox(EMAIL)
        );
        actor.attemptsTo(
                Enter.theValue("azcarate@palo-it.com").into(EMAIL));
        actor.attemptsTo(Hide.theKeyboard());
        actor.attemptsTo(
                Guardar.datos()
        );
    }

    @When("{actor} modifica el correo electronico {string}")
    public void elvisModificaElCorreoElectronico(Actor actor, String email) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123")
        );
        actor.attemptsTo(
                Clear.textBox(EMAIL)
        );
        actor.attemptsTo(
                Enter.theValue(email).into(EMAIL));
        actor.attemptsTo(Hide.theKeyboard());

        actor.attemptsTo(Click.on(LOGO)
        );
    }

    @Then("{actor} deberia ver la alerta con el texto {string}")
    public void elvisDeberiaVerLaAlertaConElTexto(Actor actor, String mensajeError) {
        actor.attemptsTo(
                Ensure.that(MENSAJE_FORMATO_INCORRECTO).text().isEqualTo(mensajeError)
        );
    }

    @When("{actor} modifica su nombre {string} y apellidos {string}")
    public void elvisModificaSuNombreYApellidos(Actor actor, String nombres, String apellidos) {

        actor.attemptsTo(
                Editar.datosPersonales(nombres, apellidos, "another@mail.com")
        );
    }

    @Then("{actor} deberia ver el logo modificado con las iniciales {string}")
    public void elvisDeberiaVerElLogoModificadoConLasIniciales(Actor actor, String iniciales) {
        actor.attemptsTo(
                Ensure.that(LOGO.waitingForNoMoreThan(Duration.ofSeconds(15))).text().isEqualTo(iniciales)
        );
    }

    @And("{actor} regresa a la pantalla de perfil")
    public void elvisRegresaALaPantallaDePerfil(Actor actor) {
        actor.attemptsTo(Click.on(ATRAS));
    }

    @Then("{actor} deberia ver el logo en la pantalla Perfil modificado con las iniciales {string}")
    public void elvisDeberiaVerElLogoEnLaPantallaPerfilModificadoConLasIniciales(Actor actor, String iniciales) {
        actor.attemptsTo(
                Ensure.that(AdministracionPerilUI.LOGO).text().isEqualTo(iniciales)
        );
    }

    @And("{actor} deberia ver el titulo {string} en la pantalla perfil")
    public void elvisDeberiaVerElTituloEnLaPantallaPerfil(Actor actor, String titulo) {
        actor.attemptsTo(Ensure.that(AdministracionPerilUI.NOMBRE_USUARIO).text().isEqualTo(titulo));
    }
}
