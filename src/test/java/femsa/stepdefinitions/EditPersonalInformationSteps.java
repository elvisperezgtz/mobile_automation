package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.User;
import femsa.tasks.*;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static femsa.user_interfaces.EditPersonalInformationUI.*;
import static femsa.user_interfaces.ProfileUI.PROFILE_TITLE;
import static femsa.utils.Convert.dataTableToUser;
import static java.time.Duration.ofSeconds;

public class EditPersonalInformationSteps {
    @When("{actor} enters in the personal data option")
    public void heEntersInThePersonalDataOption(Actor actor) {
        actor.attemptsTo(Navigate.toThePersonalInformationScreen());
    }

    @Then("{actor} should see his personal data registered")
    public void elvisShouldSeeHisPersonalDataRegistered(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(
                Visualize.hisPersonalInformation(user)
        );
    }


    @And("{actor} wants to edit his personal information")
    public void heWantsToEditHisPersonalInformation(Actor actor) {
        actor.attemptsTo(
                Click.on(EDIT)
        );
    }

    @Then("{actor} should see a Confirm Password modal")
    public void heShouldSeeAConfirmPasswordModal(Actor actor) {
        actor.attemptsTo(
                Visualize.aConfirmPasswordModal()
        );
    }

    @And("{actor} tries to confirm the password with a wrong password {string}")
    public void heTriesToConfirmThePasswordWithAWrongPassword(Actor actor, String password) {
        actor.attemptsTo(
                Click.on(EDIT),
                Confirm.thePassword(password)
        );
    }

    @And("{actor} confirms his password")
    public void heConfirmsHisPassword(Actor actor) {
        actor.attemptsTo(
                Click.on(EDIT),
                Confirm.thePassword(actor.recall("password"))
        );
    }

    @Then("{actor} should see the personal information form in edit mode")
    public void heShouldSeeThePersonalInformationFormInEditMode(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(Visualize.thePersonalInformationFormInEditMode(user));
    }

    @And("{actor} edits his personal information")
    public void heEditsHisPersonalInformation(Actor actor, DataTable hisPersonalInformation) {
        actor.attemptsTo(Edit.personalInformation(dataTableToUser(hisPersonalInformation)));
    }

    @And("{actor} changes his email for {string}")
    public void heChangesHisEmailFor(Actor actor, String newEmail) {
        actor.attemptsTo(Edit.email(newEmail));
    }

    @Then("{actor} should see the error message {string} at the email field")
    public void heShouldSeeTheErrorMessageAtTheEmailField(Actor actor, String errorMessage) {
        actor.attemptsTo(Ensure.that(INVALID_EMAIL_FORMAT).text().isEqualTo(errorMessage));
    }

    @Then("{actor} should see the following message This email already has an account")
    public void heShouldSeeTheFollowingMessageThisEmailAlreadyHasAnAccount(Actor actor) {
        actor.attemptsTo(Ensure.that(THIS_EMAIL_ALREADY_HAS_AN_ACCOUNT).isDisplayed());
    }

    @Then("{actor} should see the following message: You have updated your data")
    public void heShouldSeeTheFollowingMessageYouHaveUpdatedYourData(Actor actor) {
        actor.attemptsTo(Ensure.that(YOU_HAVE_UPDATED_YOUR_DATA).isDisplayed());
    }

    @And("{actor} changes his personal information")
    public void heChangesHisPersonalInformation(Actor actor, DataTable hisPersonalInformation) {
        actor.attemptsTo(Edit.personalInformation(dataTableToUser(hisPersonalInformation)));
    }

    @And("{actor} saves changes")
    public void heSavesChanges(Actor actor) {
        actor.attemptsTo(Save.theEditedInformation());
    }

    @And("{actor} wants to cancel editing his personal information")
    public void heWantsToCancelEditingHisPersonalInformation(Actor actor) {
        actor.attemptsTo(Click.on(CANCEL.waitingForNoMoreThan(ofSeconds(10))));
    }

    @Then("{actor} should see the Do you want to go out? modal")
    public void heShouldSeeTheDoYouWantToGoOutModal(Actor actor) {
        actor.attemptsTo(Visualize.doYouWantToGoOutModal());
    }

    @And("{actor} declines save changes")
    public void heDeclinesSaveChanges(Actor actor) {
        actor.attemptsTo(Refuse.toSaveEditedData());
    }

    @Then("{actor} should see that there are not changes on his personal information")
    public void heShouldSeeThatThereAreNotChangesOnHisPersonalInformation(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(Visualize.hisPersonalInformation(user));
    }

    @Then("{actor} should see the composite logo with the text {string}")
    public void heShouldSeeTheCompositeLogoWithTheText(Actor actor, String logo) {
        actor.attemptsTo(Ensure.that(LOGO.waitingForNoMoreThan(ofSeconds(15))).text().isEqualTo(logo));
    }

    @And("{actor} returns to the profile screen")
    public void heReturnsToTheProfileScreen(Actor actor) {
        actor.attemptsTo(Click.on(BACK));
    }

    @And("{actor} should see the title {string} at the Profile screen")
    public void heShouldSeeTheTitleAtTheProfileScreen(Actor actor, String title) {
        actor.attemptsTo(Ensure.that(PROFILE_TITLE).text().isEqualTo(title));

    }
}
