package femsa.stepdefinitions;

import femsa.tasks.IniciarSesion;
import femsa.user_interfaces.LoginUI;
import femsa.utils.GetProperty;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.time.Duration;

import static femsa.user_interfaces.LoginUI.INICIANDO_SESION;
import static femsa.utils.GetProperty.fromPropertyFile;

public class LoginSteps {

    @When("{actor} inicia sesion con su numero telefonico")
    public void elvisIniciaSesionConSuNumeroTelefonico(Actor actor) {
        String usuario = fromPropertyFile("src/test/resources/properties/usuario.properties", "linea");
        String contrasenia = fromPropertyFile("src/test/resources/properties/usuario.properties", "contrasenia");
        actor.attemptsTo(
                IniciarSesion.conSusCredenciales(usuario, contrasenia)
        );

    }

    @Then("{actor} deberia poder ver el mensaje de {string}")
    public void elvisDeberiaPoderVerElMensajeDe(Actor actor, String mensaje) {
        actor.attemptsTo(
                Ensure.that(INICIANDO_SESION.waitingForNoMoreThan(Duration.ofSeconds(10))).text().isEqualToIgnoringCase(mensaje)
        );

    }
}
