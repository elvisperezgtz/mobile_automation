package femsa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static femsa.user_interfaces.EnterYourPhoneNumberUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillOutTheFormWeWantToMeetYou implements Task {
    private String phoneNumber;
    private boolean termsAndCondition;
    private boolean clickContinue;

    @Override
    @Step("{0} fill out the form We want to meet you")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TITLE, isVisible()).forNoMoreThan(ofSeconds(10)),
                Enter.theValue(phoneNumber).into(PHONE_NUMBER),
                Check.whether(termsAndCondition)
                        .andIfSo(Click.on(TERMS_AND_CONDITION)),
                Check.whether(clickContinue).andIfSo(Click.on(CONTINUE))
        );
    }

    public static FillOutTheFormWeWantToMeetYou with() {
        return Tasks.instrumented(FillOutTheFormWeWantToMeetYou.class);
    }

    public FillOutTheFormWeWantToMeetYou phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public FillOutTheFormWeWantToMeetYou termsAndCondition(boolean termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
        return this;
    }

    public FillOutTheFormWeWantToMeetYou clickOnContinue(boolean clickContinue) {
        this.clickContinue = clickContinue;
        return this;
    }
}
