package femsa.stepdefinitions;

import femsa.tasks.Cacelar;
import femsa.tasks.Cobrar;
import femsa.tasks.Reintentar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.CobroUI.COBRAR;
import static femsa.user_interfaces.CobroUI.TARJETA_BLOQUEADA;
import static femsa.user_interfaces.HomeUI.MOVIMIENTOS_HOY;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;

public class CobroViaChipSteps {

    @When("{actor} realiza el cobro con monto {string} y concepto {string}")
    public void elvisRealizaElCobroConMontoMontoYConceptoConcepto(Actor actor, String monto, String concepto) {
        /**
         * 1 click en el boton cobrar
         * 2 habilitar bluetooth
         * 3 ingresar el monto
         * 4 ingresar el concepto
         * 5 click en cobrar
         * 6 vincular dispositivo mpos
         * 7 validar el cobro exitoso
         */

        /**
         * Dispositivos encontrados BT
         * 1 esperar que aparezca el boton
         * 2 click en el boton
         * 3 esperar el texto "Conexion exitosa"
         * 4 Click en continuar
         */
        actor.attemptsTo(Cobrar.viaChip(monto, concepto));
    }

    @Then("{actor} deberia poder ver que el cobro se realizo con exito")
    public void elvisDeberiaPoderVerQueElCobroSeRealizoConExito(Actor actor) {

    }

    @Then("{actor} deberia poder ver la pantalla de tarjeta bloqueada")
    public void elvisDeberiaPoderVerLaPantallaDeTarjetaBloqueada(Actor actor) {
        actor.attemptsTo(
                the(TARJETA_BLOQUEADA, isVisible()).forNoMoreThan(ofSeconds(15))
                        .then(Ensure.that(TARJETA_BLOQUEADA).isDisplayed())
        );
    }

    @And("{actor} selecciona la opcion Volver a intentar en la pantalla de tarjeta bloqueada")
    public void elvisSeleccionaLaOpcionVolverAIntentarEnLaPantallaDeTarjetaBloqueada(Actor actor) {
        actor.attemptsTo(Reintentar.elCobro());
    }

    @And("{actor} selecciona la opcion Cancelar en la pantalla de tarjeta bloqueada")
    public void elvisSeleccionaLaOpcionCancelarEnLaPantallaDeTarjetaBloqueada(Actor actor) {
        actor.attemptsTo(Cacelar.elReintentoDeCobro());
    }

    @Then("{actor} deberia poder ver el home de la app")
    public void elvisDeberiaPoderVerElHomeDeLaApp(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(MOVIMIENTOS_HOY, isVisible()).forNoMoreThan(ofSeconds(15))
                        .then(Ensure.that(MOVIMIENTOS_HOY).isDisplayed())
        );
    }

    @Then("{actor} deberia poder ver la pantalla de Monto por cobrar")
    public void elvisDeberiaPoderVerLaPantallaDeMontoPorCobrar(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(COBRAR, isVisible()).forNoMoreThan(ofSeconds(15))
                        .then(Ensure.that(COBRAR).isDisplayed())
        );
    }
}
