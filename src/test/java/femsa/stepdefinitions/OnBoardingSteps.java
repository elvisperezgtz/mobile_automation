package femsa.stepdefinitions;


import femsa.tasks.Complete;
import femsa.tasks.FillOutTheFormEnterYourPhoneNumber;
import femsa.user_interfaces.OnBoardingUI;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

import static femsa.user_interfaces.EnterYourPhoneNumberUI.CONTINUE;
import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OnBoardingSteps {

    private EnvironmentVariables env;
    @Managed(driver = "appium")
    private AppiumDriver driver;

    @Given("{actor} tiene acceso a la App de Mpos")
    public void elvisTieneAccesoALaAppDeMpos(Actor actor) {
        actor.can(
                BrowseTheWeb.with(driver)
        );

    }

    @Then("{actor} deberia poder visualizar el home de app")
    public void elDeberiaPoderVisualizarElHomeDeApp(Actor actor) {
        actor.attemptsTo(
                Ensure.that(OnBoardingUI.TITLE.waitingForNoMoreThan(ofSeconds(20))).isDisplayed()
        );
    }

    @Given("{actor} Perform the introductory tutorial")
    public void elvisPerformTheIntroductoryTutorial(Actor actor) {
        actor.remember("env", EnvironmentSpecificConfiguration.from(env));
        actor.attemptsTo(
                Complete.theIntroductoryTutorial(),
                WaitUntil.the(BEGIN_REGISTRATION, isVisible()).forNoMoreThan(ofSeconds(20))
        );

    }

    @When("{actor} starts his registration")
    public void heStartsHisRegistration(Actor actor, DataTable hisCredentialInfo) {
        actor.attemptsTo(
                Click.on(BEGIN_REGISTRATION),
                FillOutTheFormEnterYourPhoneNumber
                        .with()
                        .phoneNumber("5521996723")
                        .termsAndCondition(false)
        );
    }

    @And("{actor} fills in the We want to meet you form")
    public void heFillsInTheWeWantToMeetYouForm() {
    }

    @And("{actor} does not link the device or bank details")
    public void heDoesNotLinkTheDeviceOrBankDetails() {

    }

    @Then("{actor} should see the home page of the app")
    public void heShouldSeeTheHomePageOfTheApp(Actor actor) {
        actor.attemptsTo(
                Ensure.that(CONTINUE).attribute("clickable").isEqualTo("false")
        );
    }


}
