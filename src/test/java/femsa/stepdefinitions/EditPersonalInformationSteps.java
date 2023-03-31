package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.User;
import femsa.tasks.Confirm;
import femsa.tasks.Navigate;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.EditPersonalInformationUI.EDIT;

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
        actor.attemptsTo(
                Visualize.thePersonalInformationFormInEditMode(user)
        );

    }
}
