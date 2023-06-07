package femsa.stepdefinitions;

import femsa.tasks.Authorize;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

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
}
