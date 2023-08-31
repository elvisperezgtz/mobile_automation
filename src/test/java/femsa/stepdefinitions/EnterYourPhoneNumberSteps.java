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

import java.util.Objects;

import static femsa.user_interfaces.EnterYourPhoneNumberUI.*;
import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static java.time.Duration.ofSeconds;

public class EnterYourPhoneNumberSteps {
    @When("{actor} tries to start his registration without accepting terms and conditions")
    public void heTriesToStartHisRegistrationWithoutAcceptingTermsAndConditions(Actor actor) {
        User user = actor.recall("user");
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(user.getPhoneNumber()),
                Hide.theKeyboard());
    }

    @Then("{actor} should see Send code button disabled")
    public void heShouldSeeSendCodeButtonDisabled(Actor actor) {
        actor.attemptsTo(Ensure.that(SEND_CODE).attribute("enabled").asABoolean().isEqualTo(false));
    }

    @When("{actor} tries to start his registration accepting terms and conditions")
    public void heTriesToStartHisRegistrationAcceptingTermsAndConditions(Actor actor) {
        User user = actor.recall("user");
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(user.getPhoneNumber())
                        .acceptTermsAndCondition(true));
    }

    @Then("{actor} should see Send code button enabled")
    public void heShouldSeeSendCodeButtonEnabled(Actor actor) {
        boolean isEnable = Enabled.of(SEND_CODE).answeredBy(actor);
        actor.attemptsTo(
                Ensure.that(Enabled.of(SEND_CODE).answeredBy(actor)).isEqualTo(true));
    }

    @When("{actor} tries to start his registration with a phone number previously registered")
    public void heTriesToStartHisRegistrationWithAPhoneNumberPreviouslyRegistered(Actor actor) {
        User user = actor.recall("user");
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber.with()
                        .phoneNumber(Objects.requireNonNull(user).getPhoneNumber())
                        .acceptTermsAndCondition(true));
    }

    @Then("{actor} should see the message: This number cannot be registered")
    public void heShouldSeeTheMessageThisNumberCannotBeRegistered(Actor actor) {
        actor.attemptsTo(
                Ensure.that(THIS_NUMBER_CANNOT_BE_REGISTERED).text().isEqualTo("No se puede registrar este número"));
    }

    @When("{actor} accesses help")
    public void heAccessesHelp(Actor actor) {
        actor.attemptsTo(
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
                        .acceptTermsAndCondition(true));
    }

    @Then("{actor} should see the screen: Enter your code")
    public void heShouldSeeTheScreenEnterYourCode(Actor actor) {
        actor.attemptsTo(Visualize.theEnterYourCodeScreen());
    }

    @Then("{actor} should the Enter your phone number screen with the same information")
    public void heShouldTheEnterYourPhoneNumberScreenWithTheSameInformation(Actor actor) {
        User user = actor.recall("user");
        String phoneNumber = EnterYourPhoneNumberUI.PHONE_NUMBER.resolveFor(actor).getText().trim().replaceAll(" ", "");
        actor.attemptsTo(Ensure.that(phoneNumber).isEqualTo(user.getPhoneNumber()));
    }

    @Then("{actor} should see the error message This number cannot be registered")
    public void heShouldSeeTheErrorMessageThisNumberCannotBeRegistered(Actor actor) {
        actor.attemptsTo(
                Ensure.that(THIS_NUMBER_CANNOT_BE_REGISTERED).text().isEqualTo("No se puede registrar este número")
        );
    }

    @When("{actor} enters his phone number, but decline to accept terms and conditions")
    public void heEntersHisPhoneNumberButDeclineToAcceptTermsAndConditions(Actor actor) {
        User user = actor.recall("user");
        actor.attemptsTo(
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(user.getPhoneNumber())
                        .acceptTermsAndCondition(false));
    }

    @Then("{actor} should see the Send code button disable")
    public void heShouldSeeTheSendCodeButtonDisable(Actor actor) {
        actor.attemptsTo(Ensure.that(SEND_CODE).attribute("enabled").asABoolean().isEqualTo(false));
    }

    @When("{actor} does not enter his phone number, but accept terms and conditions")
    public void heDoesNotEnterHisPhoneNumberButAcceptTermsAndConditions(Actor actor) {
        actor.attemptsTo(
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .emptyPhoneNumber()
                        .acceptTermsAndCondition(true));
    }
}
