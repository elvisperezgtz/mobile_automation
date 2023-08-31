package femsa.stepdefinitions;


import femsa.asserts.Visualize;
import femsa.enums.JsonPath;
import femsa.interactions.Hide;
import femsa.interactions.Turn;
import femsa.models.User;
import femsa.tasks.*;
import femsa.user_interfaces.*;
import femsa.utils.StringGenerator;
import femsa.utils.Validate;
import femsa.utils.database.Read;
import femsa.utils.jsons.JsonTemplate;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Objects;

import static femsa.user_interfaces.EnterYourPhoneNumberUI.SEND_CODE;
import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static femsa.utils.PhoneNumberGenerator.generateNewPhoneNumberForTheActor;
import static java.lang.String.valueOf;
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

    @And("{actor} has the information for his registration")
    public void heHasTheInformationForHisRegistration(Actor actor) throws IOException {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        User user = JsonTemplate.getObjectFromJsonFile(JsonPath.USERS_DATA.getFilePath(), env.getProperty("actor"));
        String phoneNumber = valueOf(generateNewPhoneNumberForTheActor(env.getProperty("actor")));
        assert user != null;
        user.setNewPhoneNumber(phoneNumber);
        user.setEmail(phoneNumber.concat("@mail.com"));
        actor.remember("user", user);
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
    public void heEnterHisPhoneNumberAndAcceptsTermsAndConditions(Actor actor) throws IOException {
        User user = actor.recall("user");
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
    public void heEntersHisVerificationCode(Actor actor) throws SQLException {
        User user = actor.recall("user");
        actor.attemptsTo(
                EnterThe
                        .verificationCodeWith()
                        .verificationCode(Read.otpFromDataBase(user.getPhoneNumber()))
        );
    }

    @And("{actor} enters and validates his phone number")
    public void heEntersAndValidatesHisPhoneNumber(Actor actor) throws SQLException {
        User user = actor.recall("user");
        actor.attemptsTo(
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber(Objects.requireNonNull(user).getPhoneNumber())
                        .acceptTermsAndCondition(true),
                Click.on(SEND_CODE));
        actor.attemptsTo(
                EnterThe
                        .verificationCodeWith()
                        .verificationCode(Read.otpFromDataBase(user.getPhoneNumber()))
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
        User user = actor.recall("user");
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
        User user = actor.recall("user");
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
        User user = actor.recall("user");
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
        User user = actor.recall("user");
        actor.attemptsTo(Visualize.theHomeScreen(user));
    }

    @Then("{actor} should see the continue button disabled")
    public void actorShouldSeeTheContinueButtonDisabled(Actor actor) {
        actor.attemptsTo(Visualize.theContinueButtonDisabledOnTheCreatePasswordScreen());
    }

    @And("{actor} enters an unsecured password with {int} lowercase, {int} uppercase, {int} numbers and {int} special characters")
    public void heEntersAnUnsecuredPasswordWith(Actor actor, int low, int upper, int nums, int spec) {
        actor.remember("Password", StringGenerator.buildPassword(low, upper, nums, spec));
        actor.attemptsTo(
                CompleteTheCreateYouPassword
                        .with()
                        .password(actor.recall("Password"))
                        .passwordDisplayButton(true)
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @Then("{actor} should the Enter your phone number screen")
    public void heShouldTheEnterYourPhoneNumberScreen(Actor actor) {
        actor.attemptsTo(Visualize.theEnterYourNumberScreen());
    }

    @When("{actor} wants go back")
    public void heWantsGoBack(Actor actor) {
        actor.attemptsTo(
                Click.on(EnterYourPhoneNumberUI.BACK)
        );
    }

    @And("{actor} goes to the help screen and comes back")
    public void heGoesToTheHelpScreenAndComesBack(Actor actor) {
        actor.attemptsTo(
                Click.on(EnterYourPhoneNumberUI.HELP),
                Click.on(EnterYourPhoneNumberUI.BACK)
        );
    }

    @When("{actor} enters a not valid verification code")
    public void heEntersANotValidVerificationCode(Actor actor) {
        actor.attemptsTo(
                Check.whether(Validate.isKeyboardShown())
                        .andIfSo(Hide.theKeyboard()),
                Click.on(SEND_CODE),
                EnterThe
                        .verificationCodeWith()
                        .verificationCode("000000")
        );
    }

    @Then("{actor} should see the error message The code is incorrect")
    public void heShouldSeeTheErrorMessageTheCodeIsIncorrect(Actor actor) {
        actor.attemptsTo(Ensure.that(EnterYourCodeUI.THE_CODE_IS_INCORRECT).isDisplayed());
    }

    @Then("{actor} should see the Continue button disabled")
    public void heShouldSeeTheContinueButtonDisabled(Actor actor) {
        if (Validate.isAndroid()) {
            actor.attemptsTo(Ensure.that(AddYourBankAccountUI.CONTINUE).attribute("clickable").asABoolean().isEqualTo(false));
        } else if (Validate.isIOS()){
            actor.attemptsTo(Ensure.that(AddYourBankAccountUI.CONTINUE).attribute("enabled").asABoolean().isEqualTo(false));
        }
    }


    @When("{actor} adds his bank account information but lost the internet connection before saving")
    public void heAddsHisBankAccountInformationButLostTheInternetConnectionBeforeSaving(Actor actor) {
        User user = actor.recall("user");
        EnvironmentSpecificConfiguration env = actor.recall("env");

        String deviceName = env.getProperty("appium.deviceName");
        actor.attemptsTo(
                Add
                        .bankAccountInformationWith()
                        .holder(user.getBankInformation().getAccountHolder())
                        .interbankClabe(user.getBankInformation().getClabe())
        );
        actor.attemptsTo(Turn.offTheWifi(deviceName));
        actor.attemptsTo(
                Hide.theKeyboard(),
                WaitUntil.the(AddYourBankAccountUI.CONTINUE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(AddYourBankAccountUI.CONTINUE),
                WaitUntil.the(AddYourBankAccountUI.CONFIRM_CONTINUE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(AddYourBankAccountUI.CONFIRM_CONTINUE));
    }

    @Then("{actor} should see the modal No internet connection")
    public void heShouldSeeTheModalNoInternetConnection(Actor actor) {
        actor.attemptsTo(Ensure.that(AddYourBankAccountUI.NO_INTERNET_CONNECTION).isDisplayed());
    }
    @Then("{actor} should see the unencrypted password")
    public void heShouldSeeTheUnencryptedPassword(Actor actor) {
        if (Validate.isAndroid()) {
            actor.attemptsTo(Visualize.theUnencryptedPassword(actor));
        } else if (Validate.isIOS()){
            actor.attemptsTo(Visualize.theUnencryptedPasswordiOS(actor));
        }

    }
    @And("{actor} builds a password without visualizing it")
    public void heBuildsAPasswordWithoutVisualizingIt(Actor actor) {
        actor.remember("Password", StringGenerator.buildPassword(2, 2, 2, 0));
        actor.attemptsTo(
                CompleteTheCreateYouPassword
                        .with()
                        .password(actor.recall("Password"))
                        .passwordDisplayButton(false)
                        .continueButton(false)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }
    @Then("{actor} should see the encrypted password")
    public void heShouldSeeTheEncryptedPassword(Actor actor) {
            actor.attemptsTo(Visualize.theEncryptedPassword());
    }
    @And("{actor} enters the FAQs screen")
    public void heEntersTheFAQsPage(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(WeWantToMeetYouUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(WeWantToMeetYouUI.HELP_ICON));
    }
    @Then("{actor} should see the FAQs screen")
    public void heShouldSeeTheFAQsScreen(Actor actor) {
        actor.attemptsTo(Ensure.that(WeWantToMeetYouUI.TITLE).isNotDisplayed());
    }
    @And("{actor} closes the FAQs screen")
    public void heClosesTheFAQsScreen(Actor actor) {
        actor.attemptsTo(Click.on(FAQsUI.BUTTON_CLOSE));
    }

    @And("{actor} enters fills in the form with name field with numbers")
    public void heEntersFillsInTheFormWithNameFieldWithNumbers(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser("123456")
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @Then("{actor} should see the continue button disabled on the we want to meet you screen")
    public void heShouldSeeTheContinueButtonDisabledOnTheWeWantToMeetYouScreen(Actor actor) {
        actor.attemptsTo(Visualize.theContinueButtonDisabledOnTheWeWantToMeetYouScreen());
    }

    @And("{actor} enters fills in the form with name field with special characters")
    public void heEntersFillsInTheFormWithNameFieldWithSpecialCharacters(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser("*--*////**")
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Surname field empty")
    public void heEntersFillsInTheFormWithSurnameFieldEmpty(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser("")
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Surname field with special characters")
    public void heEntersFillsInTheFormWithSurnameWithSpecialCharacters(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser("*--*////**")
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Surname field with numbers")
    public void heEntersFillsInTheFormWithSurnameWithNumbers(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser("123456")
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Email field empty")
    public void heEntersFillsInTheFormWithEmailFieldEmpty(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser("")
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Email field without valid formatting")
    public void heEntersFillsInTheFormWithEmailFieldWithoutValidFormatting(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser("palo-it23.com")
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Email previously registered")
    public void heEntersFillsInTheFormWithEmailPreviouslyRegistered(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser("larcia@palo-it.com") // permanecer un email registrado previamente
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Business Name field empty")
    public void heEntersFillsInTheFormWithBusinessNameFieldEmpty(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName("")
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Business Name field with special characters")
    public void heEntersFillsInTheFormWithBusinessNameFieldWithSpecialCharacters(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName("-*-/-/**-")
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Activity field empty")
    public void heEntersFillsInTheFormWithActivityFieldEmpty(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity("")
                        .zipCode(user.getMerchantInfo().getPostalCode())
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Zip Code field empty")
    public void heEntersFillsInTheFormWithZipCodeFieldEmpty(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode("")
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Zip Code field with less than 5 characters")
    public void heEntersFillsInTheFormWithZipCodeFieldWithLessThanCharacters(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode("3598")
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @And("{actor} enters fills in the form with Zip Code field that are not from Mexico")
    public void heEntersFillsInTheFormWithZipCodeFieldThatAreNotFromMexico(Actor actor) {
        User user = actor.recall("user");
        assert user != null;
        actor.attemptsTo(
                FillInTheFormOfWeWantToMeetYou
                        .with()
                        .namesUser(user.getFirstName())
                        .lastNameUser(user.getLastName())
                        .emailUser(user.getEmail())
                        .businessName(user.getMerchantInfo().getMerchantName())
                        .businessActivity(user.getMerchantInfo().getMerchantActivity())
                        .zipCode("050014")
                        .continueButton(true)
        );
        actor.attemptsTo(Hide.theKeyboard());
    }

    @When("{actor} enter his old phone number and accepts terms and conditions")
    public void heEnterHisOldPhoneNumberAndAcceptsTermsAndConditions(Actor actor) {
        actor.attemptsTo(
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber("5529608038")
                        .acceptTermsAndCondition(true)
        );
    }
}
