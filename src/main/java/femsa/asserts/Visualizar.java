package femsa.asserts;

import femsa.user_interfaces.OnBoardingUI;
import femsa.user_interfaces.Registrate3PasosUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.AdministracionPerilUI.*;
import static femsa.user_interfaces.LoginUI.CONTRASENIA;
import static femsa.user_interfaces.LoginUI.EMAIL_O_NUMERO;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Visualizar {

    public static Performable pantallaLogin() {
        return Task.where("{0} visualiza la pantalla de Inicia Sesion",
                WaitUntil.the(EMAIL_O_NUMERO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(EMAIL_O_NUMERO).isDisplayed(),
                Ensure.that(CONTRASENIA).isDisplayed());
    }

    public static Performable pantallaRegistrate3Pasos() {
        return Task.where("{0} visualiza la pantalla de Registrate en 3 pasos",
                WaitUntil.the(OnBoardingUI.TITULO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(Registrate3PasosUI.EMPEZAR_REGISTRO).isDisplayed(),
                Ensure.that(Registrate3PasosUI.YA_TENGO_CUENTA).isDisplayed()
        );
    }

    public static Performable modalConfirmarCerrarSesion() {
        return Task.where("{0} visualiza el modal : Quieres cerrar tu sesion?",
                WaitUntil.the(OnBoardingUI.TITULO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(Registrate3PasosUI.EMPEZAR_REGISTRO).isDisplayed(),
                Ensure.that(Registrate3PasosUI.YA_TENGO_CUENTA).isDisplayed()
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
}

