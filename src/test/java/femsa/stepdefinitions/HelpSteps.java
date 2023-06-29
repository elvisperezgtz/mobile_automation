package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.user_interfaces.ProfileUI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

public class HelpSteps {

    @When("{actor} enters to the Help module")
    public void heEntersToTheHelpModule(Actor actor) {
        actor.attemptsTo(Click.on(ProfileUI.HELP));
    }

    @Then("{actor} should see the Frequently Asked Questions")
    public void heShouldSeeTheFrequentlyAskedQuestions(Actor actor) {
        actor.attemptsTo(Visualize.theHelpScreen());
    }

}
