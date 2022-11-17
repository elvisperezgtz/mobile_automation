package femsa.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectFromDropDown {
    public static Performable byVisibleText(Target target, String option){
        return Interaction.where(
                "{0} selects an option from dropdown",
                Click.on(target),
                Click.on("//android.widget.TextView[@text='"+option+"']")
        );
    }
}
