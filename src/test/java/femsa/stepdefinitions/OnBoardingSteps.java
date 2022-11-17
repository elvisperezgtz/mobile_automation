package femsa.stepdefinitions;


import femsa.tasks.Completar;
import femsa.user_interfaces.OnBoardingUI;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    @When("{actor} realiza el tutorial introductorio")
    public void elRealizaElTutorialIntroductorio(Actor actor) {
                actor.attemptsTo(
                Completar.elTutorial(),
                        WaitUntil.the(OnBoardingUI.EMPEZAR_REGISTRO, isVisible()).forNoMoreThan(ofSeconds(10))
        );

    }
    @Then("{actor} deberia poder visualizar el home de app")
    public void elDeberiaPoderVisualizarElHomeDeApp(Actor actor) {
        actor.attemptsTo(
                Ensure.that(OnBoardingUI.TITULO.waitingForNoMoreThan(ofSeconds(20))).isDisplayed()
        );
    }
}
