package femsa.stepdefinitions;

import femsa.tasks.Editar;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static femsa.user_interfaces.ConfirmarContraseniaUI.CONFIRMA_TU_CONTRASENIA;
import static femsa.user_interfaces.EdicionDatosPersonalesUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosPersonalesSteps {
    @Then("{actor} deberia ver sus datos personales registrados")
    public void elvisDeberiaVerSusDatosPersonalesRegistrados(Actor actor, DataTable datosPersonales) {
        List<Map<String, String>> rows = datosPersonales.asMaps(String.class, String.class);


        actor.attemptsTo(
                Ensure.that(NOMBRE).text().isEqualToIgnoringCase(rows.get(0).get("Nombre")),
                Ensure.that(APELLIDOS).text().isEqualToIgnoringCase(rows.get(0).get("Apellidos")),
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
                Editar.datosPersonales(rows.get(0).get("Nombre"),rows.get(0).get("Apellidos"),rows.get(0).get("Email"))
        );
    }

    @Then("{actor} deberia ver los cambios aplicados a sus datos personales")
    public void elvisDeberiaVerLosCambiosAplicadosASusDatosPersonales(Actor actor, DataTable datosPersonales) {
        List<Map<String, String>> rows = datosPersonales.asMaps(String.class, String.class);
        actor.attemptsTo(
                Ensure.that(NOMBRE).text().isEqualToIgnoringCase(rows.get(0).get("Nombre")),
                Ensure.that(APELLIDOS).text().isEqualToIgnoringCase(rows.get(0).get("Apellidos")),
                Ensure.that(EMAIL).text().isEqualToIgnoringCase(rows.get(0).get("Email"))
        );
    }


    @Then("{actor} deberia ver la imagen de perfil compuesta por la primera letra del nombre y del apellido")
    public void elvisDeberiaVerLaImagenDePerfilCompuestaPorLaPrimeraLetraDelNombreYDelApellido(Actor actor) {

                String primeraLetra = String.valueOf(NOMBRE.resolveFor(actor).getText().charAt(0));
                String segundaLetra = String.valueOf(APELLIDOS.resolveFor(actor).getText().charAt(0));
                String logo = primeraLetra.concat(segundaLetra);
                actor.attemptsTo(
                        Ensure.that(LOGO).text().isEqualTo(logo)
                );
    }
}
