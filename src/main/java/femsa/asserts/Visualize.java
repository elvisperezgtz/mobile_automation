package femsa.asserts;

import femsa.models.BankInformation;
import femsa.models.MerchantInfo;
import femsa.models.User;
import femsa.user_interfaces.*;
import femsa.user_interfaces.wallet.IntroTutorialUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.CollectionUI.COLLECTION_BUTTON;
import static femsa.user_interfaces.CollectionUI.PURCHASE_ORDER_BUTTON;
import static femsa.user_interfaces.EditBankAccountUI.ACCOUNT_HOLDER;
import static femsa.user_interfaces.EditBankAccountUI.CLABE;
import static femsa.user_interfaces.EditBusinessDataUI.*;
import static femsa.user_interfaces.EditPersonalInformationUI.*;
import static femsa.user_interfaces.LoginUI.EMAIL_OR_PHONE_NUMBER;
import static femsa.user_interfaces.OnBoardingUI.TITLE;
import static femsa.user_interfaces.ProfileUI.HELP;
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

    public static Performable loginScreen() {
        return Task.where("{0} visualizes the Login screen",
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

    public static Performable theProfileScreen() {
        return Task.where("{0} visualizes the Profile screen",
                WaitUntil.the(BUSINESS, isVisible()).forNoMoreThan(ofSeconds(8)),
                Ensure.that(LOGO).isDisplayed(),
                Ensure.that(PROFILE_TITLE).isDisplayed(),
                Ensure.that(ProfileUI.PROFILE_PHONE_NUMBER).isDisplayed(),
                Ensure.that(EDIT_INFORMATION).isDisplayed(),
                Ensure.that(BUSINESS).isDisplayed(),
                Ensure.that(HELP).isDisplayed(),
                Ensure.that(AUTHORIZE_DEVICE).isDisplayed(),
                Ensure.that(LEGAL_DOCUMENTS).isDisplayed(),
                Ensure.that(LOGOUT).isDisplayed()
        );

    }

    public static Performable resetPasswordScreen() {
        return Task.where("{0} visualizes reset password screen",
                Ensure.that(RESET_PASSWORD_TITLE).isDisplayed(),
                Ensure.that(ResetPasswordUI.HELP).isDisplayed(),
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
                Ensure.that(ConfirmPasswordModalUI.TITLE.waitingForNoMoreThan(ofSeconds(10))).isDisplayed(),
                Ensure.that(ConfirmPasswordModalUI.PASSWORD).isDisplayed(),
                Ensure.that(ConfirmPasswordModalUI.CONTINUE).isDisplayed(),
                Ensure.that(ConfirmPasswordModalUI.CANCELAR).isDisplayed()
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

    public static Performable hisBusinessInformation(MerchantInfo merchantInfo) {

        return Task.where("{0} visualizes his business information",
                Ensure.that(BUSINESS_NAME).text().isEqualTo(merchantInfo.getMerchantName()),
                Ensure.that(BUSINESS_ACTIVITY).text().isEqualTo(merchantInfo.getMerchantActivity()),
                Ensure.that(POSTAL_CODE).text().isEqualTo(merchantInfo.getPostalCode())
        );
    }

    public static Performable theBusinessInformationFormInEditMode(User user) {
        return Task.where("{0} visualizes the Business information form in edit mode",
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(BUSINESS_NAME))).isTrue(),
                Ensure.that(BUSINESS_NAME).text().isEqualTo(user.getMerchantInfo().getMerchantName()),
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(BUSINESS_ACTIVITY))).isTrue(),
                Ensure.that(BUSINESS_ACTIVITY).text().isEqualTo(user.getMerchantInfo().getMerchantActivity()),
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(POSTAL_CODE))).isTrue(),
                Ensure.that(POSTAL_CODE).text().isEqualTo(user.getMerchantInfo().getPostalCode())
        );
    }

    public static Performable bankAccountInformation(BankInformation bankInformation) {
        return Task.where("{0} visualizes his Bank account information",
                Ensure.that(ACCOUNT_HOLDER).text().isEqualTo(bankInformation.getAccountHolder()),
                Ensure.that(CLABE).text().isEqualTo(bankInformation.getClabe()),
                Ensure.that(EDIT_INFORMATION).isDisplayed(),
                Ensure.that(CommonsUI.BACK).isDisplayed()
        );
    }

    public static Performable bankAccountInformationInEditMode(User user) {
        return Task.where("{0} visualizes the Bank account information form in edit mode",
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(ACCOUNT_HOLDER))).isTrue(),
                Ensure.that(ACCOUNT_HOLDER).text().isEqualTo(user.getBankInformation().getAccountHolder()),
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(CLABE))).isTrue(),
                Ensure.that(CLABE).text().isEqualTo(user.getBankInformation().getClabe())
        );
    }

    public static Performable doYouWantLogOutModal() {
        return Task.where("{0} visualizes the Do you want to logout modal",
                Ensure.that(LogoutUI.TITLE).isDisplayed(),
                Ensure.that(LogoutUI.YES_LOGOUT).isDisplayed(),
                Ensure.that(LogoutUI.CANCEL).isDisplayed()
        );
    }

    public static Performable theHelpScreen() {
        return Task.where("{0} visualizes the Help screen",
                WaitUntil.the(PREGUNTAS_FRECUENTES, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(PREGUNTAS_FRECUENTES).isDisplayed());
    }

    public static Performable theEnterYourCodeScreen() {
        return Task.where("{0} visualizes the Enter your code screen",
                Ensure.that(EnterYourCodeUI.WRITE_YOUR_CODE_TITLE).isDisplayed(),
                Ensure.that(EnterYourCodeUI.SMS_CODE_BOXES).isDisplayed()
        );
    }

    public static Performable theSalesOfTheDayIntro() {
        return Task.where("{0} visualizes the Sales of the day intro",
                Ensure.that(IntroTutorialUI.TITLE).text().isEqualTo("Conoce tu app"),
                Ensure.that(IntroTutorialUI.SALES_OF_THE_DAY).text().isEqualTo("Ventas del dia"),
                Ensure.that(IntroTutorialUI.SALES_OF_THE_DAY_EXPLANATION).text().isEqualTo("Es el dinero de tus ventas con tarjeta que hiciste con el dispositivo de cobro"),
                Ensure.that(IntroTutorialUI.CONTINUE).isDisplayed()
        );
    }

    public static Performable theInTransitToBankAccountIntro() {
        return Task.where("{0} visualizes the In transit to bank account intro",
                Ensure.that(IntroTutorialUI.IN_TRANSIT_TO_BANK_ACCOUNT).text().isEqualTo("En tránsito a cuenta bancaria"),
                Ensure.that(IntroTutorialUI.IN_TRANSIT_TO_BANK_ACCOUNT_EXPLANATION).text().contains("Es el dinero de tus ventas con tarjeta que está por depositarse a tu cuenta bancaria"),
                Ensure.that(IntroTutorialUI.CONTINUE).isDisplayed()
        );
    }

    public static Performable theGrowYourBusinessIntro() {
        return Task.where("{0} visualizes the Grow your business",
                Ensure.that(IntroTutorialUI.GROW_YOUR_BUSINESS).text().isEqualTo("Haz crecer tu negocio"),
                Ensure.that(IntroTutorialUI.GROW_YOUR_BUSINESS_EXPLANATION).text().contains("Acepta pagos con tarjeta, realiza ventas de tiempo aire y pagos de servicios como luz, Internet y más…"),
                Ensure.that(IntroTutorialUI.START).isDisplayed());
    }

    public static Performable thePersonalInformationUser(User user) {
        String PHONE_NUMBER = PROFILE_PHONE_NUMBER.resolveFor(OnStage.theActorInTheSpotlight()).getText().replaceAll(" ", "");
        return Task.where("{0} validates that your personal information is the same as previously registered",
                WaitUntil.the(PROFILE_TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(PROFILE_TITLE).text().isEqualToIgnoringCase(user.getFirstName() + ' ' + user.getLastName()),
                Ensure.that(PHONE_NUMBER).isEqualToIgnoringCase(user.getPhoneNumber())
        );
    }

    public static Performable theAbsenceOfTheEditButton() {
        return Task.where("{0} not display the Edit button on profile screen",
                WaitUntil.the(PROFILE_TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(EDIT_INFORMATION).isNotDisplayed()
        );
    }

    public static Performable theAbsenceOfTheBusinessButton() {
        return Task.where("{0} not display the Business button on profile screen",
                WaitUntil.the(PROFILE_TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(BUSINESS).isNotDisplayed()
        );
    }

    public static Performable theAbsenceOfTheCLABEButton() {
        return Task.where("{0} not display the CLABE button on profile screen",
                WaitUntil.the(PROFILE_TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(CLABE).isNotDisplayed()
        );
    }

    public static Performable theLinkedDeviceScreen() {
        return Task.where("{0} visualize the linked device screen",
                WaitUntil.the(AuthorizeDeviceUI.LINKED_DEVICE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(AuthorizeDeviceUI.BATTERY).isDisplayed(),
                Ensure.that(AuthorizeDeviceUI.SERIAL_NUMBER).isDisplayed(),
                Ensure.that(AuthorizeDeviceUI.VERSION).isDisplayed()
        );
    }

    public static Performable theTurnOnYourDeviceScreen() {
        return Task.where("{0} visualize the Turn on your device screen",
                WaitUntil.the(TurnOnYourDeviceUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(10)),
                Ensure.that(TurnOnYourDeviceUI.TITLE).isDisplayed(),
                Ensure.that(TurnOnYourDeviceUI.START).isDisplayed(),
                Ensure.that(TurnOnYourDeviceUI.LINK_LATER).isDisplayed()
        );
    }

    public static Performable theModalLocationPermission() {
        return Task.where("{0} visualize the Location permissions modal",
                WaitUntil.the(LocationPermissionsUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(10)),
                Ensure.that(LocationPermissionsUI.TITLE).isDisplayed(),
                Ensure.that(LocationPermissionsUI.WHILE_THE_APP_IS_IN_USE).isDisplayed(),
                Ensure.that(LocationPermissionsUI.ONLY_THIS_TIME).isDisplayed(),
                Ensure.that(LocationPermissionsUI.DO_NOT_ALLOW).isDisplayed()
        );
    }

    public static Performable theYouDoNotHaveInternetConnectionModal() {
        return Task.where("{0} visualize the You do not have Internet connection modal",
                WaitUntil.the(YouDoNotHaveInternetConnectionModalUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(20)),
                Ensure.that(YouDoNotHaveInternetConnectionModalUI.TITLE).text().isEqualTo("No tienes conexión a internet"),
                Ensure.that(YouDoNotHaveInternetConnectionModalUI.DO_IT_LATER).isDisplayed(),
                Ensure.that(YouDoNotHaveInternetConnectionModalUI.TRY_AGAIN).isDisplayed()
        );
    }

    public static Performable thePurchaseOrderFieldName() {
        return Task.where("{0} visualize that the purchase order field exists",
                WaitUntil.the(PURCHASE_ORDER_BUTTON, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(PURCHASE_ORDER_BUTTON).text().isEqualTo("Orden de compra")
        );
    }

    public static Performable theTextInsidePurchaseOrderField() {
        String TEXT_PURCHASE_ORDER = PURCHASE_ORDER_BUTTON.resolveFor(OnStage.theActorInTheSpotlight()).getText().trim();
        return Task.where("{0} visualize that the text was inserted in the purchase field",
                WaitUntil.the(PURCHASE_ORDER_BUTTON, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(TEXT_PURCHASE_ORDER).isEqualTo("Esta es un orden de compra con 50 caracteres 4lfaN")
        );
    }

    public static Performable theCollectionButtonEnabled() {
        return Task.where("{0} visualize that the purchase order field exists",
                WaitUntil.the(COLLECTION_BUTTON, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(theActorInTheSpotlight().asksFor(Enabled.of(COLLECTION_BUTTON))).isTrue()
        );
    }


    public static Performable theCreateYourPasswordScreen() {
        return Task.where("{0} visualizes the create your password screen",
                WaitUntil.the(CreateYourPasswordUI.TITLE, WebElementStateMatchers.isVisible()),
                Ensure.that(CreateYourPasswordUI.TITLE).isDisplayed());
    }

    public static Performable theWeWantToMeetYouScreen() {
        return Task.where("{0} visualizes the We want to meet you screen",
                WaitUntil.the(WeWantToMeetYouUI.TITLE, WebElementStateMatchers.isVisible()),
                Ensure.that(WeWantToMeetYouUI.TITLE).isDisplayed(),
                Ensure.that(WeWantToMeetYouUI.TITLE).text().isEqualTo("Queremos conocerte")
        );
    }

    public static Performable theAlreadyHaveYourDeviceScreen() {
        return Task.where("{0} visualizes the Already Have Your Device screen",
                WaitUntil.the(AlreadyHaveYourDeviceUI.I_HAVE_IT, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(AlreadyHaveYourDeviceUI.I_HAVE_IT).text().isEqualTo("Ya lo tengo"),
                Ensure.that(AlreadyHaveYourDeviceUI.I_DO_NOT_HAVE_YET).isDisplayed()
        );
    }

    public static Performable theGettingItIsEasyScreen() {
        return Task.where("{0} visualizes the Getting it is easy screen",
                WaitUntil.the(GettingItIsEasyUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(GettingItIsEasyUI.TITLE).isDisplayed(),
                Ensure.that(GettingItIsEasyUI.DO_IT_LATER).isDisplayed(),
                Ensure.that(GettingItIsEasyUI.MORE_SOON).isDisplayed()
        );
    }

    public static Performable theYouAreAlmostDoneScreen() {
        return Task.where("{0} visualizes the You are almost done screen",
                Ensure.that(YouAreAlmostDoneUI.TITLE.waitingForNoMoreThan(ofSeconds(15))).isDisplayed(),
                Ensure.that(YouAreAlmostDoneUI.GOT_IT).isDisplayed()
        );
    }

    public static Performable theAddYourBankAccountScreen() {
        return Task.where("{0} visualizes the Add your bank account screen",
                WaitUntil.the(AddYourBankAccountUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(AddYourBankAccountUI.TITLE).isDisplayed(),
                Ensure.that(AddYourBankAccountUI.FULL_NAME_OF_THE_HOLDER).isDisplayed(),
                Ensure.that(AddYourBankAccountUI.CLABE).isDisplayed(),
                Ensure.that(AddYourBankAccountUI.CONTINUE).isDisplayed()
        );
    }

    public static Performable theHomeScreen(User user){
        return Task.where("{0} visualizes the Home screen",
                WaitUntil.the(HomeUI.HOME, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(HomeUI.BUSINESS_NAME).text().isEqualTo(user.getMerchantInfo().getMerchantName())
        );
    }

    public static Performable theContinueButtonDisabledOnTheCreatePasswordScreen() {
        return Task.where("{0} visualizes the continue button disabled on the create password screen",
                WaitUntil.the(CreateYourPasswordUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(CreateYourPasswordUI.TITLE).text().isEqualTo("Crea tu contraseña")
        );
    }

    public static Performable theEnterYourNumberScreen() {
        return Task.where("{0} visualizes the Enter your number screen",
                WaitUntil.the(EnterYourPhoneNumberUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(EnterYourPhoneNumberUI.PHONE_NUMBER).isDisplayed(),
                Ensure.that(EnterYourPhoneNumberUI.TERMS_AND_CONDITION).isDisplayed(),
                Ensure.that(EnterYourPhoneNumberUI.SEND_CODE).isDisplayed()
        );
    }

    public static Performable theUnencryptedPassword(Actor actor) {
        return Task.where("{0} visualizes the Enter your number screen",
                WaitUntil.the(CreateYourPasswordUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(CreateYourPasswordUI.PASSWORD_TEXTBOX).text().isEqualTo(actor.recall("Password"))
        );
    }

    public static Performable theEncryptedPassword() {
        return Task.where("{0} visualizes the Enter your number screen",
                WaitUntil.the(CreateYourPasswordUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(CreateYourPasswordUI.PASSWORD_TEXTBOX).text().isEqualTo("••••••")
        );
    }

    public static Performable theContinueButtonDisabledOnTheWeWantToMeetYouScreen() {
        return Task.where("{0} visualizes the continue button disabled on the create password screen",
                WaitUntil.the(WeWantToMeetYouUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(WeWantToMeetYouUI.TITLE).text().isEqualTo("Queremos conocerte")
        );
    }

    public static Performable theUnencryptedPasswordiOS(Actor actor) {
        return Task.where("{0} visualizes the Enter your number screen",
                WaitUntil.the(CreateYourPasswordUI.TITLE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(CreateYourPasswordUI.PASSWORD_TEXTBOX_iOS).text().isEqualTo(actor.recall("Password"))
        );
    }
}