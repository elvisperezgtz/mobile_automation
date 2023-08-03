package femsa.interactions;

import femsa.user_interfaces.CommonsUI;
import femsa.utils.GetProxiesDriver;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static femsa.user_interfaces.CollectionUI.ENTER_AMOUNT_TITLE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class Hide implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (Validate.isAndroid()) {
            GetProxiesDriver.forAndroid().hideKeyboard();
        } else if (Validate.isIOS()) {
            actor.attemptsTo(
                    Check.whether(Validate.isKeyboardShown())
                            .andIfSo(Check.whether(ENTER_AMOUNT_TITLE.isVisibleFor(theActorInTheSpotlight()))
                                    .andIfSo(Click.on(ENTER_AMOUNT_TITLE))
                                    .otherwise(Click.on(CommonsUI.HIDE_KEYBOARD))
                            )

            );
        }
    }

    public static Hide theKeyboard() {
        return Tasks.instrumented(Hide.class);
    }
}
