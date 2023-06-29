package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.user_interfaces.HomeUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import java.time.Duration;

public class ProfileSteps {
    @And("{actor} enters in the Profile screen")
    public void heEntersInTheProfileScreen(Actor actor) {
        actor.attemptsTo(Click.on(HomeUI.PROFILE.waitingForNoMoreThan(Duration.ofSeconds(15))));
    }

    @Then("{actor} should see the Profile screen")
    public void heShouldSeeTheProfileScreen(Actor actor) {
        actor.attemptsTo(Visualize.theProfileScreen());
    }

    @Then("{actor} should see the login screen")
    public void heShouldSeeTheLoginScreen(Actor actor) {
        actor.attemptsTo(Visualize.loginScreen());
    }

}
