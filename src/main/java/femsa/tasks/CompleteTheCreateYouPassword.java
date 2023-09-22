package femsa.tasks;

import femsa.interactions.Hide;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static femsa.user_interfaces.CreateYourPasswordUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class CompleteTheCreateYouPassword implements Task {
    private boolean continueB;
    private boolean passwordDisplay;
    private String newPassword;

    @Override
    @Step("{0} fill in the fields on the create password screen")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PASSWORD_TEXTBOX, isVisible()).forNoMoreThan(ofSeconds(15)),
                Enter.theValue(newPassword).into(PASSWORD_TEXTBOX),
                Hide.theKeyboard(),
                Check.whether(passwordDisplay)
                        .andIfSo(Click.on(PASSWORD_DISPLAY_BUTTON)),
                Check.whether(continueB)
                        .andIfSo(Click.on(CONTINUE_BUTTON))
        );
    }

    public static CompleteTheCreateYouPassword with() {
        return Tasks.instrumented(CompleteTheCreateYouPassword.class);
    }
    public CompleteTheCreateYouPassword passwordDisplayButton (boolean passwordDisplay){
        this.passwordDisplay = passwordDisplay;
        return this;
    }
    public CompleteTheCreateYouPassword continueButton (boolean continueB){
        this.continueB = continueB;
        return this;
    }
    public CompleteTheCreateYouPassword password (String newPassword){
        this.newPassword = newPassword;
        return this;
    }

}
