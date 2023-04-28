package femsa.tasks;

import femsa.user_interfaces.wallet.IntroTutorialUI;
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

public static Performable theWalletIntroTutorial(){
        return Task.where("{0} completes the introductory tutorial",
                Click.on(IntroTutorialUI.CONTINUE),
                Click.on(IntroTutorialUI.CONTINUE),
                Click.on(IntroTutorialUI.START)
        );
}
}
