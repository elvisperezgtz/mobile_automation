package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.LogoutUI.YES_LOGOUT;
import static femsa.user_interfaces.ProfileUI.LOGOUT;


public class Logout {
    public static Performable fromTheApp(){
        return Task.where("{0} logs out from the app",
                Click.on(LOGOUT),
                Click.on(YES_LOGOUT));
    }

}
