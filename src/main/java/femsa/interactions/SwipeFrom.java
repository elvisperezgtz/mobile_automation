package femsa.interactions;

import femsa.enums.Direccion;
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
        try {
            Thread.sleep(1000);
            Swipe.mobileSwipe(BrowseTheWeb.as(actor).getDriver(), Direccion.IZQUIERDA);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static SwipeFrom leftToRight() {
        return Tasks.instrumented(SwipeFrom.class);
    }
}
