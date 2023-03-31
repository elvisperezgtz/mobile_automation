package femsa.tasks;

import femsa.interactions.SelectFromDropDown;
import femsa.user_interfaces.DatosNegocioUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.ClabeInterbancariaUI.*;
import static femsa.user_interfaces.DatosNegocioUI.ACTIVIDAD_DE_TU_NEGOCIO;
import static femsa.user_interfaces.DatosNegocioUI.NOMBRE_NEGOCIO;
import static femsa.user_interfaces.EditPersonalInformationUI.EDIT;
import static femsa.user_interfaces.EditPersonalInformationUI.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Editar {
    private Editar() {
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
                Editar.formularioDeDatosBancarios(clabe, titular),
                Guardar.datos()
        );
    }

    public static Performable datosPersonales(String nombre, String apellidos, String email) {
        return Task.where("{0} edita sus datos personales",
                Click.on(EDIT),
                Confirm.thePassword("Femsa123"),
                WaitUntil.the(FIRST_NAME, isEnabled()),
                Editar.formularioDeDatosPersonales(nombre, apellidos, email),
                Guardar.datos()
        );
    }

    public static Performable formularioDeDatosPersonales(String nombre, String apellidos, String email) {
        return Task.where("{0} edita sus datos bancarios en el formulario de datos bancarios",
                Enter.theValue(nombre).into(FIRST_NAME),
                Enter.theValue(apellidos).into(LAST_NAME),
                Enter.theValue(email).into(EMAIL)
        );
    }

    public static Performable datosDelNegocio(String nombreNegocio, String actividadNegocio, String codigoPostal) {
        return Task.where("{0} edita sus datos personales",
                Click.on(DatosNegocioUI.BOTON_EDITAR),
                Confirm.thePassword(theActorInTheSpotlight().recall("contrasenia")),
                Editar.formularioDeDatosDeNegocio(nombreNegocio, actividadNegocio, codigoPostal),
                Guardar.datos()

        );
    }

    public static Performable formularioDeDatosDeNegocio(String nombreNegocio, String actividadNegocio, String codigoPostal) {
        return Task.where("{0} edita sus datos de su negocio en el formulario de datos de negocio",
                Enter.theValue(nombreNegocio).into(NOMBRE_NEGOCIO),
                SelectFromDropDown.byVisibleText(ACTIVIDAD_DE_TU_NEGOCIO, actividadNegocio),
                Enter.theValue(codigoPostal).into(EMAIL)
        );
    }

}
