package femsa.stepdefinitions;


import femsa.asserts.Visualize;
import femsa.enums.JsonPath;
import femsa.models.User;
import femsa.tasks.Complete;
import femsa.tasks.EnterTheVerificationCode;
import femsa.tasks.FillOutTheFormEnterYourPhoneNumber;
import femsa.utils.jsons.JsonTemplate;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

import java.time.Duration;
import java.util.Objects;

import static femsa.user_interfaces.EnterYourPhoneNumberUI.SEND_CODE;
import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OnBoardingSteps {

    private EnvironmentVariables env;
    @Managed(driver = "appium")
    private AppiumDriver driver;


    @Given("{actor} Perform the introductory tutorial")
    public void elvisPerformTheIntroductoryTutorial(Actor actor) {
        actor.remember("env", EnvironmentSpecificConfiguration.from(env));
        actor.attemptsTo(
                Complete.theIntroductoryTutorial(),
                WaitUntil.the(BEGIN_REGISTRATION, isVisible()).forNoMoreThan(ofSeconds(30))
        );

    }


    @Then("{actor} should see the home page of the app")
    public void heShouldSeeTheHomePageOfTheApp(Actor actor) {
        actor.attemptsTo(
                Ensure.that(SEND_CODE).attribute("clickable").isEqualTo("false")
        );
    }

    @And("{actor} wants to start his on boarding")
    public void heWantsToStartHisOnBoarding(Actor actor) {
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION)
        );
    }

    @When("{actor} enter his phone number and accepts terms and conditions")
    public void heEnterHisPhoneNumberAndAcceptsTermsAndConditions(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(Objects.requireNonNull(user).getPhoneNumber())
                        .acceptTermsAndCondition(true)
        );
    }

    @Then("{actor} should see the Send code button enabled")
    public void heShouldSeeTheSendCodeButtonEnabled(Actor actor) {
        actor.attemptsTo(Ensure.that(SEND_CODE.waitingForNoMoreThan(Duration.ofSeconds(15))).isEnabled());
    }

    @And("{actor} enters his verification code")
    public void heEntersHisVerificationCode(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));

        actor.attemptsTo(
                EnterTheVerificationCode
                        .with()
//                        .phoneNumber("0000000000")
                        .phoneNumber(Objects.requireNonNull(user).getPhoneNumber())
        );

    }

    @And("{actor} enters and validates his phone number")
    public void heEntersAndValidatesHisPhoneNumber(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));

        actor.attemptsTo(
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(Objects.requireNonNull(user).getPhoneNumber())
                        .acceptTermsAndCondition(true),
                Click.on(SEND_CODE),
                EnterTheVerificationCode
                        .with()
                        .phoneNumber(Objects.requireNonNull(user).getPhoneNumber())
        );
    }

    @And("{actor} wants a verification code")
    public void heWantsAVerificationCode(Actor actor) {
        actor.attemptsTo(Click.on(SEND_CODE));
    }

    @Then("{actor} should see the Enter Your Code screen")
    public void heShouldSeeTheEnterYourCodeScreen(Actor actor) {
        actor.attemptsTo(Visualize.theEnterYourCodeScreen());
    }

    @And("{actor} should see the Create your password screen")
    public void heShouldSeeTheCreateYourPasswordScreen(Actor actor) {
        actor.attemptsTo(Visualize.theCreateYourPasswordScreen());
    }
}
