package femsa.asserts;

import femsa.models.User;
import femsa.user_interfaces.ConfirmPasswordModalUI;
import femsa.user_interfaces.DoYouWantToGoModalUI;
import femsa.user_interfaces.LoginUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.EditBusinessDataUI.*;
import static femsa.user_interfaces.EditPersonalInformationUI.*;
import static femsa.user_interfaces.LoginUI.EMAIL_OR_PHONE_NUMBER;
import static femsa.user_interfaces.OnBoardingUI.TITLE;
import static femsa.user_interfaces.ProfileUI.EDIT;
import static femsa.user_interfaces.ProfileUI.LOGO;
import static femsa.user_interfaces.ProfileUI.*;
import static femsa.user_interfaces.RegisterInThreeStepsUI.ALREADY_HAVE_ACCOUNT;
import static femsa.user_interfaces.RegisterInThreeStepsUI.BEGIN_REGISTRATION;
import static femsa.user_interfaces.ResetPasswordUI.BACK;
import static femsa.user_interfaces.ResetPasswordUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Visualize {
    private Visualize() {
    }

    public static Performable pantallaLogin() {
        return Task.where("{0} visualiza la pantalla de Inicia Sesion",
                WaitUntil.the(EMAIL_OR_PHONE_NUMBER, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(EMAIL_OR_PHONE_NUMBER).isDisplayed(),
                Ensure.that(LoginUI.PASSWORD).isDisplayed());
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

    public static Performable theProfileScreen() {
        return Task.where("{0} visualizes the Profile screen",
                WaitUntil.the(BUSINESS, isVisible()).forNoMoreThan(ofSeconds(8)),
                Ensure.that(LOGO).isDisplayed(),
                Ensure.that(PROFILE_TITLE).isDisplayed(),
                Ensure.that(NUMERO_TELEFONICO).isDisplayed(),
                Ensure.that(EDIT).isDisplayed(),
                Ensure.that(BUSINESS).isDisplayed(),
                Ensure.that(AYUDA).isDisplayed(),
                Ensure.that(AUTORIZAR_DISPOSITIVO).isDisplayed(),
                Ensure.that(DOCUMENTOS_LEGALES).isDisplayed(),
                Ensure.that(CERRAR_SESION).isDisplayed()
        );

    }

    public static Performable resetPasswordScreen() {
        return Task.where("{0} visualizes reset password screen",
                Ensure.that(RESET_PASSWORD_TITLE).isDisplayed(),
                Ensure.that(HELP).isDisplayed(),
                Ensure.that(BACK).isDisplayed(),
                Ensure.that(PHONE_NUMBER).isDisplayed(),
                Ensure.that(CONTINUE).isDisplayed()
        );
    }

    public static Performable hisPersonalInformation(User user) {
        return Task.where("{0} validates that your personal information is the same as previously registered",
                Ensure.that(FIRST_NAME).text().isEqualToIgnoringCase(user.getFirstName()),
                Ensure.that(LAST_NAME).text().isEqualToIgnoringCase(user.getLastName()),
                Ensure.that(EMAIL).text().isEqualToIgnoringCase(user.getEmail())
        );
    }

    public static Performable aConfirmPasswordModal() {
        return Task.where("{0} visualizes a Confirm Password modal",
                Ensure.that(ConfirmPasswordModalUI.TITLE).isDisplayed(),
                Ensure.that(ConfirmPasswordModalUI.PASSWORD).isDisplayed(),
                Ensure.that(ConfirmPasswordModalUI.CONTINUE).isDisplayed(),
//                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(ConfirmPasswordModalUI.CONTINUE))).isFalse(),
                Ensure.that(ConfirmPasswordModalUI.CANCELAR).isDisplayed()
//                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(ConfirmPasswordModalUI.CANCELAR))).isTrue()
        );
    }

    public static Performable thePersonalInformationFormInEditMode(User user) {
        return Task.where("{0} visualizes the Personal Information form in edit mode",
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(FIRST_NAME))).isTrue(),
                Ensure.that(FIRST_NAME).text().isEqualTo(user.getFirstName()),
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(LAST_NAME))).isTrue(),
                Ensure.that(LAST_NAME).text().isEqualTo(user.getLastName()),
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(EMAIL))).isTrue(),
                Ensure.that(EMAIL).text().isEqualTo(user.getEmail())
        );
    }

    public static Performable doYouWantToGoOutModal() {
        return Task.where("{0} Visualizes the Do you want to go out? modal",
                Ensure.that(DoYouWantToGoModalUI.TITLE).isDisplayed(),
                Ensure.that(DoYouWantToGoModalUI.CONTINUE_EDITING).isDisplayed(),
                Ensure.that(DoYouWantToGoModalUI.EXIT_WITHOUT_SAVING).isDisplayed()
        );
    }

    public static Performable hisBusinessInformation(User user) {

        return Task.where("{0} visualizes his business information",
                Ensure.that(BUSINESS_NAME).text().isEqualTo(user.getMerchantInfo().getMerchantName()),
                Ensure.that(BUSINESS_ACTIVITY).text().isEqualTo(user.getMerchantInfo().getMerchantActivity()),
                Ensure.that(POSTAL_CODE).text().isEqualTo(user.getMerchantInfo().getPostalCode())
        );
    }
    public static Performable theBusinessInformationFormInEditMode(User user){
        return Task.where("{0} visualizes the Business information form in edit mode",
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(BUSINESS_NAME))).isTrue(),
                Ensure.that(BUSINESS_NAME).text().isEqualTo(user.getMerchantInfo().getMerchantName()),
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(BUSINESS_ACTIVITY))).isTrue(),
                Ensure.that(BUSINESS_ACTIVITY).text().isEqualTo(user.getMerchantInfo().getMerchantActivity()),
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(POSTAL_CODE))).isTrue(),
                Ensure.that(POSTAL_CODE).text().isEqualTo(user.getMerchantInfo().getPostalCode())
        );
    }
}

