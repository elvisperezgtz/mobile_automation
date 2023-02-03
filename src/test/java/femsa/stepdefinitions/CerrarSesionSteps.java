package femsa.stepdefinitions;

import femsa.asserts.Visualizar;
import femsa.tasks.Cerrar;
import femsa.user_interfaces.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

public class CerrarSesionSteps {

    @When("{actor} cierra la sesion de la app")
    public void elvisCierraLaSesionDeLaApp(Actor actor) {
        actor.attemptsTo(
                Cerrar.sesion()
        );
    }

    @Then("{actor} deberia ver la pantalla de inicio de sesion")
    public void elvisDeberiaVerLaPantallaDeInicioDeSesion(Actor actor) {
        actor.attemptsTo(
                Visualizar.pantallaLogin()
        );
    }
    @When("{actor} cierra la sesion de la app e intenta volver atras")
    public void elvisCierraLaSesionDeLaAppEIntentaVolverAtras(Actor actor) {
        actor.attemptsTo(
                Cerrar.sesion(),
                Visualizar.pantallaLogin(),
                Click.on(LoginUI.ATRAS)
        );

    }

    @Then("{actor} deberia ver la pantalla Registrate en tres pasos")
    public void elvisDeberiaVerLaPantallaRegistrateEnTresPasos(Actor actor) {
        actor.attemptsTo(
                Visualizar.pantallaRegistrate3Pasos()
        );
    }

    @Then("{actor} deberia ver el modal Quieres cerrar tu sesion")
    public void elvisDeberiaVerElModalQuieresCerrarTuSesion(Actor actor) {
        actor.attemptsTo();

    }

    @And("{actor} quiere cerrar la sesion activa")
    public void elvisQuiereCerrarLaSesionActiva(Actor actor) {
        actor.attemptsTo(

        );
    }
}
