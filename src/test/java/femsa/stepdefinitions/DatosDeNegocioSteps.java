package femsa.stepdefinitions;

import femsa.interactions.Clear;
import femsa.interactions.Hide;
import femsa.tasks.*;
import femsa.user_interfaces.DatosNegocioUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static femsa.user_interfaces.DatosNegocioUI.CODIGO_POSTAL;
import static femsa.user_interfaces.DatosNegocioUI.CODIGO_POSTAL_INCORRECTO;
import static femsa.user_interfaces.EditPersonalInformationUI.EDITAR;
import static femsa.user_interfaces.HomeUI.NOMBRE_NEGOCIO;

public class DatosDeNegocioSteps {
    @When("{actor} ingresa a la opcion datos de negocio")
    public void elvisIngresaALaOpcionDatosDeNegocio(Actor actor) {
        actor.attemptsTo(
                Navigate.aLaPantallaDeDatosDeNegocio()
        );
    }

    @When("{actor} edita los datos de negocio")
    public void elvisEditaLosDatosDeNegocio(Actor actor, DataTable datosNegocio) {
        List<Map<String, String>> rows = datosNegocio.asMaps(String.class, String.class);
        actor.attemptsTo(
                Editar.datosDelNegocio(
                        rows.get(0).get("Nombre"),
                        rows.get(0).get("Actividad"),
                        rows.get(0).get("CodigoPostal")
                )
        );
    }

    @And("{actor} deberia ver los datos actualizados correctamente")
    public void elvisDeberiaVerLosDatosActualizadosCorrectamente(Actor actor, DataTable datosNegocio) {

        List<Map<String, String>> rows = datosNegocio.asMaps(String.class, String.class);
        actor.attemptsTo(
                Ensure.that(DatosNegocioUI.NOMBRE_NEGOCIO).text().isEqualTo(rows.get(0).get("Nombre")),
//                Ensure.that(ACTIVIDAD_DE_TU_NEGOCIO).text().isEqualTo(rows.get(0).get("Actividad")),
                Ensure.that(CODIGO_POSTAL).text().isEqualTo(rows.get(0).get("CodigoPostal"))
        );
    }

    @When("{actor} intenta editar los datos del negocio")
    public void elvisIntentaEditarLosDatosDelNegocio(Actor actor) {

        actor.attemptsTo(Click.on(EDITAR));
    }

    @When("{actor} borra el contenido del campo Nombre de tu negocio e intenta guardar")
    public void elvisBorraElContenidoDelCampoNombreDeTuNegocioEIntentaGuardar(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123")
        );
        actor.attemptsTo(
                Borrar.campoEnNegocio(DatosNegocioUI.NOMBRE_NEGOCIO)
        );
    }

    @When("{actor} borra el contenido del campo Codigo postal e intenta guardar")
    public void elvisBorraElContenidoDelCampoCodigoPostalEIntentaGuardar(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123")
        );
        actor.attemptsTo(
                Borrar.campoEnNegocio(CODIGO_POSTAL)
        );
    }

    @When("{actor} modifica el codigo postal por {string}")
    public void elvisModificaElCodigoPostalPor(Actor actor, String codigoPostal) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123")
        );
        actor.attemptsTo(
                Clear.textBox(CODIGO_POSTAL),
                Enter.theValue(codigoPostal).into(CODIGO_POSTAL),
                Hide.theKeyboard(),
                Guardar.datos()
        );
    }

    @Then("{actor} deberia ver el mensaje {string}")
    public void elvisDeberiaVerElMensaje(Actor actor, String error) {
        actor.attemptsTo(
                Ensure.that(CODIGO_POSTAL_INCORRECTO).text().isEqualTo(error)
        );
    }

    @When("{actor} cambia el nombre del negocio por {string}")
    public void elvisCambiaElNombreDelNegocioPor(Actor actor, String negocio) {
        actor.attemptsTo(
                Modificar.nombreDeNegocio(negocio)
        );
    }

    @And("{actor} ingresa al home de la aplicacion")
    public void elvisIngresaAlHomeDeLaAplicacion(Actor actor) {
        actor.attemptsTo(Navigate.desdeNegocioHastaHome());
    }

    @Then("{actor} deberia ver el nombre del negocio {string}")
    public void elvisDeberiaVerElNombreDelNegocio(Actor actor, String nombreNegocio) {
        actor.attemptsTo(
                Ensure.that(NOMBRE_NEGOCIO).text().isEqualTo(nombreNegocio)
        );
    }


}
