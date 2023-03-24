package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.models.Credential;
import femsa.tasks.Fill;
import femsa.tasks.Login;
import femsa.utils.Decoder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.io.IOException;

import static femsa.user_interfaces.LoginUI.*;
import static femsa.user_interfaces.RegisterInThreeStepsUI.ALREADY_HAVE_ACCOUNT;
import static femsa.utils.jsons.JsonTemplate.fromJsonToCredential;
import static java.time.Duration.ofSeconds;

public class LoginSteps {

    @Then("{actor} should see the message {string}")
    public void heShouldSeeTheMessage(Actor actor, String message) {
        actor.attemptsTo(
                Ensure.that(LOGGING_IN.waitingForNoMoreThan(ofSeconds(10))).text().isEqualTo(message)
        );
    }

    @When("{actor} logs in by {string} with his {string}")
    public void heLogsInByWithHis(Actor actor, String loginType, String credentialName) throws IOException {
        Credential credential = fromJsonToCredential(loginType, credentialName);
        actor.attemptsTo(
                Login
                        .whit()
                        .username(credential.getUsername())
                        .andPassword(Decoder.decode(credential.getPassword()))
        );
    }

    @When("{actor} wants to login")
    public void heWantsToLogin(Actor actor) {
        actor.attemptsTo(Click.on(ALREADY_HAVE_ACCOUNT));
    }

    @And("{actor} wants to go back")
    public void heWantsToGoBack(Actor actor) {
        actor.attemptsTo(Click.on(BACK));
    }

    @Then("{actor} should be able to see the Register in three steps screen")
    public void heShouldBeAbleToSeeTheRegisterInThreeStepsScreen(Actor actor) {
        actor.attemptsTo(
                Visualize.registerInThreeStepsScreen()
        );
    }

    @Then("{actor} should see the alert {string}")
    public void heShouldSeeTheAlert(Actor actor, String alert) {
        actor.attemptsTo(
                Ensure.that(ALERT).text().isEqualTo(alert)
        );
    }

    @When("{actor} enters a empty password")
    public void heEntersAEmptyPassword(Actor actor) throws IOException {
        actor.attemptsTo(
                Fill.inTheLoginFormWithoutPassword()
        );
    }

    @When("{actor} enters a empty email or phone number")
    public void heEntersAEmptyEmailOrPhoneNumber(Actor actor) throws IOException {
        actor.attemptsTo(
              Fill.inTheLoginFormWithoutEmailOrPhoneNumber()
        );
    }

    @When("{actor} wants to recover his password")
    public void heWantsToRecoverHisPassword(Actor actor) {
        actor.attemptsTo(
                Click.on(ALREADY_HAVE_ACCOUNT),
                Click.on(FORGOT_PASSWORD)
        );
    }

    @Then("{actor} should see the Reset password screen")
    public void heShouldSeeTheResetPasswordScreen(Actor actor) {
        actor.attemptsTo(Visualize.resetPasswordScreen());
    }

    @And("{actor} is logged in to the app by {string} with his {string}")
    public void elvisIsLoggedInToTheAppByWithHis(Actor actor, String loginType, String credentialName) throws IOException {
        Credential credential = fromJsonToCredential(loginType, credentialName);
        actor.attemptsTo(
                Login
                        .whit()
                        .username(credential.getUsername())
                        .andPassword(Decoder.decode(credential.getPassword()))
        );
    }
}
