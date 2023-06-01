package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.User;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

public class KofUserSteps {
    @Then("{actor} should see the personal data of the KOF profile correctly")
    public void heShouldSeeThePersonalDataOfTheKOFProfileCorrectly(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.KOF.getName());
        //assert user != null;
        actor.attemptsTo(
                Visualize.thePersonalInformationUserKOF(user)
        );
    }

    @Then("{actor} should not be able to edit personal data")
    public void heShouldNotBeAbleToEditPersonalData(Actor actor) {
        actor.attemptsTo(
                Visualize.theAbsenceOfTheEditButton()
        );

    }

    @Then("{actor} should not be able to access the business data")
    public void heShouldNotBeAbleToAccessTheBusinessData(Actor actor) {
        actor.attemptsTo(
                Visualize.theAbsenceOfTheBusinessButton()
        );

    }

    @Then("{actor} should not be able to access the CLABE button")
    public void heShouldNotBeAbleToAccessTheCLABEButton(Actor actor) {
        actor.attemptsTo(
                Visualize.theAbsenceOfTheCLABEButton()
        );
    }
}
