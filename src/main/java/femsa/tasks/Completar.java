package femsa.tasks;

import femsa.models.Usuario;
import femsa.user_interfaces.DatosBancariosUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import femsa.interactions.SwipeFrom;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static femsa.user_interfaces.DatosBancariosUI.ACEPTAR;
import static femsa.user_interfaces.DatosBancariosUI.CONTINUAR;


public class Completar {
    public static Performable elTutorial() {
        return Task.where("{0} completa el tutorial introductorio",
                SwipeFrom.leftToRight(),
                SwipeFrom.leftToRight()
        );
    }

    public static Performable elProcesoDeOnboarding(Usuario usuario){
        return Task.where(
                "{0} Completa el proceso de onboarding",
                Ingresar.cuentaClabeTitular(usuario),
                Click.on(CONTINUAR),
                Click.on(ACEPTAR)
        );

    }

}
