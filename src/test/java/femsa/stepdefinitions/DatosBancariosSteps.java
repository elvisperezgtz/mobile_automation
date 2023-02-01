package femsa.stepdefinitions;

import femsa.tasks.Borrar;
import femsa.tasks.Confirmar;
import femsa.tasks.Guardar;
import femsa.user_interfaces.DatosBancariosUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;

import static femsa.user_interfaces.CommonsUI.EDITAR;
import static femsa.user_interfaces.DatosBancariosUI.CLABE;
import static femsa.user_interfaces.DatosBancariosUI.NOMBRE_TITULAR;
import static femsa.utils.StringGenerator.withOnlyRandomNumbers;

public class DatosBancariosSteps {
    @When("{actor} borra el contenido del campo CLABE Interbancaria")
    public void elvisBorraElContenidoDelCampoCLABEInterbancaria(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123"),
                Borrar.elCampoCLABEInterbancaria()
        );
    }

    @When("Elvis borra el contenido del campo Nombre del titular")
    public void elvisBorraElContenidoDelCampoNombreDelTitular(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123"),
                Borrar.elCampoNombreDelTitular()
        );
    }

    @When("{actor} ingresa una cuenta CLABE de {int} digitos")
    public void elvisIngresaUnaCuentaCLABEDeDigitos(Actor actor, int digitos) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123"),
                Click.on(CLABE)
                        .then(Enter.theValue(withOnlyRandomNumbers(digitos)).into(CLABE)),
                Click.on(NOMBRE_TITULAR)
        );
    }

    @Then("{actor} deberia ver la alerta de validacion de longitud con el texto {string}")
    public void elvisDeberiaVerLaAlertaDeValidacionDeLongitudConElTexto(Actor actor, String mensajeError) {
        actor.attemptsTo(
                Ensure.that(DatosBancariosUI.ALERTA_LONGITUD).text().isEqualTo(mensajeError)
        );
    }

    @When("{actor} edita su CLABE {string} y nombre de titular {string}")
    public void elvisEditaSuCLABEYNombreDeTitular(Actor actor, String clabe, String titular) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123"),
                Enter.theValue(titular).into(NOMBRE_TITULAR),
                Enter.theValue(clabe).into(CLABE),
                Guardar.datosBancarios()
        );
    }

    @Then("{actor} deberia ver el mensaje de confirmacion {string}")
    public void elvisDeberiaVerElMensajeDeConfirmacion(Actor actor, String mensaje) {
        actor.attemptsTo(
                Ensure.that(DatosBancariosUI.ACTUALIZACION_EXITOSA).text().isEqualTo(mensaje)
        );
    }
}
