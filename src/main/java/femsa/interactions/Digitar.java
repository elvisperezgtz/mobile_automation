package femsa.interactions;

import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static femsa.interactions.Execute.theAdbCommand;
import static femsa.utils.KeyBoard.getKeyEventCode;

public class Digitar implements Interaction {

    private String codigoValidacion;

    public Digitar(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    @Step("{0} ingresa el codigo de validacion")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (Validate.isIOS()) {
            for (char numero : codigoValidacion.toCharArray()) {
                actor.attemptsTo(
                        Click.on("//XCUIElementTypeKey[@name='" + numero + "']")
                );
            }
        } else {
            for (char numero : codigoValidacion.toCharArray()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                actor.attemptsTo(
                        theAdbCommand("adb shell input keyevent ".concat(getKeyEventCode(numero)))
                );
            }
        }
    }

    public static Digitar conTecladoNativo(String codigoValidacion) {
        return Tasks.instrumented(Digitar.class, codigoValidacion);
    }
}
