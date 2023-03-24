package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.User;
import femsa.tasks.Navigate;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class EditPersonalInformationSteps {
    @When("{actor} enters in the personal data option")
    public void heEntersInThePersonalDataOption(Actor actor) {
        actor.attemptsTo(Navigate.toThePersonalInformationScreen());
    }

    @Then("{actor} should see his personal data registered")
    public void elvisShouldSeeHisPersonalDataRegistered( Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.ELVIS.getName());
        actor.attemptsTo(
                Visualize.hisPersonalInformation(user)
        );
    }
}
