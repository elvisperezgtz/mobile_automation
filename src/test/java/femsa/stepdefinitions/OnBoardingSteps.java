package femsa.stepdefinitions;


import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import femsa.tasks.Completar;
import femsa.user_interfaces.OnBoardingUI;

import static java.time.Duration.ofSeconds;

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
                Completar.elTutorial()
        );
    }
    @Then("{actor} deberia poder visualizar el home de app")
    public void elDeberiaPoderVisualizarElHomeDeApp(Actor actor) {
        actor.attemptsTo(
                Ensure.that(OnBoardingUI.TITULO.waitingForNoMoreThan(ofSeconds(20))).isDisplayed()
        );
    }
}
