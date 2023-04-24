package femsa.tasks;

import femsa.interactions.Hide;
import femsa.interactions.SelectFromDropDown;
import femsa.models.MerchantInfo;
import femsa.models.User;
import femsa.user_interfaces.EditBusinessDataUI;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.ClabeInterbancariaUI.CLABE_INTERBANCARIA;
import static femsa.user_interfaces.ClabeInterbancariaUI.NOMBRE_TITULAR;
import static femsa.user_interfaces.EditBankAccountUI.ACCOUNT_HOLDER;
import static femsa.user_interfaces.EditBankAccountUI.CLABE;
import static femsa.user_interfaces.EditBusinessDataUI.*;
import static femsa.user_interfaces.EditPersonalInformationUI.*;
import static femsa.utils.Validate.isKeyboardShown;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.abilities.BrowseTheWeb.as;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Edit {
    private Edit() {
    }

    public static Performable formularioDeDatosBancarios(String clabe, String titular) {
        return Task.where("{0} edita sus datos bancarios en el formulario de datos bancarios",
                Enter.theValue(titular).into(NOMBRE_TITULAR),
                Enter.theValue(clabe).into(CLABE_INTERBANCARIA)
        );
    }

    public static Performable losDatosBancarios(String clabe, String titular) {
        return Task.where("{0} edita sus datos bancarios",
                WaitUntil.the(CLABE_INTERBANCARIA, isEnabled()),
                Edit.formularioDeDatosBancarios(clabe, titular),
                Save.theEditedInformation()
        );
    }

    public static Performable personalInformation(User user) {
        return Task.where("{0} edits his personal information",
                Click.on(EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                WaitUntil.the(FIRST_NAME, isEnabled()),
                Edit.personalInformationForm(user)
        );
    }

    public static Performable personalInformationForm(User user) {
        return Task.where("{0} edits his bank details in the bank details form",
                Enter.theValue(user.getFirstName()).into(FIRST_NAME),
                Enter.theValue(user.getLastName()).into(LAST_NAME),
                Enter.theValue(user.getEmail()).into(EMAIL),
                Check.whether(Validate.isIOS()).andIfSo(Hide.theKeyboard())
        );
    }

    public static Performable businessInformation(MerchantInfo merchantInfo) {
        return Task.where("{0} edits his business information",
                Click.on(EditBusinessDataUI.EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                Edit.businessInformationForm(merchantInfo)
        );
    }

    public static Performable formularioDeDatosDeNegocio(String nombreNegocio, String actividadNegocio, String codigoPostal) {
        return Task.where("{0} edita sus datos de su negocio en el formulario de datos de negocio",
                Enter.theValue(nombreNegocio).into(BUSINESS_NAME),
                SelectFromDropDown.byVisibleText(BUSINESS_ACTIVITY, actividadNegocio),
                Enter.theValue(codigoPostal).into(EMAIL)
        );
    }

    public static Performable email(String newEmail) {
        return Task.where("{0} edits his email with '" + newEmail + "'",
                Click.on(EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                WaitUntil.the(EMAIL, isEnabled()).forNoMoreThan(ofSeconds(10)),
                Enter.theValue(newEmail).into(EMAIL).then(Click.on(EMAIL)),
                Click.on(LAST_NAME).then(Hide.theKeyboard())
        );
    }

    public static Performable businessName(String businessName) {
        return Task.where("{0} edits his business name with '" + businessName + "'",
                Click.on(EditBusinessDataUI.EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                WaitUntil.the(BUSINESS_NAME, isEnabled()).forNoMoreThan(ofSeconds(10)),
                Enter.theValue(businessName).into(BUSINESS_NAME),
                Check.whether(Validate.isIOS()).andIfSo(Hide.theKeyboard())
        );
    }

    public static Performable postalCode(String postalCode) {
        return Task.where("{0} edits his postal code",
                Click.on(EditBusinessDataUI.EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                WaitUntil.the(POSTAL_CODE, isEnabled()).forNoMoreThan(ofSeconds(10)),
                Click.on(POSTAL_CODE),
                Enter.theValue(postalCode).into(POSTAL_CODE),
                Click.on(BUSINESS_NAME),
                Hide.theKeyboard()
        );
    }

    public static Performable businessInformationForm(MerchantInfo merchantInfo) {

        return Task.where("{0} edits the business information form",
                Enter.theValue(merchantInfo.getMerchantName()).into(BUSINESS_NAME),
                Check.whether(Validate.isAndroid())
                        .andIfSo(SelectFromDropDown.byVisibleText(BUSINESS_ACTIVITY, merchantInfo.getMerchantActivity())),
                Enter.theValue(merchantInfo.getPostalCode()).into(EMAIL),
                Check.whether(Validate.isIOS())
                        .andIfSo(
                                Check.whether(isKeyboardShown(as(theActorInTheSpotlight()).getDriver())))
                        .andIfSo(Hide.theKeyboard())
        );
    }

    public static Performable theAccountHolder(String accountHolder) {
        return Task.where("{0} edits the account holder field",
                Click.on(EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                Click.on(ACCOUNT_HOLDER),
                Enter.theValue(accountHolder).into(ACCOUNT_HOLDER)
        );
    }

    public static Performable theClabe(String clabe) {
        return Task.where("{0} edits the interbank CLABE field",
                Click.on(EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                Click.on(CLABE),
                Enter.theValue(clabe).into(CLABE)
        );
    }

    public static Performable theBankAccountInformationForm(String clabe, String accountHolder) {
        return Task.where("{0} edits his bank account information",
                Click.on(EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                Enter.theValue(accountHolder).into(ACCOUNT_HOLDER),
                Enter.theValue(clabe).into(CLABE).then(Hide.theKeyboard())
        );
    }
}
