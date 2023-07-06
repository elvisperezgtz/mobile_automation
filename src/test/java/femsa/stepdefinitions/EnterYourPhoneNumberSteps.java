package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.enums.JsonPath;
import femsa.interactions.Hide;
import femsa.models.User;
import femsa.tasks.FillOutTheFormEnterYourPhoneNumber;
import femsa.user_interfaces.EnterYourPhoneNumberUI;
import femsa.utils.jsons.JsonTemplate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Enabled;

import static femsa.user_interfaces.EnterYourPhoneNumberUI.SEND_CODE;
import static femsa.user_interfaces.EnterYourPhoneNumberUI.HELP_TITLE;
import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static java.time.Duration.ofSeconds;

public class EnterYourPhoneNumberSteps {
    @When("{actor} tries to start his registration without accepting terms and conditions")
    public void heTriesToStartHisRegistrationWithoutAcceptingTermsAndConditions(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(user.getPhoneNumber()),
                Hide.theKeyboard()

        );
    }

    @Then("{actor} should see Send code button disabled")
    public void heShouldSeeSendCodeButtonDisabled(Actor actor) {
        actor.attemptsTo(Ensure.that(SEND_CODE).attribute("enabled").asABoolean().isEqualTo(false));
    }

    @When("{actor} tries to start his registration accepting terms and conditions")
    public void heTriesToStartHisRegistrationAcceptingTermsAndConditions(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(user.getPhoneNumber())
                        .acceptTermsAndCondition(true)
        );
    }

    @Then("{actor} should see Send code button enabled")
    public void heShouldSeeSendCodeButtonEnabled(Actor actor) {
        boolean isEnable = Enabled.of(SEND_CODE).answeredBy(actor);
        actor.attemptsTo(
                Ensure.that(Enabled.of(SEND_CODE).answeredBy(actor)).isEqualTo(true)
        );
    }

    @When("{actor} tries to start his registration with a phone number previously registered")
    public void heTriesToStartHisRegistrationWithAPhoneNumberPreviouslyRegistered(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber.
                        with()
                        .phoneNumber(user.getPhoneNumber())
                        .acceptTermsAndCondition(true)
                        .clickOnSendCode(true)
        );
    }

    @Then("{actor} should see the message: This number cannot be registered")
    public void heShouldSeeTheMessageThisNumberCannotBeRegistered(Actor actor) {
        actor.attemptsTo(Ensure.that(EnterYourPhoneNumberUI.THIS_NUMBER_CANNOT_BE_REGISTERED).text().isEqualTo("No se puede registrar este número"));
    }

    @When("{actor} accesses help")
    public void heAccessesHelp(Actor actor) {
        actor.attemptsTo(Click.on(BEGIN_REGISTRATION),
                Click.on(EnterYourPhoneNumberUI.HELP));
    }

    @Then("{actor} should see the screen: How to use my SPIN PRO charging device")
    public void heShouldSeeTheScreenHowToUseMySPINPROChargingDevice(Actor actor) {
        actor.attemptsTo(Ensure.that(HELP_TITLE.waitingForNoMoreThan(ofSeconds(10))).isDisplayed());
    }

    @When("{actor} registers a valid phone number")
    public void heRegistersAValidPhoneNumber(Actor actor) {
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .acceptTermsAndCondition(true)
                        .clickOnSendCode(true)
        );
    }

    @Then("{actor} should see the screen: Enter your code")
    public void heShouldSeeTheScreenEnterYourCode(Actor actor) {
        actor.attemptsTo(Visualize.theEnterYourCodeScreen());
    }
}
