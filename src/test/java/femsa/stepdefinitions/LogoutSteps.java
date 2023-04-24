package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.tasks.Logout;
import femsa.user_interfaces.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.ProfileUI.LOGOUT;

public class LogoutSteps {

    @When("{actor} logout from the app")
    public void heLogoutFromTheApp(Actor actor) {
        actor.attemptsTo(Logout.fromTheApp());
    }

    @When("{actor} logs out of the app and try to go back to the previous session.")
    public void heLogsOutOfTheAppAndTryToGoBackToThePreviousSession(Actor actor) {
        actor.attemptsTo(
                Logout.fromTheApp(),
                Visualize.loginScreen(),
                Click.on(LoginUI.BACK)
        );
    }

    @Then("{actor} should see the screen Register in three steps")
    public void heShouldSeeTheScreenRegisterInThreeSteps(Actor actor) {
        actor.attemptsTo(
                Visualize.registerInThreeStepsScreen()
        );
    }

    @And("{actor} wants to close the active session")
    public void heWantsToCloseTheActiveSession(Actor actor) {
        actor.attemptsTo(Click.on(LOGOUT));
    }

    @Then("{actor} should see the Do you want to logout modal")
    public void heShouldSeeTheDoYouWantToLogoutModal(Actor actor) {
        actor.attemptsTo(Visualize.doYouWantLogOutModal());
    }
}
