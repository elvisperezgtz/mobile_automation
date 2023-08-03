package femsa.stepdefinitions;


import femsa.asserts.Visualize;
import femsa.enums.JsonPath;
import femsa.models.User;
import femsa.tasks.*;
import femsa.user_interfaces.YouAreAlmostDoneUI;
import femsa.utils.StringGenerator;
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

    @And("{actor} enters and validates a secure password")
    public void heEntersAndValidatesASecurePassword(Actor actor) {
        actor.remember("Password", StringGenerator.buildPassword(4, 1, 3, 0));
        actor.attemptsTo(
                CompleteTheCreateYouPassword
                        .with()
                        .password(actor.recall("Password"))
                        .passwordDisplayButton(true)
                        .continueButton(true)
        );
    }

    @Then("{actor} should see the We want to meet you screen")
    public void heShouldSeeTheWeWantToMeetYouScreen(Actor actor) {
        actor.attemptsTo(Visualize.theWeWantToMeetYouScreen());
    }

    @And("{actor} enters and completes the form with his personal and business data")
    public void heEntersAndCompletesTheFormWithHisPersonalAndBusinessData(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
    }

    @Then("{actor} should see the Already have your device screen")
    public void heShouldSeeTheAlreadyHaveYourDeviceScreen(Actor actor) {
        actor.attemptsTo(Visualize.theAlreadyHaveYourDeviceScreen());
    }

    @And("{actor} wants to skip the linking device processes")
    public void heWantsToSkipTheLinkingDeviceProcesses(Actor actor) {
        actor.attemptsTo(Skip.linkingDeviceProcess());
    }

    @And("{actor} adds his bank account information")
    public void heAddsHisBankAccountInformation(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        assert user != null;
        actor.attemptsTo(
                Add
                        .bankAccountInformationWith()
                        .holder(user.getBankInformation().getAccountHolder())
                        .interbankClabe(user.getBankInformation().getClabe())
                        .andContinueSaving(true)
        );
    }

    @Then("{actor} should see the You are almost done screen")
    public void heShouldSeeTheYouAreAlmostDoneScreen(Actor actor) {
        actor.attemptsTo(Visualize.theYouAreAlmostDoneScreen());
    }

    @Then("{actor} should see the Add your bank account screen")
    public void heShouldSeeTheAddYourBankAccountScreen(Actor actor) {
        actor.attemptsTo(Visualize.theAddYourBankAccountScreen());
    }

    @When("{actor} starts his on boarding process with the required information skipping pairing device process")
    public void heStartsHisOnBoardingProcessWithTheRequiredInformationSkippingPairingDeviceProcess(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
       actor.attemptsTo(StartOnBoarding.withHisInformation(user));

    }

    @And("{actor} finish the on boarding process")
    public void heFinishTheOnBoardingProcess(Actor actor) {
        actor.attemptsTo(
                Click.on(YouAreAlmostDoneUI.GOT_IT)
        );
    }

    @Then("{actor} should see the Home screen")
    public void heShouldSeeTheHomeScreen(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        actor.attemptsTo(Visualize.theHomeScreen(user));
    }
    @Then("{actor} should see the continue button disabled")
    public void actorShouldSeeTheContinueButtonDisabled(Actor actor) {
        actor.attemptsTo(Visualize.theContinueButtonDisabledOnTheCreatePasswordScreen());
    }
    @And("{actor} enters an unsecured password of less than 8 characters \\({int} lowercase, {int} uppercase, {int} numbers and {int} special characters)")
    public void heEntersAnUnsecuredPasswordOfLessThanCharactersLowercaseUppercaseNumbersAndSpaceCharacters(Actor actor, int low, int upper, int nums, int spec) {
        actor.remember("Password", StringGenerator.buildPassword(low, upper, nums, spec));
        actor.attemptsTo(
                CompleteTheCreateYouPassword
                        .with()
                        .password(actor.recall("Password"))
                        .passwordDisplayButton(true)
                        .continueButton(false)
            );
    }
}
