package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.CredentialsName;
import femsa.enums.JsonPath;
import femsa.models.Credentials;
import femsa.models.User;
import femsa.user_interfaces.HomeUI;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
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

    @Then("{actor} should be able to see your registered phone number")
    public void heShouldBeAbleToSeeYourRegisteredPhoneNumber(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(
                Visualize.thePersonalInformationUserKOF(user)
        );
    }
}
