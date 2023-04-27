package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.tasks.FillOutTheFormEnterYourPhoneNumber;
import femsa.user_interfaces.EnterYourPhoneNumberUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Enabled;

import static femsa.user_interfaces.EnterYourPhoneNumberUI.CONTINUE;
import static femsa.user_interfaces.EnterYourPhoneNumberUI.HELP_TITLE;
import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static java.time.Duration.ofSeconds;

public class EnterYourPhoneNumberSteps {
    @When("{actor} tries to start his registration without accepting terms and conditions")
    public void heTriesToStartHisRegistrationWithoutAcceptingTermsAndConditions(Actor actor, DataTable table) {
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber("5521996723")

        );
    }

    @Then("{actor} should see Send code button disabled")
    public void heShouldSeeSendCodeButtonDisabled(Actor actor) {
        actor.attemptsTo(Ensure.that(CONTINUE).attribute("clickable").asABoolean().isEqualTo(false));
    }

    @When("{actor} tries to start his registration accepting terms and conditions")
    public void heTriesToStartHisRegistrationAcceptingTermsAndConditions(Actor actor, DataTable table) {

        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber("5521996723")
                        .termsAndCondition(true)
        );
    }

    @Then("{actor} should see Send code button enabled")
    public void heShouldSeeSendCodeButtonEnabled(Actor actor) {
        boolean isEnable = Enabled.of(CONTINUE).answeredBy(actor);
        actor.attemptsTo(
                Ensure.that(Enabled.of(CONTINUE).answeredBy(actor)).isEqualTo(true)
        );
    }

    @When("{actor} tries to start his registration with a phone number previously registered")
    public void heTriesToStartHisRegistrationWithAPhoneNumberPreviouslyRegistered(Actor actor, DataTable table) {
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber.
                        with()
                        .phoneNumber("5521996723")
                        .termsAndCondition(true)
                        .clickOnContinue(true)
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
                        .termsAndCondition(true)
                        .clickOnContinue(true)
        );
    }

    @Then("{actor} should see the screen: Enter your code")
    public void heShouldSeeTheScreenEnterYourCode(Actor actor) {
        actor.attemptsTo(Visualize.theEnterYourCodeScreen());
    }
}
