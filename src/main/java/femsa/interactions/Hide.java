package femsa.interactions;

import femsa.user_interfaces.CommonsUI;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;

import static net.serenitybdd.screenplay.abilities.BrowseTheWeb.as;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hide implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (Validate.isAndroid()) {
            actor.attemptsTo(Ejecutar.elComandoAdb("adb shell input keyevent KEYCODE_ESCAPE"));
        } else if (Validate.isIOS()) {
            actor.attemptsTo(
                    Check.whether(Validate.isKeyboardShown(as(theActorInTheSpotlight()).getDriver()))
                                    .andIfSo(Click.on(CommonsUI.HIDE_KEYBOARD))
            );
        }
    }

    public static Hide theKeyboard() {
        return Tasks.instrumented(Hide.class);
    }
}
