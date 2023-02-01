package femsa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class Clear implements Interaction {

    Target target;
    public Clear(Target target) {
        this.target = target;
    }

    @Override
    @Step("{0} clear content of #target")
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).click();
        target.resolveFor(actor).clear();
    }

    public static Clear textBox(Target target) {
        return Tasks.instrumented(Clear.class, target);
    }
}
