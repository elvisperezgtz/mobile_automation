package femsa.stepdefinitions;

import femsa.tasks.IniciarSesion;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.LoginUI.*;
import static femsa.utils.GetProperty.fromPropertyFile;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class LoginSteps {

    @When("{actor} inicia sesion con su numero telefonico")
    public void elvisIniciaSesionConSuNumeroTelefonico(Actor actor) {
        String usuario = fromPropertyFile("src/test/resources/properties/usuario.properties", "linea");
        String contrasenia = fromPropertyFile("src/test/resources/properties/usuario.properties", "contrasenia");
        actor.attemptsTo(
                IniciarSesion.conSusCredenciales(usuario, contrasenia)
        );
    }

    @Then("{actor} deberia poder ver el mensaje {string}")
    public void elvisDeberiaPoderVerElMensaje(Actor actor, String mensaje) {
        actor.attemptsTo(
                Ensure.that(INICIANDO_SESION.waitingForNoMoreThan(ofSeconds(10))).isDisplayed()
        );
    }

    @When("{actor} inicia sesion con el usuario {string} y la contrasenia {string}")
    public void elvisIniciaSesionConElUsuarioYLaContrasenia(Actor actor, String usuario, String contrasenia) {
        actor.attemptsTo(
                IniciarSesion.conSusCredenciales(usuario, contrasenia)
        );
        actor.remember("contrasenia", contrasenia);
    }

    @Then("{actor} deberia poder ver el boton Iniciar sesion deshabilitado")
    public void elvisDeberiaPoderVerElBotonIniciarSesionDeshabilitado(Actor actor) {
        actor.attemptsTo(Ensure.that(INICIAR_SESION).not().isEnabled());
    }

    @Then("{actor} deberia poder ver el mensaje de error {string}")
    public void elvisDeberiaPoderVerElMensajeError(Actor actor, String mensajeError) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                WaitUntil.the(MENSAJE_ERROR, isPresent()).forNoMoreThan(ofSeconds(10)),
                Ensure.that(MENSAJE_ERROR).isDisplayed()
        );
    }


}
