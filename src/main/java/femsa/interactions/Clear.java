package femsa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static femsa.interactions.Ejecutar.elComandoAdb;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Clear implements Interaction {

    Target target;


    public Clear(Target target) {
        this.target = target;
    }

    @Override
    @Step("{0} clear content of #target")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isEnabled()).forNoMoreThan(ofSeconds(10))
        );
        String content = target.resolveFor(actor).getText();
        actor.attemptsTo(Click.on(target));
        for (int i = 0; i <= content.length(); i++)
            actor.attemptsTo(elComandoAdb(" adb shell input keyevent 67"));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static Clear textBox(Target target) {
        return Tasks.instrumented(Clear.class, target);
    }
}
