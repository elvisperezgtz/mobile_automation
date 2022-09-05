package femsa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import femsa.utils.Swipe;

public class SwipeFrom implements Interaction {

    @Step("{0} perform a swipe from left to right")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Swipe.leftToRight(BrowseTheWeb.as(actor).getDriver());
    }

    public static SwipeFrom leftToRight() {
        return Tasks.instrumented(SwipeFrom.class);
    }
}
