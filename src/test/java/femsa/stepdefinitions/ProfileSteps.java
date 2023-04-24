package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.tasks.*;
import femsa.user_interfaces.HomeUI;
import femsa.user_interfaces.ProfileUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static femsa.user_interfaces.ProfileUI.PREGUNTAS_FRECUENTES;
import static femsa.user_interfaces.ClabeInterbancariaUI.*;
import static femsa.user_interfaces.ConfirmPasswordModalUI.CONFIRMA_TU_CONTRASENIA;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
