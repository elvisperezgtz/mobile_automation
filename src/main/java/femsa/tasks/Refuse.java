package femsa.tasks;

import femsa.interactions.Hide;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import java.time.Duration;

import static femsa.user_interfaces.CommonsUI.CANCEL;
import static femsa.user_interfaces.DoYouWantToGoModalUI.EXIT_WITHOUT_SAVING;
import static java.time.Duration.ofSeconds;


public class Refuse {
    public static Performable toSaveEditedData(){
        return Task.where("{0} refuses to save the edited data",
                Check.whether(Validate.isIOS())
                        .andIfSo(Hide.theKeyboard()),
                Click.on(CANCEL.waitingForNoMoreThan(ofSeconds(10))),
                Click.on(EXIT_WITHOUT_SAVING.waitingForNoMoreThan(Duration.ofSeconds(10)))
                );
    }
}
