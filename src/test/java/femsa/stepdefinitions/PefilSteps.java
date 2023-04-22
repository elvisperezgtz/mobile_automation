package femsa.stepdefinitions;

import femsa.asserts.Visualize;
import femsa.tasks.Navigate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class PefilSteps {
    @When("{actor} ingresa a la opcion Perfil")
    public void elvisIngresaALaOpcionPerfil(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheProfileAdministrationScreen()
        );
    }

    @Then("{actor} deberia ver la pantalla de perfil con todos sus componentes")
    public void elvisDeberiaVerLaPantallaDePerfilConTodosSusComponentes(Actor actor) {
        actor.attemptsTo(

        );

    }

    @Then("{actor} should see the Profile screen")
    public void heShouldSeeTheProfileScreen(Actor actor) {
        actor.attemptsTo(Visualize.theProfileScreen());
    }

    @Then("{actor} should see the login screen")
    public void heShouldSeeTheLoginScreen(Actor actor) {
        actor.attemptsTo(Visualize.loginScreen());
    }
}
