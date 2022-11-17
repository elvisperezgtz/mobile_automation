package femsa.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import femsa.interactions.Esperar;
import femsa.tasks.Ingresar;
import femsa.tasks.Registrar;
import femsa.user_interfaces.RegistroUI;
import femsa.utils.OtpReader;

import java.io.IOException;

import static femsa.utils.GetProperty.fromPropertyFile;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static femsa.user_interfaces.PasswordUI.*;
import static femsa.user_interfaces.RegistroUI.*;

public class RegistroSteps {

    @Managed(driver = "appium")
    private AppiumDriver driver;

    @Given("{actor} tiene acceso a la app Mpos por primera vez")
    public void elvis_tiene_acceso_a_la_app_mpos_por_primera_vez(Actor actor) {
        actor.can(
                BrowseTheWeb.with(driver)
        );
    }

    @When("{actor} realiza el registro en la App con su numero de telefono")
    public void el_realiza_el_registro_en_la_app_con_su_numero_de_telefono(Actor actor) {
        actor.attemptsTo(
                Registrar.elNumeroTelefonico(fromPropertyFile("src/test/resources/properties/usuario.properties","linea"))
        );
        actor.remember("numero telefonico", fromPropertyFile("src/test/resources/properties/usuario.properties","linea"));

    }

    @Then("{actor} deberia poder ver que el mensaje de envio del codigo SMS contine el numero registrado por el usuario")
    public void elvisDeberiaPoderVerQueElMensajeDeEnvioDelCodigoSMSContineElNumeroRegistradoPorElUsuario(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(TITULO_CODIGO_SMS, isPresent())
                        .forNoMoreThan(ofSeconds(15)),
                Ensure.that(TITULO_CODIGO_SMS).isDisplayed(),
                Ensure.that(MENSAJE_ENVIO_SMS)
                        .text()
                        .contains("Escribe el c\u00F3digo que enviamos al n\u00FAmero ".concat(actor.recall("numero telefonico")))
        );
    }

    @Then("{actor} deberia poder ver que el mensaje de error {string}")
    public void elvisDeberiaPoderVerQueElMensajeDeError(Actor actor, String mensajeError) {
        actor.attemptsTo(
                Ensure.that(MENSAJE_ERROR_TELEFONO).text().isEqualToIgnoringCase(mensajeError)
        );
    }

    @Then("{actor} deberia poder ver el mensaje con el texto {string}")
    public void elvisDeberiaPoderVerElMensajeConElTexto(Actor actor, String mensajeConfirmacion) {
        actor.attemptsTo(
                Ensure.that(CELULAR_VALIDADO).text().isEqualTo(mensajeConfirmacion)
        );
    }

    @And("{actor} ingresa un codigo de verificacion no valido")
    public void elvisIngresaUnCodigoDeVerificacionNoValido(Actor actor) throws IOException {
        actor.attemptsTo(Ingresar.codigoDeValidacion("111111"));
    }

    @And("{actor} ingresa el codigo de verifacion enviado a su celular")
    public void elvisIngresaElCodigoDeVerifacionEnviadoASuCelular(Actor actor) throws IOException {
      String otp = OtpReader.getOtpFromNotification(BrowseTheWeb.as(actor).getDriver());
        actor.attemptsTo(
                Ingresar.codigoDeValidacion(otp)
        );
    }

    @Then("{actor} deberia ver la cuenta regresiva para poder reenviar el codigo de validacion")
    public void elvisDeberiaVerLaCuentaRegresivaParaPoderReenviarElCodigoDeValidacion(Actor actor) {
        actor.attemptsTo(
                Ensure.that(RegistroUI.CRONOMETRO).isDisplayed()
        );
    }

    @And("{actor} espera a que termine la cuenta regresiva")
    public void elvisEsperaAQueTermineLaCuentaRegresiva(Actor actor) {
        actor.attemptsTo(
                Esperar.queTermineLaCuentaRegresiva()
        );
    }

    @Then("{actor} deberia ver el boton {string}")
    public void elvisDeberiaVerElBoton(Actor actor, String nombreBoton) {
        actor.attemptsTo(
                Ensure.that(REENVIAR_SMS).text().isEqualTo(nombreBoton)
        );
    }

    @Then("{actor} deberia poder ver el mensaje de error con el texto {string}")
    public void elvisDeberiaPoderVerElMensajeDeErrorConElTexto(Actor actor, String codigoError) {
        actor.attemptsTo(
                Ensure.that(CODIGO_INCORRECTO).text().isEqualTo(codigoError)
        );
    }

    @And("{actor} ingresa un nuevo codigo de verificacion valido")
    public void elvisIngresaUnNuevoCodigoDeVerificacionValido(Actor actor) throws IOException {
        actor.attemptsTo(
                Ingresar.unNuevoCodigoDeVerificacion()
        );
    }

    @Then("{actor} deberia poder ver el mensaje de confirmacion de Numero validado")
    public void elvisDeberiaPoderVerElMensajeDeConfirmacionDeNumeroValidado(Actor actor) {
        actor.attemptsTo(Ensure.that(CELULAR_VALIDADO.waitingForNoMoreThan(ofSeconds(5))).isDisplayed());
    }

    @When("{actor} ingresa la contrasenia {string} para su cuenta")
    public void elvisIngresaLaContraseniaParaSuCuenta(Actor actor, String password) {
        actor.attemptsTo(Ingresar.unaContrasenia(password));
    }

    @Then("{actor} deberia ver que el boton Continuar se encuentra deshabilitado")
    public void elvisDeberiaVerQueElBotonContinuarSeEncuentraDeshabilitado(Actor actor) {
        actor.attemptsTo(
                Ensure.that(BOTON_CONTINUAR).not().isEnabled()
        );
    }

    @Then("{actor} deberia ver que el boton Continuar se encuentra habilitado")
    public void elvisDeberiaVerQueElBotonContinuarSeEncuentraHabilitado(Actor actor) {
        actor.attemptsTo(
                Ensure.that(BOTON_CONTINUAR).isEnabled()
        );
    }

    @And("{actor} deberia ver que no existen validaciones pendientes")
    public void elvisDeberiaVerQueNoExistenValidacionesPendientes(Actor actor) {
        actor.attemptsTo(
                Ensure.that(VALIDACION_8_CARACTERES).not().isDisplayed(),
                Ensure.that(VALIDACION_MAYUSCULA).not().isDisplayed(),
                Ensure.that(VALIDACION_MINUSCULA).not().isDisplayed(),
                Ensure.that(VALIDACION_NUMERO).not().isDisplayed()
        );
    }

    @And("{actor} deberia ver la alerta con la frase {string}")
    public void elvisDeberiaVerLaAlertaConLaFrase(Actor actor, String validacion) {
        actor.attemptsTo(
                Ensure.that(VALIDACION_8_CARACTERES).text().isEqualTo(validacion)
        );
    }

    @And("{actor} deberia ver que existen validaciones pendientes")
    public void elvisDeberiaVerQueExistenValidacionesPendientes(Actor actor) {
        actor.attemptsTo(
                Ensure.that(VALIDACION_8_CARACTERES).not().isDisplayed(),
                Ensure.that(VALIDACION_MAYUSCULA).not().isDisplayed(),
                Ensure.that(VALIDACION_MINUSCULA).not().isDisplayed(),
                Ensure.that(VALIDACION_NUMERO).not().isDisplayed()
        );
    }

    @And("{actor} realiza el registro en la App con el numero de telefono {string}")
    public void elvisRealizaElRegistroEnLaAppConElNumeroDeTelefono(Actor actor,String numeroTelefonico) {
        actor.attemptsTo(
                        Registrar.elNumeroTelefonico(numeroTelefonico)
        );
    }


}
