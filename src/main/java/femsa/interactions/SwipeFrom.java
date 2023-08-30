package femsa.interactions;

import femsa.enums.Orientation;
import femsa.enums.SwipeDirection;
import femsa.utils.W3CSwipeUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class SwipeFrom implements Interaction {

    private static Orientation orientation;

    @Step("{0} performs a swipe from left to right")
    @Override
    public <T extends Actor> void performAs(T actor) {
        W3CSwipeUtils.swipe(SwipeDirection.SWIPE_LEFT);
    }

    public static SwipeFrom leftToRight() {
        orientation = Orientation.LEFT;
        return Tasks.instrumented(SwipeFrom.class, orientation);
    }

    public static SwipeFrom upToDown() {
        orientation = Orientation.UP;
        return Tasks.instrumented(SwipeFrom.class, orientation);
    }
}
