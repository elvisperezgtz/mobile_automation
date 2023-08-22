package femsa.stepdefinitions;

import femsa.tasks.Complete;
import femsa.user_interfaces.HomeUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

public class IntroWalletSteps {
    @When("{actor} performs the Wallet intro")
    public void hePerformsTheWalletIntro(Actor actor) {
        actor.attemptsTo(
                Complete.theWalletIntroTutorial()
        );
    }

    @Then("{actor} should see the app home")
    public void heShouldSeeTheAppHome(Actor actor) {
        actor.attemptsTo(Ensure.that(HomeUI.HOME).isDisplayed());
    }
}
