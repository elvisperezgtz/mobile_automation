package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.interactions.Clear;
import femsa.interactions.Hide;
import femsa.models.User;
import femsa.tasks.*;
import femsa.user_interfaces.EditBusinessDataUI;
import femsa.utils.jsons.JsonTemplate;
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

import static femsa.user_interfaces.EditBusinessDataUI.POSTAL_CODE;
import static femsa.user_interfaces.EditBusinessDataUI.CODIGO_POSTAL_INCORRECTO;
import static femsa.user_interfaces.EditPersonalInformationUI.EDIT;
import static femsa.user_interfaces.HomeUI.NOMBRE_NEGOCIO;

public class DatosDeNegocioSteps {
    @When("{actor} ingresa a la opcion datos de negocio")
    public void elvisIngresaALaOpcionDatosDeNegocio(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheBusinessInformationScreen()
        );
    }

    @When("{actor} edita los datos de negocio")
    public void elvisEditaLosDatosDeNegocio(Actor actor, DataTable datosNegocio) {
        List<Map<String, String>> rows = datosNegocio.asMaps(String.class, String.class);
        actor.attemptsTo(
                Edit.datosDelNegocio(
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
                Ensure.that(EditBusinessDataUI.BUSINESS_NAME).text().isEqualTo(rows.get(0).get("Nombre")),
//                Ensure.that(ACTIVIDAD_DE_TU_NEGOCIO).text().isEqualTo(rows.get(0).get("Actividad")),
                Ensure.that(POSTAL_CODE).text().isEqualTo(rows.get(0).get("CodigoPostal"))
        );
    }

    @When("{actor} intenta editar los datos del negocio")
    public void elvisIntentaEditarLosDatosDelNegocio(Actor actor) {

        actor.attemptsTo(Click.on(EDIT));
    }

    @When("{actor} borra el contenido del campo Nombre de tu negocio e intenta guardar")
    public void elvisBorraElContenidoDelCampoNombreDeTuNegocioEIntentaGuardar(Actor actor) {
        actor.attemptsTo(
                Click.on(EDIT),
                Confirm.thePassword("Femsa123")
        );
        actor.attemptsTo(
                Borrar.campoEnNegocio(EditBusinessDataUI.BUSINESS_NAME)
        );
    }

    @When("{actor} borra el contenido del campo Codigo postal e intenta guardar")
    public void elvisBorraElContenidoDelCampoCodigoPostalEIntentaGuardar(Actor actor) {
        actor.attemptsTo(
                Click.on(EDIT),
                Confirm.thePassword("Femsa123")
        );
        actor.attemptsTo(
                Borrar.campoEnNegocio(POSTAL_CODE)
        );
    }

    @When("{actor} modifica el codigo postal por {string}")
    public void elvisModificaElCodigoPostalPor(Actor actor, String codigoPostal) {
        actor.attemptsTo(
                Click.on(EDIT),
                Confirm.thePassword("Femsa123")
        );
        actor.attemptsTo(
                Clear.textBox(POSTAL_CODE),
                Enter.theValue(codigoPostal).into(POSTAL_CODE),
                Hide.theKeyboard(),
                Save.theEditedInformation()
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

    /***
     * changes
     */

    @When("{actor} enters in the Business data option")
    public void heEntersInTheBusinessDataOption(Actor actor) {
        actor.attemptsTo(Navigate.toTheBusinessInformationScreen());
    }

    @Then("{actor} should see his Business information registered")
    public void heShouldSeeHisBusinessInformationRegistered(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(Visualize.hisBusinessInformation(user));
    }

    @And("{actor} wants to edit his Business information")
    public void heWantsToEditHisBusinessInformation(Actor actor) {
        actor.attemptsTo(Click.on(EDIT));
    }

    @Then("{actor} should see the business information form in edit mode")
    public void heShouldSeeTheBusinessInformationFormInEditMode(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(Visualize.theBusinessInformationFormInEditMode(user));

    }

    @And("{actor} changes his Business name for {string}")
    public void heChangesHisBusinessNameFor(Actor actor, String businessName) {
        actor.attemptsTo(Edit.businessName(businessName));
    }
}
