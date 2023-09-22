package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.JsonPath;
import femsa.models.BankInformation;
import femsa.models.User;
import femsa.tasks.Edit;
import femsa.tasks.EditBankAccountInformation;
import femsa.tasks.Navigate;
import femsa.tasks.Save;
import femsa.user_interfaces.CommonsUI;
import femsa.user_interfaces.EditBankAccountUI;
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

import java.util.ArrayList;
import java.util.List;

import static femsa.user_interfaces.EditBankAccountUI.*;

public class EditBankAccountInformationSteps {


    @When("{actor} enters in the bank account information option")
    public void heEntersInTheBankAccountInformationOption(Actor actor) {
        actor.attemptsTo(Navigate.toBankAccountInformationScreen());
    }

    @Then("{actor} should see his Bank account information registered")
    public void elvisShouldSeeHisBankAccountInformationRegistered(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(
                Visualize.bankAccountInformation(user.getBankInformation())
        );
    }

    @Then("{actor} should see the bank account information form in edit mode")
    public void heShouldSeeTheBankAccountInformationFormInEditMode(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(Visualize.bankAccountInformationInEditMode(user));
    }

    @And("{actor} edits his interbank CLABE information with {string}")
    public void heEditsHisInterbankCLABEInformationWith(Actor actor, String clabe) {
        actor.attemptsTo(Edit.theClabe(clabe));
    }

    @Then("{actor} should see the message The CLABE must have 18 digits")
    public void heShouldSeeTheMessageTheCLABEMustHave18Digits(Actor actor) {
        actor.attemptsTo(
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
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(Visualize.bankAccountInformation(user.getBankInformation()));
    }

    @And("{actor} should see the bank account information updated")
    public void heShouldSeeTheBankAccountInformationUpdated(Actor actor, DataTable updatedInfo) {
        BankInformation bankInformation = Convert.dataTableToBankAccountInfo(updatedInfo);
        actor.attemptsTo(
                Visualize.bankAccountInformation(bankInformation)
        );
    }

    @And("{actor} should see the Save button disabled")
    public void heShouldSeeTheSaveButtonDisabled(Actor actor) {
        actor.attemptsTo(
                Ensure.that(CommonsUI.SAVE).attribute("enabled").asABoolean().isEqualTo(false)
        );
    }

    @Then("{actor} should see the Save button enabled")
    public void heShouldSeeTheSaveButtonEnabled(Actor actor) {
        actor.attemptsTo(
                Ensure.that(CommonsUI.SAVE).attribute("enabled").asABoolean().isEqualTo(true)
        );
    }

    @When("{actor} edits his bank account information three times")
    public void heEditsHisBankAccountInformationThreeTimes(Actor actor, DataTable bankAccountInformation) {
        List<List<String>> rows = bankAccountInformation.asLists(String.class);
        List<BankInformation> bankInformationList = new ArrayList<>();

        for (List<String> columns : rows) {
            bankInformationList.add(new BankInformation(columns.get(1), columns.get(0)));
        }

        actor.attemptsTo(Navigate.toBankAccountInformationScreen());
        for (BankInformation bankInformation : bankInformationList) {
            actor.attemptsTo(Edit.theBankAccountInformationForm(bankInformation.getClabe(), bankInformation.getAccountHolder()));
            actor.attemptsTo(Save.theEditedInformation());
        }
    }

    @And("{actor} changes his account holder name for {string}")
    public void heChangesHisAccountHolderNameFor(Actor actor, String holder) {
        actor.attemptsTo(
                EditBankAccountInformation
                        .with()
                        .confirmPasswordFirst()
                        .changingTheHolderFor(holder)
                        .withoutChangingTheClabe()
                        .saveChanges(true)
        );
    }

    @And("{actor} changes his interbank Clabe for {string}")
    public void heChangesHisInterbankClabeFor(Actor actor, String newClabe) {
        actor.attemptsTo(
                EditBankAccountInformation
                        .with()
                        .confirmPasswordFirst()
                        .changingTheClabeFor(newClabe)
                        .withoutChangingTheHolder()
                        .saveChanges(true)
                        .confirmSaveChanges(true)
        );
        actor.remember("newClabe", newClabe);
    }

    @Then("{actor} should see that the changes were applied")
    public void heShouldSeeThatTheChangesWereApplied(Actor actor) {
        actor.attemptsTo(
                Ensure.that(ACCOUNT_HOLDER).text().isEqualTo(actor.recall("holder")),
                Ensure.that(CLABE).text().isEqualTo(actor.recall("clabe"))
        );

    }

    @And("{actor} changes the account holder for {string} and the interbank CLABE for {string}")
    public void heChangesTheAccountHolderForAndTheInterbankCLABEFor(Actor actor, String holder, String clabe) {
        actor.attemptsTo(
                EditBankAccountInformation
                        .with()
                        .confirmPasswordFirst()
                        .changingTheHolderFor(holder)
                        .changingTheClabeFor(clabe)
                        .saveChanges(true)
                        .confirmSaveChanges(true)
        );
        actor.remember("holder", holder);
        actor.remember("clabe", clabe);
    }

    @Then("{actor} should see that the changes on the interbank CLABE were applied")
    public void heShouldSeeThatTheChangesOnTheInterbankCLABEWereApplied(Actor actor) {
        actor.attemptsTo(Ensure.that(EditBankAccountUI.CLABE).text().isEqualTo(actor.recall("newClabe")));
    }

    @And("{actor} does not make any changes on his bank account information")
    public void heDoesNotMakeAnyChangesOnHisBankAccountInformation(Actor actor) {
        actor.attemptsTo(
                EditBankAccountInformation
                        .with()
                        .confirmPasswordFirst()
                        .withoutChangingTheHolder()
                        .withoutChangingTheClabe()
                        .saveChanges(true)
        );
    }

    @And("{actor} enters the same bank account information")
    public void heEntersTheSameBankAccountInformation(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(
                EditBankAccountInformation
                        .with()
                        .confirmPasswordFirst()
                        .changingTheHolderFor(user.getBankInformation().getAccountHolder())
                        .changingTheClabeFor(user.getBankInformation().getClabe())
                        .saveChanges(true)
        );
    }

    @Then("{actor} should see that the save confirmation modal is not displayed")
    public void heShouldSeeThatTheSaveConfirmationModalIsNotDisplayed(Actor actor) {
        actor.attemptsTo(Ensure.that(CommonsUI.CONTINUE).isNotDisplayed());
    }
}
