package femsa.tasks;

import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static femsa.user_interfaces.EnterYourCodeUI.SMS_CODE_BOXES;
import static java.time.Duration.ofSeconds;

public class EnterThe implements Task {

    private String verificationCode;

    @Override
    @Step("{0} Enters his verification code")
    public <T extends Actor> void performAs(T actor) {

        if (Validate.isAndroid()) {
            actor.attemptsTo(
                    Enter.theValue(verificationCode).into(SMS_CODE_BOXES.waitingForNoMoreThan(ofSeconds(15))));
        } else {
            actor.attemptsTo(Enter.theValue(verificationCode).into(SMS_CODE_BOXES.waitingForNoMoreThan(ofSeconds(15))));
        }
    }

    public static EnterThe verificationCodeWith() {
        return Tasks.instrumented(EnterThe.class);
    }

    public EnterThe verificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
        return this;
    }
    public EnterThe emptyVerificationCode() {
        this.verificationCode = "";
        return this;
    }

}
