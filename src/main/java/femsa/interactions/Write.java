package femsa.interactions;

import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static femsa.interactions.Execute.theAdbCommand;
import static femsa.utils.KeyBoard.getKeyEventCode;

public class Write implements Interaction {

    private String validationCode;

    public Write(String codigoValidacion) {
        this.validationCode = codigoValidacion;
    }

    @Step("{0} Write")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (Validate.isIOS()) {
            for (char number : validationCode.toCharArray()) {
                actor.attemptsTo(
                        Click.on("//XCUIElementTypeKey[@name='" + number + "']")
                );
            }
        } else {
            for (char number : validationCode.toCharArray()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                actor.attemptsTo(
                        theAdbCommand("adb shell input keyevent ".concat(getKeyEventCode(number)))
                );
            }
        }
    }

    public static Write withNativeKeyboard(String validationCode) {
        return Tasks.instrumented(Write.class, validationCode);
    }
}
