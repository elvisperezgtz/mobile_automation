package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.tasks.Authorize;
import femsa.tasks.Reject;
import femsa.user_interfaces.ProfileUI;
import femsa.user_interfaces.TurnOnYourDeviceUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

public class AuthorizeDeviceSteps {


    @Then("{actor} should see the message Device ready")
    public void heShouldSeeTheMessageDeviceReady(Actor actor) {

    }

    @And("{actor} authorize his device")
    public void heAuthorizeHisDevice(Actor actor) {
        actor.attemptsTo(
                Authorize.with()
                        .connectDevice(true)
                        .authorizeDevice(true)
        );
    }

    @When("{actor} wants to go to Authorize device option")
    public void heWantsToGoToAuthorizeDeviceOption(Actor actor) {
        actor.attemptsTo(Click.on(ProfileUI.AUTHORIZE_DEVICE));
    }

    @Then("{actor} should see the Turn on your device screen")
    public void heShouldSeeTheTurnOnYourDeviceScreen(Actor actor) {
        actor.attemptsTo(Visualize.theTurnOnYourDeviceScreen());
    }

    @And("{actor} wants to Link his device later")
    public void heWantsToLinkHisDeviceLater(Actor actor) {
        actor.attemptsTo(
                Click.on(ProfileUI.AUTHORIZE_DEVICE),
                Click.on(TurnOnYourDeviceUI.LINK_LATER));
    }

    @When("{actor} deny permissions on his cellphone")
    public void heDenyPermissionsOnHisCellphone(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        actor.attemptsTo(
                Click.on(ProfileUI.AUTHORIZE_DEVICE),
                Click.on(TurnOnYourDeviceUI.START),
                Reject.permissionAndroid(env.getProperty("appium.platformVersion"),true)
        );
        /**
         * 1 preguntar so
         * 2 validar version
         *      si es 12
         *          reject location
         *          reject cercania
         *      si es 10
         *          reject location
         *
         */

    }

}
