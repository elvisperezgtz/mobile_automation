package femsa.stepdefinitions;

import femsa.tasks.Complete;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class IntroWalletSteps {
    @When("{actor} performs the Wallet intro")
    public void hePerformsTheWalletIntro(Actor actor) {
        actor.attemptsTo(
                Complete.theWalletIntroTutorial()
        );
    }

    @Then("he should see the app home")
    public void heShouldSeeTheAppHome() {

    }
}
