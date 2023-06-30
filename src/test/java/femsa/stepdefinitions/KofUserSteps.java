package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.Credentials;
import femsa.models.User;
import femsa.tasks.Login;
import femsa.tasks.Navigate;
import femsa.utils.Decoder;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import java.io.IOException;

public class KofUserSteps {
    @Then("{actor} should see the personal data of the KOF profile correctly")
    public void heShouldSeeThePersonalDataOfTheKOFProfileCorrectly(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.KOF.getName());
        //assert user != null;
        actor.attemptsTo(
                Visualize.thePersonalInformationUser(user)
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

    @And("{actor} logs in as a kof user")
    public void heLogsInAsAKofUser(Actor actor) throws IOException {
        Credentials credentials = JsonTemplate.fromJsonToCredential("kof_code", "kof_user");
        actor.attemptsTo(
                Login.whit()
                        .username(credentials.getUsername())
                        .andPassword(Decoder.decode(credentials.getPassword()))
                        .andClickLoginButton(true)
        );
    }

    @When("{actor} enter the Collection screen")
    public void heEnterTheCollectionScreen(Actor actor) {
        actor.attemptsTo(Navigate.toTheCollectionScreen());
    }

    @Then("{actor} should see the order field for KOF users")
    public void heShouldSeeTheOrderFieldForKOFUsers(Actor actor) {

    }

    @And("{actor} enters an alphanumeric text in the purchase order field")
    public void heEntersAnAlphanumericTextInThePurchaseOrderField(Actor actor) {
    }

    @Then("{actor} verifies that the text has been inserted")
    public void heVerifiesThatTheTextHasBeenInserted(Actor actor) {
    }

    @And("{actor} makes a charge without entering a purchase order")
    public void heMakesAChargeWithoutEnteringAPurchaseOrder(Actor actor) {
    }

    @Then("{actor} displays the page looking for the device")
    public void heDisplaysThePageLookingForTheDevice(Actor actor) {
    }
}
