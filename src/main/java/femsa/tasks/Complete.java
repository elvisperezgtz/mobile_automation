package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import femsa.interactions.SwipeFrom;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.EditBankAccountUI.ACEPTAR;
import static femsa.user_interfaces.EditBankAccountUI.CONTINUAR;


public class Complete {
    public static Performable theIntroductoryTutorial() {
        return Task.where("{0} completes the introductory tutorial",
                SwipeFrom.leftToRight(),
                SwipeFrom.leftToRight()
        );
    }

//    public static Performable elProcesoDeOnboarding(Usuario usuario){
//        return Task.where(
//                "{0} Completa el proceso de onboarding",
//                Ingresar.cuentaClabeTitular(usuario),
//                Click.on(CONTINUAR),
//                Click.on(ACEPTAR)
//        );
//
//    }

}
