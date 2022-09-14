package femsa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static femsa.interactions.Ejecutar.elComandoAdb;
import static femsa.utils.KeyBoard.getKeyEventCode;

public class Digitar implements Interaction {

    private String codigoValidacion;

    public Digitar(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    @Step("{0} ingresa el codigo de validacion")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (char numero : codigoValidacion.toCharArray()) {
            actor.attemptsTo(
                    elComandoAdb("adb shell input keyevent ".concat(getKeyEventCode(numero)))
            );
        }
    }

    public static Digitar conTecladoNativo(String codigoValidacion) {
        return Tasks.instrumented(Digitar.class, codigoValidacion);
    }
}
