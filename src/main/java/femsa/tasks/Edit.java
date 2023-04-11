package femsa.tasks;

import femsa.interactions.Hide;
import femsa.interactions.SelectFromDropDown;
import femsa.models.User;
import femsa.user_interfaces.DatosNegocioUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.ClabeInterbancariaUI.CLABE_INTERBANCARIA;
import static femsa.user_interfaces.ClabeInterbancariaUI.NOMBRE_TITULAR;
import static femsa.user_interfaces.DatosNegocioUI.ACTIVIDAD_DE_TU_NEGOCIO;
import static femsa.user_interfaces.DatosNegocioUI.NOMBRE_NEGOCIO;
import static femsa.user_interfaces.EditPersonalInformationUI.*;
import static java.time.Duration.ofSeconds;
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
        return Task.where("{0} edita sus datos bancarios en el formulario de datos bancarios",
                Enter.theValue(user.getFirstName()).into(FIRST_NAME),
                Enter.theValue(user.getLastName()).into(LAST_NAME),
                Enter.theValue(user.getEmail()).into(EMAIL)
        );
    }

    public static Performable datosDelNegocio(String nombreNegocio, String actividadNegocio, String codigoPostal) {
        return Task.where("{0} edita sus datos personales",
                Click.on(DatosNegocioUI.BOTON_EDITAR),
                Confirm.thePassword(theActorInTheSpotlight().recall("contrasenia")),
                Edit.formularioDeDatosDeNegocio(nombreNegocio, actividadNegocio, codigoPostal),
                Save.theEditedInformation()
        );
    }

    public static Performable formularioDeDatosDeNegocio(String nombreNegocio, String actividadNegocio, String codigoPostal) {
        return Task.where("{0} edita sus datos de su negocio en el formulario de datos de negocio",
                Enter.theValue(nombreNegocio).into(NOMBRE_NEGOCIO),
                SelectFromDropDown.byVisibleText(ACTIVIDAD_DE_TU_NEGOCIO, actividadNegocio),
                Enter.theValue(codigoPostal).into(EMAIL)
        );
    }

    public static  Performable email(String newEmail){
        return Task.where("{0} edits his email with '"+newEmail+"'",
                Click.on(EDIT),
                Confirm.thePassword(theActorInTheSpotlight().recall("password")),
                WaitUntil.the(EMAIL, isEnabled()).forNoMoreThan(ofSeconds(10)),
                Enter.theValue(newEmail).into(EMAIL).then(Click.on(EMAIL)),
                Click.on(LAST_NAME).then(Hide.theKeyboard())
        );
    }
}
