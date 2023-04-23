package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.MerchantInfo;
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
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;

import static femsa.user_interfaces.CommonsUI.EDIT;
import static femsa.user_interfaces.EditBusinessDataUI.REQUIRED_FIELD;
import static femsa.user_interfaces.EditBusinessDataUI.WRONG_POSTAL_CODE;
import static femsa.user_interfaces.HomeUI.BUSINESS_NAME;

public class EditBusinessInformationSteps {

    @When("{actor} enters in the Business data option")
    public void heEntersInTheBusinessDataOption(Actor actor) {
        actor.attemptsTo(Navigate.toTheBusinessInformationScreen());
    }

    @Then("{actor} should see his Business information registered")
    public void heShouldSeeHisBusinessInformationRegistered(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(Visualize.hisBusinessInformation(user.getMerchantInfo()));

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

    @And("{actor} changes his postal code for {string}")
    public void heChangesHisPostalCodeFor(Actor actor, String postalCode) {
        actor.attemptsTo(Edit.postalCode(postalCode));
    }

    @Then("{actor} should see the following message: Wrong postal code")
    public void heShouldSeeTheFollowingMessageWrongPostalCode(Actor actor) {
        actor.attemptsTo(
                Check.whether(Validate.isAndroid()).andIfSo(Ensure.that(WRONG_POSTAL_CODE).isDisplayed())
                        .otherwise(Ensure.that(WRONG_POSTAL_CODE).text().isEqualTo("Este código postal es incorrecto")));
    }

    @And("{actor} changes his business information")
    public void heChangesHisBusinessInformation(Actor actor, DataTable businessInformation) {
        MerchantInfo merchantInfo = Convert.dataTableToMerchantInfo(businessInformation);
        actor.attemptsTo(Edit.businessInformation(merchantInfo));
    }

    @And("{actor} edits his business information")
    public void heEditsHisBusinessInformation(Actor actor, DataTable businessInformation) {
        MerchantInfo merchantInfo = Convert.dataTableToMerchantInfo(businessInformation);
        actor.attemptsTo(Edit.businessInformation(merchantInfo));
    }

    @Then("{actor} should see that there are not changes on his business information")
    public void heShouldSeeThatThereAreNotChangesOnHisBusinessInformation(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        Visualize.hisBusinessInformation(user.getMerchantInfo());
    }

    @And("{actor} returns to the home screen")
    public void heReturnsToTheHomeScreen(Actor actor) {
        actor.attemptsTo(Navigate.fromEditBusinessInformationToHome());
    }

    @Then("{actor} should see the title {string} at the Home screen")
    public void heShouldSeeTheTitleAtTheHomeScreen(Actor actor, String merchantTitle) {
        actor.attemptsTo(Ensure.that(BUSINESS_NAME).text().isEqualTo(merchantTitle));
    }

    @And("{actor} tries to save the changes")
    public void heTriesToSaveTheChanges(Actor actor) {
        actor.attemptsTo(
                Check.whether(Validate.isAndroid())
                        .andIfSo(Click.on(CommonsUI.SAVE)));
    }

    @Then("{actor} should see the following message: Required field")
    public void heShouldSeeTheFollowingMessageRequiredField(Actor actor) {
        actor.attemptsTo(
                Check.whether(Validate.isAndroid())
                        .andIfSo(Ensure.that(REQUIRED_FIELD).isDisplayed())
                        .otherwise(Ensure.that(REQUIRED_FIELD).text().isEqualTo("Campo obligatorio"))
        );
    }

    @Then("{actor} should see his Business information updated")
    public void heShouldSeeHisBusinessInformationUpdated(Actor actor, DataTable dataTable) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(Visualize.hisBusinessInformation(user.getMerchantInfo()));
    }
}
