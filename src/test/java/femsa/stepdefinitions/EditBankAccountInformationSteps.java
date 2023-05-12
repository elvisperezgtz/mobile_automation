package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.JsonPath;
import femsa.models.BankInformation;
import femsa.models.User;
import femsa.tasks.Edit;
import femsa.tasks.Navigate;
import femsa.user_interfaces.CommonsUI;
import femsa.utils.Convert;
import femsa.utils.Validate;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;

import static femsa.user_interfaces.EditBankAccountUI.CLABE_MUST_HAVE_18_DIGITS;

public class EditBankAccountInformationSteps {


    @When("{actor} enters in the bank account information option")
    public void heEntersInTheBankAccountInformationOption(Actor actor) {
        actor.attemptsTo(Navigate.toBankAccountInformationScreen());
    }

    @Then("{actor} should see his Bank account information registered")
    public void elvisShouldSeeHisBankAccountInformationRegistered(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(),env.getProperty("actor") );
        actor.attemptsTo(
                Visualize.bankAccountInformation(user.getBankInformation())
        );
    }

    @Then("{actor} should see the bank account information form in edit mode")
    public void heShouldSeeTheBankAccountInformationFormInEditMode(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(),env.getProperty("actor") );
        actor.attemptsTo(Visualize.bankAccountInformationInEditMode(user));
    }

    @And("{actor} edits his interbank CLABE information with {string}")
    public void heEditsHisInterbankCLABEInformationWith(Actor actor, String clabe) {
        actor.attemptsTo(Edit.theClabe(clabe));
    }

    @Then("{actor} should see the message The CLABE must have 18 digits")
    public void heShouldSeeTheMessageTheCLABEMustHave18Digits(Actor actor) {
        actor.attemptsTo(
//                Ensure.that(EditBankAccountUI.CLABE_MUST_HAVE_18_DIGITS).isDisplayed()
                Check.whether(Validate.isAndroid())
                        .andIfSo(Ensure.that(CLABE_MUST_HAVE_18_DIGITS).isDisplayed())
                        .otherwise(Ensure.that(CLABE_MUST_HAVE_18_DIGITS).text().isEqualTo("La CLABE debe tener 18 dígitos"))
        );
    }

    @Then("{actor} should see the alert This field is required")
    public void heShouldSeeTheAlertThisFieldIsRequired(Actor actor) {
        actor.attemptsTo(Check.whether(Validate.isAndroid()).andIfSo(Ensure.that(CommonsUI.THIS_FIELD_IS_REQUIRED).isDisplayed())
                .otherwise(Ensure.that(CommonsUI.THIS_FIELD_IS_REQUIRED).text().isEqualTo("Este campo es obligatorio")));
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
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(),env.getProperty("actor") );
        actor.attemptsTo(Visualize.bankAccountInformation(user.getBankInformation()));
    }

    @And("{actor} should see the bank account information updated")
    public void heShouldSeeTheBankAccountInformationUpdated(Actor actor, DataTable updatedInfo) {
        BankInformation bankInformation = Convert.dataTableToBankAccountInfo(updatedInfo);
        actor.attemptsTo(
                Visualize.bankAccountInformation(bankInformation)
        );
    }
}
