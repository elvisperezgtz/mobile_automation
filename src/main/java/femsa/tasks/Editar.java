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
import static femsa.user_interfaces.EdicionDatosPersonalesUI.EDITAR;
import static femsa.user_interfaces.EdicionDatosPersonalesUI.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Editar {
    private Editar(){}
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
                Click.on(GUARDAR),
                Click.on(CONFIRMAR)
        );
    }
     public static Performable datosPersonales(String nombre, String apellidos, String email) {
        return Task.where("{0} edita sus datos personales",
                Click.on(EDITAR),
                Confirmar.contrasenia("Femsa123"),
                WaitUntil.the(NOMBRE, isEnabled()),
                Editar.formularioDeDatosPersonales(nombre,apellidos,email),
                Click.on(GUARDAR),
                Click.on(GUARDAR_CAMBIOS)
        );
    }
    public static Performable formularioDeDatosPersonales(String nombre, String apellidos, String email) {
        return Task.where("{0} edita sus datos bancarios en el formulario de datos bancarios",
                Enter.theValue(nombre).into(NOMBRE),
                Enter.theValue(apellidos).into(APELLIDOS),
                Enter.theValue(email).into(EMAIL)
        );
    }

    public static Performable datosDelNegocio(String nombreNegocio, String actividadNegocio, String codigoPostal) {
        return Task.where("{0} edita sus datos personales",
                Click.on(DatosNegocioUI.BOTON_EDITAR),
                Confirmar.contrasenia(theActorInTheSpotlight().recall("contrasenia")),
                Editar.formularioDeDatosDeNegocio(nombreNegocio, actividadNegocio, codigoPostal),
                Click.on(DatosNegocioUI.GUARDAR),
                Click.on(GUARDAR_CAMBIOS)

        );
    }
    public static Performable formularioDeDatosDeNegocio(String nombreNegocio, String actividadNegocio, String codigoPostal) {
        return Task.where("{0} edita sus datos de su negocio en el formulario de datos de negocio",
                Enter.theValue(nombreNegocio).into(NOMBRE_NEGOCIO),
                SelectFromDropDown.byVisibleText(ACTIVIDAD_DE_TU_NEGOCIO,actividadNegocio),
                Enter.theValue(codigoPostal).into(EMAIL)
        );
    }

}
