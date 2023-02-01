package femsa.stepdefinitions;

import femsa.tasks.Navegar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class PefilSteps {
    @When("{actor} ingresa a la opcion Perfil")
    public void elvisIngresaALaOpcionPerfil(Actor actor) {
        actor.attemptsTo(
                Navegar.aLaPantallaAdministracionDePerfil()
        );
    }

    @Then("{actor} deberia ver la pantalla de perfil con todos sus componentes")
    public void elvisDeberiaVerLaPantallaDePerfilConTodosSusComponentes(Actor actor) {
        actor.attemptsTo(

        );

    }


}
