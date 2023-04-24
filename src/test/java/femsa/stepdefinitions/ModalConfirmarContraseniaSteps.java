package femsa.stepdefinitions;

import femsa.interactions.Digitar;
import femsa.tasks.Confirm;
import femsa.user_interfaces.EditPersonalInformationUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.ConfirmPasswordModalUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ModalConfirmarContraseniaSteps {

    @And("{actor} presiona el boton cancelar")
    public void elvisPresionaElBotonCancelar(Actor actor) {
        actor.attemptsTo(Click.on(CANCELAR));
    }

    @Then("{actor} deberia ver la pantalla de datos personales con los campos deshabilitados")
    public void elvisDeberiaVerLaPantallaDeDatosPersonalesConLosCamposDeshabilitados(Actor actor) {
        actor.attemptsTo(
                Ensure.that(EditPersonalInformationUI.FIRST_NAME).not().isEnabled(),
                Ensure.that(EditPersonalInformationUI.LAST_NAME).not().isEnabled(),
                Ensure.that(EditPersonalInformationUI.EMAIL).not().isEnabled()
        );
    }

    @And("{actor} ingresa una contrasenia {string}")
    public void elvisIngresaUnaContrasenia(Actor actor, String contrasenia) {
        actor.attemptsTo(
                Confirm.thePassword(contrasenia)
        );
    }

    @Then("{actor} deberia ver el mensaje Contraseña incorrecta")
    public void elvisDeberiaVerElMensajeContraseñaIncorrecta(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(ERROR_MESSAGE, isVisible()).forNoMoreThan(ofSeconds(10)),
                Ensure.that(ERROR_MESSAGE).isDisplayed()
        );
    }

    @Then("{actor} deberia ver los campos del formulario de datos personales habilitados para edicion")
    public void elvisDeberiaVerLosCamposDelFormularioDeDatosPersonalesHabilitadosParaEdicion(Actor actor) throws InterruptedException {
        Thread.sleep(4000);
        actor.attemptsTo(
                Ensure.that(EditPersonalInformationUI.FIRST_NAME).isEnabled(),
                Ensure.that(EditPersonalInformationUI.LAST_NAME).isEnabled(),
                Ensure.that(EditPersonalInformationUI.EMAIL).isEnabled()
        );
    }

    @And("{actor} ingresa una contrasenia con {int} caracteres")
    public void elvisIngresaUnaContraseniaConCaracteres(Actor actor, int caracteres) {
        String cadena = "1234567890123456789012345678901234";
        actor.attemptsTo(
                Digitar.conTecladoNativo(cadena)
        );
    }

    @Then("{actor} deberia ver que el campo contraseña solo tiene {int} caracteres")
    public void elvisDeberiaVerQueElCampoContraseñaSoloTieneCaracteres(Actor actor, int caracteres) {
        actor.attemptsTo(
                Ensure.that(PASSWORD).text().hasSize(caracteres)
        );
    }

    @Then("{actor} should see the error message {string}")
    public void heShouldSeeTheErrorMessage(Actor actor, String errorMessage) {
        actor.attemptsTo(Ensure.that(ERROR_MESSAGE).text().isEqualTo(errorMessage));
    }
}
