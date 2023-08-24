package femsa.tasks;

import femsa.asserts.Visualize;
import femsa.user_interfaces.KnowYourAppUI;
import femsa.user_interfaces.wallet.IntroTutorialUI;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import femsa.interactions.SwipeFrom;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static femsa.user_interfaces.EditBankAccountUI.ACEPTAR;
import static femsa.user_interfaces.EditBankAccountUI.CONTINUAR;


public class Complete {
    public static Performable theIntroductoryTutorial() {
        return Task.where("{0} completes the introductory tutorial",
                SwipeFrom.leftToRight(),
                SwipeFrom.leftToRight()
        );
    }

    public static Performable theKnowYourAppTutorial(){
        return Task.where("{0} completes the Know your app tutorial",
                Click.on(KnowYourAppUI.CONTINUE_BUTTON),
                Click.on(KnowYourAppUI.CONTINUE_BUTTON)
        );
    }
    public static Performable theWalletIntroTutorial() {
        return Task.where("{0} completes the introductory tutorial",
                WaitUntil.the(IntroTutorialUI.TITLE, WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                Visualize.theSalesOfTheDayIntro(),
                Click.on(IntroTutorialUI.CONTINUE),
                Visualize.theInTransitToBankAccountIntro(),
                Click.on(IntroTutorialUI.CONTINUE),

                Click.on(IntroTutorialUI.START)
        );
    }
}
