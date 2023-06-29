package femsa.tasks;

import femsa.user_interfaces.EditBusinessDataUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.HomeUI.HOME;
import static femsa.user_interfaces.HomeUI.PROFILE;
import static femsa.user_interfaces.ProfileUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Navigate {



    public static Performable toBankAccountInformationScreen() {
        return Task.where("{0} navigates to the Bank account information screen",
                Navigate.toTheProfileAdministrationScreen(),
                Click.on(CLABE)
        );
    }


    public static Performable toTheProfileAdministrationScreen() {
        return Task.where("{0} navigates to the Profile screen",
                WaitUntil.the(PROFILE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(PROFILE)
        );
    }

    public static Performable toThePersonalInformationScreen() {
        return Task.where("{0} navigates to the personal information editing screen",
                Navigate.toTheProfileAdministrationScreen(),
                Click.on(EDIT_INFORMATION)
        );
    }

    public static Performable toTheBusinessInformationScreen() {
        return Task.where("{0} navigates to te business information editing screen",
                Navigate.toTheProfileAdministrationScreen(),
                Click.on(BUSINESS)
        );
    }

    public static Performable fromEditBusinessInformationToHome() {
        return Task.where("{0} navigates from Business Information to Home screen",
                Click.on(EditBusinessDataUI.BACK),
                Click.on(HOME)
        );
    }
}
