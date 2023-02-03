package femsa.interactions;

import femsa.user_interfaces.CommonsUI;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Hide implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (Validate.isAndroid()) {
            actor.attemptsTo(Ejecutar.elComandoAdb("adb shell input keyevent KEYCODE_ESCAPE"));
        } else if (Validate.isIOS()) {
            actor.attemptsTo(
                    Click.on(CommonsUI.HIDE_KEYBOARD)
            );
        }
    }

    public static Hide theKeyboard() {
        return Tasks.instrumented(Hide.class);
    }
}
