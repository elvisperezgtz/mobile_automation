package femsa.stepdefinitions;


import femsa.tasks.Complete;
import femsa.user_interfaces.OnBoardingUI;
import femsa.user_interfaces.RegisterInThreeStepsUI;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;

import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OnBoardingSteps {


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
        actor.attemptsTo(
                Complete.theIntroductoryTutorial(),
                WaitUntil.the(RegisterInThreeStepsUI.BEGIN_REGISTRATION, isVisible()).forNoMoreThan(ofSeconds(20))
        );
    }
}
