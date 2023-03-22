package femsa.tasks;

import femsa.interactions.Hide;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

import static femsa.user_interfaces.LoginUI.*;

public class InTheLoginForm implements Task {

    private String username;
    private String password;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(EMAIL_OR_PHONE_NUMBER),
                Enter.theValue(password).into(PASSWORD),
                Check.whether(Validate.isIOS())
                        .andIfSo(Hide.theKeyboard())
        );

    }
    public InTheLoginForm withUsername(String username){
        this.username = username;
        return this;
    }
    public InTheLoginForm withPassword(String password){
        this.password = password;
        return  this;
    }

}
