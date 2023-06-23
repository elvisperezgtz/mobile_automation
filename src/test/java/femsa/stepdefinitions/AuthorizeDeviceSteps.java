package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.interactions.Execute;
import femsa.interactions.Turn;
import femsa.tasks.Authorize;
import femsa.tasks.AuthorizeDevice;
import femsa.tasks.Reject;
import femsa.user_interfaces.AuthorizeDeviceUI;
import femsa.user_interfaces.ProfileUI;
import femsa.user_interfaces.TurnOnYourDeviceUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static femsa.user_interfaces.HelpUI.CLOSE;
import static femsa.user_interfaces.HelpUI.HELP_TITLE;
import static femsa.user_interfaces.ProfileUI.AUTHORIZE_DEVICE;
import static femsa.user_interfaces.TurnOnYourDeviceUI.HELP;
import static java.time.Duration.ofSeconds;

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
                Reject.permissionAndroid(env.getProperty("appium.platformVersion"), true)
        );
    }

    @When("{actor} authorize his device with bluetooth turned off")
    public void heAuthorizeHisDeviceWithBluetoothTurnedOff(Actor actor) {

        EnvironmentSpecificConfiguration env = actor.recall("env");
        String deviceName = env.getProperty("appium.deviceName");
        actor.attemptsTo(
                Execute.theAdbCommand("adb -s " + deviceName + " shell cmd bluetooth_manager disable"),
                Authorize
                        .with()
                        .bluetoothActive(false)
                        .connectDevice(true)
                        .authorizeDevice(true)
        );
    }

    @When("{actor} tries to authorize his device without internet connection")
    public void heTriesToAuthorizeHisDeviceWithoutInternetConnection(Actor actor) {
        EnvironmentSpecificConfiguration env = actor.recall("env");
        String platformVersion = env.getProperty("appium.platformVersion");
        String deviceName = env.getProperty("appium.deviceName");
        actor.attemptsTo(AuthorizeDevice.withoutInternetConnection(platformVersion));
        actor.attemptsTo(Turn.offTheWifi(deviceName));
        actor.attemptsTo(Click.on(AuthorizeDeviceUI.CONNECT));

    }

    @Then("{actor} should see the modal You do not have Internet connection")
    public void heShouldSeeTheModalYouDoNotHaveInternetConnection(Actor actor) {
        actor.attemptsTo(
                Visualize.theYouDoNotHaveInternetConnectionModal()
        );
    }

    @And("{actor} wants to authorize his device later")
    public void heWantsToAuthorizeHisDeviceLater(Actor actor) {
        actor.attemptsTo(
                Click.on(AUTHORIZE_DEVICE),
                Click.on(TurnOnYourDeviceUI.LINK_LATER)
        );
    }

    @When("{actor} needs help in the Turn on your device screen")
    public void heNeedsHelpInTheTurnOnYourDeviceScreen(Actor actor) {
        actor.attemptsTo(
                Click.on(AUTHORIZE_DEVICE),
                Click.on(HELP)
        );
    }

    @Then("{actor} should see the screen: How to use my Spiro device")
    public void heShouldSeeTheScreenHowToUseMySpiroDevice(Actor actor) {
        actor.attemptsTo(
                Ensure.that(HELP_TITLE.waitingForNoMoreThan(ofSeconds(15))).isDisplayed()
        );
    }

    @When("{actor} is on the help screen and want to go back")
    public void heIsOnTheHelpScreenAndWantToGoBack(Actor actor) {
        actor.attemptsTo(
                Click.on(AUTHORIZE_DEVICE),
                Click.on(HELP),
                Click.on(CLOSE)
        );
    }
}
