package femsa.tasks;

import femsa.user_interfaces.LoginUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static femsa.user_interfaces.RegisterInThreeStepsUI.ALREADY_HAVE_ACCOUNT;

public class Login implements Task {

    private String password;
    private String username;


    @Override
    @Step("{0} logs in with his credentials")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ALREADY_HAVE_ACCOUNT),
                Fill.inTheLoginForm()
                        .withUsername(username)
                        .withPassword(password),
                Click.on(LoginUI.LOGIN)
        );

    }
    public static Login whit(){
        return Tasks.instrumented(Login.class);
    }

    public  Login andPassword(String password){
        this.password = password;
        return this;
    }
    public Login username (String username){
        this.username = username;
        return this;
    }

}
