package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.JsonPath;
import femsa.models.Credentials;
import femsa.models.User;
import femsa.tasks.Complete;
import femsa.tasks.Fill;
import femsa.tasks.Login;
import femsa.user_interfaces.HomeUI;
import femsa.user_interfaces.KnowYourAppUI;
import femsa.utils.Convert;
import femsa.utils.Decoder;
import femsa.utils.Validate;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;
import java.time.Duration;

import static femsa.user_interfaces.KnowYourAppUI.KNOW_YOUR_APP_TITLE;
import static femsa.user_interfaces.LoginUI.*;
import static femsa.user_interfaces.RegisterInThreeStepsUI.ALREADY_HAVE_ACCOUNT;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSteps {

    @Then("{actor} should see the message {string}")
    public void heShouldSeeTheMessage(Actor actor, String message) {
        actor.attemptsTo(
                Ensure.that(LOGGING_IN.waitingForNoMoreThan(ofSeconds(10))).text().isEqualTo(message)
        );
    }

    @When("{actor} logs in by {string} with his {string}")
    public void heLogsInByWithHis(Actor actor, String loginType, String credentialName) throws IOException {

        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        Credentials credentials = user.getCredentials();

        actor.attemptsTo(
                Login
                        .whit()
                        .username(credentials.getUsername())
                        .andPassword(Decoder.decode(credentials.getPassword()))
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
    public void heEntersAEmptyPassword(Actor actor, DataTable credentialTable) throws IOException {
        Credentials credentials = Convert.dataTableToCredentials(credentialTable);
        actor.attemptsTo(
                Fill.inTheLoginFormWithoutPassword(credentials)

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

    @Then("{actor} should see the message: Logging in")
    public void heShouldSeeTheMessageLoggingIn(Actor actor) {
        actor.attemptsTo(
                Check.whether(Validate.isAndroid())
                        .andIfSo(Ensure.that(HomeUI.HOME.waitingForNoMoreThan(Duration.ofSeconds(10))).isDisplayed())
                        .otherwise(Ensure.that(HomeUI.HOME.waitingForNoMoreThan(ofSeconds(10))).isDisplayed()));

    }

    @Then("{actor} should see the message: Wrong Data")
    public void heShouldSeeTheMessageWrongData(Actor actor) {
        actor.attemptsTo(
                Ensure.that(WRONG_DATA).text().isEqualTo("Datos incorrectos")
        );
    }

    @When("{actor} logs in by {string}")
    public void heLogsInBy(Actor actor, String loginType) throws IOException {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        Credentials credentials = JsonTemplate.fromJsonToCredential(loginType, env.getProperty("actor"));
        actor.attemptsTo(
                Login.whit()
                        .username(credentials.getUsername())
                        .andPassword(Decoder.decode(credentials.getPassword()))
                        .andClickLoginButton(true)
        );
        actor.remember("password", Decoder.decode(credentials.getPassword()));
        actor.attemptsTo(
                Check.whether(KNOW_YOUR_APP_TITLE.waitingForNoMoreThan(ofSeconds(10)).resolveFor(theActorInTheSpotlight()).isDisplayed())
                        .andIfSo(Complete.theKnowYourAppTutorial())
        );
    }


    @When("{actor} tries to log in with credentials")
    public void heTriesToLogInByWithCredentials(Actor actor, DataTable credentialTable) {
        Credentials credentials = Convert.dataTableToCredentials(credentialTable);
        actor.attemptsTo(
                Login.whit()
                        .username(credentials.getUsername())
                        .andPassword(Decoder.decode(credentials.getPassword()))
                        .andClickLoginButton(true)
        );
    }


}
