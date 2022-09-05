package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import femsa.interactions.SwipeFrom;


public class Completar {
    public static Performable elTutorial() {
        return Task.where("{0} completa el tutorial introductorio",
                SwipeFrom.leftToRight(),
                SwipeFrom.leftToRight()
        );
    }

}
