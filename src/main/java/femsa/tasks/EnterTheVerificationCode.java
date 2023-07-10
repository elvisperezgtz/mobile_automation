package femsa.tasks;

import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import java.sql.SQLException;

import static femsa.user_interfaces.EnterYourCodeUI.SMS_CODE_BOXES;
import static femsa.utils.database.Read.otpFromDataBase;
import static java.time.Duration.ofSeconds;

public class EnterTheVerificationCode implements Task {

    private String phoneNumber;
    private Boolean enterPhoneNumber;


    @Override
    @Step("{0} Enters his verification code")
    public <T extends Actor> void performAs(T actor) {

        try {
            if (Validate.isAndroid()) {
                actor.attemptsTo(
                        Enter.theValue(otpFromDataBase(phoneNumber)).into(SMS_CODE_BOXES.waitingForNoMoreThan(ofSeconds(15))));
            } else {
                actor.attemptsTo();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static EnterTheVerificationCode with() {
        return Tasks.instrumented(EnterTheVerificationCode.class);
    }

    public EnterTheVerificationCode phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

}
