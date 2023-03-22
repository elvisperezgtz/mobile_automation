package femsa.asserts;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.AdministracionPerilUI.*;
import static femsa.user_interfaces.LoginUI.EMAIL_OR_PHONE_NUMBER;
import static femsa.user_interfaces.LoginUI.PASSWORD;
import static femsa.user_interfaces.OnBoardingUI.TITLE;
import static femsa.user_interfaces.RegisterInThreeStepsUI.ALREADY_HAVE_ACCOUNT;
import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static femsa.user_interfaces.ResetPasswordUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Visualize {
    private Visualize() {
    }

    public static Performable pantallaLogin() {
        return Task.where("{0} visualiza la pantalla de Inicia Sesion",
                WaitUntil.the(EMAIL_OR_PHONE_NUMBER, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(EMAIL_OR_PHONE_NUMBER).isDisplayed(),
                Ensure.that(PASSWORD).isDisplayed());
    }

    public static Performable registerInThreeStepsScreen() {
        return Task.where("{0} Visualizes the register in three steps screen",
                WaitUntil.the(TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(BEGIN_REGISTRATION).isDisplayed(),
                Ensure.that(ALREADY_HAVE_ACCOUNT).isDisplayed()
        );
    }

    public static Performable modalConfirmarCerrarSesion() {
        return Task.where("{0} visualiza el modal : Quieres cerrar tu sesion?",
                WaitUntil.the(TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(BEGIN_REGISTRATION).isDisplayed(),
                Ensure.that(ALREADY_HAVE_ACCOUNT).isDisplayed()
        );
    }

    public static Performable pantallaPerfil() {
        return Task.where("{0} visualiza la pantalla Perfil",
                WaitUntil.the(NEGOCIO, isVisible()).forNoMoreThan(ofSeconds(8)),
                Ensure.that(LOGO).isDisplayed(),
                Ensure.that(NOMBRE_USUARIO).isDisplayed(),
                Ensure.that(NUMERO_TELEFONICO).isDisplayed(),
                Ensure.that(EDITAR).isDisplayed(),
                Ensure.that(NEGOCIO).isDisplayed(),
                Ensure.that(AYUDA).isDisplayed(),
                Ensure.that(AUTORIZAR_DISPOSITIVO).isDisplayed(),
                Ensure.that(DOCUMENTOS_LEGALES).isDisplayed(),
                Ensure.that(CERRAR_SESION).isDisplayed()
        );

    }

    public static Performable resetPasswordScreen(){
        return Task.where("{0} visualize reset password screen",
                Ensure.that(RESET_PASSWORD_TITLE).isDisplayed(),
                Ensure.that(HELP).isDisplayed(),
                Ensure.that(BACK).isDisplayed(),
                Ensure.that(PHONE_NUMBER).isDisplayed(),
                Ensure.that(CONTINUE).isDisplayed()
                );
    }

}

