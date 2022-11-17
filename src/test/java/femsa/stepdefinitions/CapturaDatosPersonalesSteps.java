package femsa.stepdefinitions;

import femsa.utils.GetProperty;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import femsa.interactions.GetOtp;
import femsa.models.Usuario;
import femsa.tasks.Completar;
import femsa.tasks.Ingresar;
import femsa.tasks.Registrar;
import femsa.user_interfaces.IntroDispositivoUI;

import java.io.IOException;

import static femsa.user_interfaces.DatosPersonalesUI.*;
import static femsa.user_interfaces.IntroDispositivoUI.TITULO;
import static femsa.user_interfaces.IntroDispositivoUI.YA_LO_TENGO;
import static femsa.user_interfaces.PasswordUI.BOTON_CONTINUAR;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CapturaDatosPersonalesSteps {
    @Managed(driver = "appium")
    private AppiumDriver driver;
    public Usuario usuario = new Usuario();

    @Given("{actor} ha registrado su telefono")
    public void elvisHaRegistradoElTelefono(Actor actor) {
        actor.attemptsTo(
                Completar.elTutorial(),
                Registrar.elNumeroTelefonico(GetProperty.fromPropertyFile("src/test/resources/properties/usuario.properties","linea"))
        );
    }
    @And("{actor} ingreso el codigo de validacion enviado a su celular")
    public void elvisIngresoElCodigoDeValidacionEnviadoASuCelular(Actor actor) throws IOException {
        actor.attemptsTo(
                GetOtp.fromSMS()
        );
        actor.attemptsTo(
                Ingresar.codigoDeValidacion(actor.recall("otp"))
        );
    }

    @And("{actor} establecio {string} como contrasenia de su cuenta")
    public void elvisEstablecioComoContraseniaDeSuCuenta(Actor actor, String contrasenia) {
        actor.attemptsTo(
                Ingresar.unaContrasenia(contrasenia),
                Click.on(BOTON_CONTINUAR)
        );
    }

    @When("{actor} registra los datos personales")
    public void elvisRegistraLosDatosPersonales(Actor actor) {
        usuario.defaulValues();
        actor.attemptsTo(
                Ingresar.datosPersonales(usuario)
        );
    }

    @Then("{actor} deberia poder ver el titulo {string}")
    public void elvisDeberiaPoderVerElTitulo(Actor actor, String titulo) {
        actor.attemptsTo(
                WaitUntil.the(CONTINUAR, isClickable()).forNoMoreThan(ofSeconds(5)).then(Click.on(CONTINUAR)),
                WaitUntil.the(YA_LO_TENGO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(TITULO).text().isEqualToIgnoringCase(titulo)
        );
    }

    @Then("{actor} deberia poder ver la alerta {string}")
    public void elvisDeberiaPoderVerLaAlerta(Actor actor, String titulo) {
        actor.attemptsTo(
                Ensure.that(OBLIGATORIEDAD).text().isEqualToIgnoringCase(titulo)
        );
    }

    @And("{actor} deberia ver los botones con el texto {string} y {string}")
    public void elvisDeberiaVerLosBotonesConElTextoY(Actor actor, String botonYaLoTengo, String botonAunNoLoTengo) {
        actor.attemptsTo(
                Ensure.that(YA_LO_TENGO).text().isEqualTo(botonYaLoTengo),
                Ensure.that(IntroDispositivoUI.AUN_NO_LO_TENGO).text().isEqualTo(botonAunNoLoTengo)
        );
    }

    @Then("{actor} deberia validar que la longitud del campo nombre sea menor igual a {int}")
    public void elvisDeberiaValidarQueLaLongitudDelCampoNombreSeaMenorIgualA(Actor actor, int longitud) {
        actor.attemptsTo(
                Ensure.that(NOMBRES).text().hasSizeBetween(1,longitud)
        );

    }
}