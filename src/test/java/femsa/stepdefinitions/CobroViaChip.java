package femsa.stepdefinitions;

import femsa.tasks.Cobrar;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class CobroViaChip {

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
        actor.attemptsTo(Cobrar.viaChip(monto, concepto));
    }


    @Then("{actor} deberia poder ver que el cobro se realizo con exito")
    public void elvisDeberiaPoderVerQueElCobroSeRealizoConExito(Actor actor) {
    }
}
