package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.BankInformation;
import femsa.models.User;
import femsa.tasks.*;
import femsa.user_interfaces.CommonsUI;
import femsa.user_interfaces.EditBankAccountUI;
import femsa.utils.Convert;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;

import static femsa.user_interfaces.CommonsUI.EDITAR;
import static femsa.user_interfaces.EditBankAccountUI.ACCOUNT_HOLDER;
import static femsa.user_interfaces.EditBankAccountUI.CLABE;
import static femsa.utils.StringGenerator.withOnlyRandomNumbers;

public class EditBankAccountInformationSteps {
    @When("{actor} borra el contenido del campo CLABE Interbancaria")
    public void elvisBorraElContenidoDelCampoCLABEInterbancaria(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirm.thePassword("Femsa123"),
                Borrar.elCampoCLABEInterbancaria()
        );
    }

    @When("Elvis borra el contenido del campo Nombre del titular")
    public void elvisBorraElContenidoDelCampoNombreDelTitular(Actor actor) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirm.thePassword("Femsa123"),
                Borrar.elCampoNombreDelTitular()
        );
    }

    @When("{actor} ingresa una cuenta CLABE de {int} digitos")
    public void elvisIngresaUnaCuentaCLABEDeDigitos(Actor actor, int digitos) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirm.thePassword("Femsa123"),
                Click.on(CLABE)
                        .then(Enter.theValue(withOnlyRandomNumbers(digitos)).into(CLABE)),
                Click.on(ACCOUNT_HOLDER)
        );
    }

    @Then("{actor} deberia ver la alerta de validacion de longitud con el texto {string}")
    public void elvisDeberiaVerLaAlertaDeValidacionDeLongitudConElTexto(Actor actor, String mensajeError) {
        actor.attemptsTo(
                Ensure.that(EditBankAccountUI.ALERTA_LONGITUD).text().isEqualTo(mensajeError)
        );
    }

    @When("{actor} edita su CLABE {string} y nombre de titular {string}")
    public void elvisEditaSuCLABEYNombreDeTitular(Actor actor, String clabe, String titular) {
        actor.attemptsTo(
                Click.on(EDITAR),
                Confirm.thePassword("Femsa123"),
                Enter.theValue(titular).into(ACCOUNT_HOLDER),
                Enter.theValue(clabe).into(CLABE),
                Save.datosBancarios()
        );
    }

    @Then("{actor} deberia ver el mensaje de confirmacion {string}")
    public void elvisDeberiaVerElMensajeDeConfirmacion(Actor actor, String mensaje) {
        actor.attemptsTo(
                Ensure.that(EditBankAccountUI.ACTUALIZACION_EXITOSA).text().isEqualTo(mensaje)
        );
    }

    @When("{actor} enters in the bank account information option")
    public void heEntersInTheBankAccountInformationOption(Actor actor) {
        actor.attemptsTo(Navigate.toBankAccountInformationScreen());
    }

    @Then("{actor} should see his Bank account information registered")
    public void elvisShouldSeeHisBankAccountInformationRegistered(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(
                Visualize.bankAccountInformation(user)
        );
    }

    @Then("{actor} should see the bank account information form in edit mode")
    public void heShouldSeeTheBankAccountInformationFormInEditMode(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(Visualize.bankAccountInformationInEditMode(user));
    }

    @And("{actor} edits his interbank CLABE information with {string}")
    public void heEditsHisInterbankCLABEInformationWith(Actor actor, String clabe) {
        actor.attemptsTo(Edit.theClabe(clabe));
    }

    @Then("{actor} should see the message The CLABE must have 18 digits")
    public void heShouldSeeTheMessageTheCLABEMustHave18Digits(Actor actor) {
        actor.attemptsTo(Ensure.that(EditBankAccountUI.CLABE_MUST_HAVE_18_DIGITS).isDisplayed());
    }

    @Then("{actor} should see the alert This field is required")
    public void heShouldSeeTheAlertThisFieldIsRequired(Actor actor) {
        actor.attemptsTo(Ensure.that(CommonsUI.THIS_FIELD_IS_REQUIRED).isDisplayed());
    }

    @And("{actor} edits the Account holder field with {string}")
    public void heEditsTheAccountHolderFieldWith(Actor actor, String accountHolder) {
        actor.attemptsTo(Edit.theAccountHolder(accountHolder));
    }

    @And("{actor} edits the CLABE field with {string}")
    public void heEditsTheCLABEFieldWith(Actor actor, String clabe) {
        actor.attemptsTo(Edit.theClabe(clabe));
    }

    @And("{actor} changes his bank account information")
    public void heChangesHisBankAccountInformation(Actor actor, DataTable bankAccountInformation) {
        BankInformation bankInformation = Convert.dataTableToBankAccountInfo(bankAccountInformation);
        actor.attemptsTo(Edit.theBankAccountInformationForm(bankInformation.getClabe(), bankInformation.getAccountHolder()));
    }

    @Then("{actor} should see that there are not changes on his bank account information")
    public void heShouldSeeThatThereAreNotChangesOnHisBankAccountInformation(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(Visualize.bankAccountInformation(user));
    }
}
