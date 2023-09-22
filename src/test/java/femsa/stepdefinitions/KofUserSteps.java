package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.interactions.Hide;
import femsa.interactions.Write;
import femsa.models.Credentials;
import femsa.models.User;
import femsa.tasks.Complete;
import femsa.tasks.Login;
import femsa.tasks.Navigate;
import femsa.utils.Decoder;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static femsa.user_interfaces.CollectionUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class KofUserSteps {
    @Then("{actor} should see the personal data of the KOF profile correctly")
    public void heShouldSeeThePersonalDataOfTheKOFProfileCorrectly(Actor actor) {
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), CredentialsName.KOF.getName());
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
        actor.attemptsTo(Complete.theKnowYourAppTutorial());
    }

    @When("{actor} enter the Collection screen")
    public void heEnterTheCollectionScreen(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheCollectionScreen()
        );
    }

    @Then("{actor} should see the order field for KOF users")
    public void heShouldSeeTheOrderFieldForKOFUsers(Actor actor) {
        actor.attemptsTo(
                Visualize.thePurchaseOrderFieldName()
        );
    }

    @And("{actor} enters an alphanumeric text in the purchase order field")
    public void heEntersAnAlphanumericTextInThePurchaseOrderField(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PURCHASE_ORDER_BUTTON, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(PURCHASE_ORDER_BUTTON),
                WaitUntil.the(PURCHASE_ORDER_TEXTEDIT, isVisible()).forNoMoreThan(ofSeconds(15)),
                Enter.theValue("Esta es un orden de compra con 50 caracteres 4lfaN").into(PURCHASE_ORDER_TEXTEDIT),
                Click.on(SAVE_PURCHASE_ORDER)
        );
    }

    @Then("{actor} verifies that the text has been inserted")
    public void heVerifiesThatTheTextHasBeenInserted(Actor actor) {
        actor.attemptsTo(
                Visualize.theTextInsidePurchaseOrderField()
        );
    }

    @And("{actor} makes a charge without entering a purchase order")
    public void heMakesAChargeWithoutEnteringAPurchaseOrder(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(ENTER_AMOUNT_TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Write.withNativeKeyboard("20000"),
                Hide.theKeyboard()
        );
    }

    @Then("{actor} sees that the Collect button is enabled")
    public void heSeesThatTheCollectButtonIsEnabled(Actor actor) {
        actor.attemptsTo(
                Visualize.theCollectionButtonEnabled()
        );
    }
}
