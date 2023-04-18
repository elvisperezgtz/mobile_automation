package femsa.tasks;

import femsa.user_interfaces.EditBusinessDataUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.HomeUI.HOME;
import static femsa.user_interfaces.HomeUI.PROFILE;
import static femsa.user_interfaces.IntroDispositivoUI.CONECTAR_DISPOSITIVO;
import static femsa.user_interfaces.IntroDispositivoUI.YA_LO_TENGO;
import static femsa.user_interfaces.ProfileUI.*;
import static femsa.user_interfaces.RegisterInThreeStepsUI.ALREADY_HAVE_ACCOUNT;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Navigate {

    public static Performable aVincularDispositivoMpos() {
        return Task.where("{0} navega hasta la pantalla de vincular dispositivo",
                Click.on(YA_LO_TENGO),
                Click.on(CONECTAR_DISPOSITIVO)
        );
    }

    public static Performable toBankAccountInformationScreen() {
        return Task.where("{0} navigates to the Bank account information screen",
                Navigate.toTheProfileAdministrationScreen(),
                Click.on(CLABE)
        );
    }

    public static Performable aLaPantallaDocumentosLegales() {
        return Task.where("{0} navega hasta la pantalla de Documentos legales",
                toTheProfileAdministrationScreen(),
                Click.on(DOCUMENTOS_LEGALES)
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
                Click.on(EDIT)
        );
    }

    public static Performable toTheBusinessInformationScreen() {
        return Task.where("{0} navigates to te business information editing screen",
                Navigate.toTheProfileAdministrationScreen(),
                Click.on(BUSINESS)
        );
    }

    public static Performable aLaPantallaDeLogin() {
        return Task.where("{0} navega hasta la pantalla de login",
                Complete.theIntroductoryTutorial(),
                WaitUntil.the(ALREADY_HAVE_ACCOUNT, isVisible()).forNoMoreThan(ofSeconds(10)),
                Click.on(ALREADY_HAVE_ACCOUNT)
        );
    }

    public static Performable desdeNegocioHastaHome() {
        return Task.where("{0} navega desde la pantalla Negocio hasta la pantalla Home",
                Click.on(EditBusinessDataUI.BACK),
                Click.on(HOME)
        );
    }

    public static Performable fromEditBusinessInformationToHome() {
        return Task.where("{0} navigates from Business Information to Home screen",
                Click.on(EditBusinessDataUI.BACK),
                Click.on(HOME)
        );
    }
}
