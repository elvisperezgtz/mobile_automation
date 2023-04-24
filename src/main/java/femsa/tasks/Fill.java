package femsa.tasks;

import femsa.enums.CredentialsName;
import femsa.interactions.Digitar;
import femsa.models.Credential;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

import java.io.IOException;

import static femsa.user_interfaces.CobroUI.*;
import static femsa.user_interfaces.LoginUI.EMAIL_OR_PHONE_NUMBER;
import static femsa.user_interfaces.LoginUI.PASSWORD;
import static femsa.user_interfaces.RegisterInThreeStepsUI.ALREADY_HAVE_ACCOUNT;
import static femsa.utils.jsons.JsonTemplate.fromJsonToCredential;

public class Fill {

    private Fill() {
    }

    public static InTheLoginForm inTheLoginForm(){
        return Tasks.instrumented(InTheLoginForm.class);
    }

    public static Performable inTheLoginFormWithoutPassword() throws IOException {
        Credential credential = fromJsonToCredential("email", CredentialsName.EMPTY_PASSWORD.getName());
        return Task.where("{0} fill the form without a password",
                Click.on(ALREADY_HAVE_ACCOUNT),
                Enter.theValue(credential.getUsername()).into(EMAIL_OR_PHONE_NUMBER),
                Click.on(PASSWORD),
                Click.on(EMAIL_OR_PHONE_NUMBER)
        );
    }
    public static Performable inTheLoginFormWithoutEmailOrPhoneNumber() throws IOException {
        Credential credential = fromJsonToCredential("email", CredentialsName.EMPTY_PASSWORD.getName());
        return Task.where("{0} fill the form without an email or phone number",
                Click.on(ALREADY_HAVE_ACCOUNT),
                Enter.theValue(credential.getPassword()).into(PASSWORD),
                Click.on(EMAIL_OR_PHONE_NUMBER),
                Click.on(PASSWORD)
        );
    }
    public static Performable elFormularioDeCobros(String monto, String concepto) {
        return Task.where("{0} llena el formulario de cobro con el monto: " + monto + " y el concepto: " + concepto,
                Check.whether(
                        Validate.isIOS()
                ).andIfSo(Digitar.conTecladoNativo(monto),
                        Check.whether(concepto != "" || concepto != null)
                                .andIfSo(
                                        Click.on(ESCRIBE_EL_CONCEPTO),
                                        Enter.theValue(concepto).into(CONCEPTO_VENTA),
                                        Click.on(GUARDAR)
                                )
                )
        );
    }
}
