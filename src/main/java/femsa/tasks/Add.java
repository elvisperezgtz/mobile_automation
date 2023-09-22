package femsa.tasks;

import femsa.interactions.Hide;
import femsa.user_interfaces.AddYourBankAccountUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static femsa.user_interfaces.AddYourBankAccountUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Add implements Task {

    private String holder;
    private String clabe;
    private boolean continueSaving;
    private boolean confirmSaving;
    private boolean doItLater;

    @Step("{0} Adds his bank account information")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(holder).into(FULL_NAME_OF_THE_HOLDER),
                Enter.theValue(clabe).into(CLABE),
                Hide.theKeyboard()
        );
        actor.attemptsTo(
                Check.whether(continueSaving)
                        .andIfSo(
                                WaitUntil.the(AddYourBankAccountUI.CONTINUE, isVisible()).forNoMoreThan(ofSeconds(15)),
                                Click.on(CONTINUE)
                        )
        );
        actor.attemptsTo(
                Check.whether(doItLater)
                        .andIfSo(Click.on(DO_IT_LATER))
        );
        actor.attemptsTo(
                Check.whether(confirmSaving)
                        .andIfSo(Click.on(CONFIRM_CONTINUE))
        );

    }

    public static Add bankAccountInformationWith() {
        return Tasks.instrumented(Add.class);
    }

    public Add holder(String holder) {
        this.holder = holder;
        return this;
    }

    public Add interbankClabe(String clabe) {
        this.clabe = clabe;
        return this;
    }

    public Add emptyHolder() {
        this.clabe = "";
        return this;
    }

    public Add emptyClabe() {
        this.clabe = "";
        return this;
    }

    public Add andContinueSaving(boolean continueSaving) {

        this.continueSaving = continueSaving;
        return this;
    }

    public Add doItLater(boolean doItLater) {
        this.doItLater = doItLater;
        return this;
    }

    public Add addConfirmContinueSaving(boolean confirmSaving) {
        this.confirmSaving = confirmSaving;
        return this;
    }
}
