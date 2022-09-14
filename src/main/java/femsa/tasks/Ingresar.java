package femsa.tasks;

import femsa.interactions.Digitar;
import femsa.interactions.Esperar;
import femsa.interactions.SelectFromDropDown;
import femsa.models.Usuario;
import femsa.user_interfaces.DatosBancariosUI;
import femsa.user_interfaces.DatosPersonalesUI;
import femsa.user_interfaces.PasswordUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static femsa.user_interfaces.DatosBancariosUI.CLABE;
import static femsa.user_interfaces.DatosBancariosUI.NOMBRE_TITULAR;
import static femsa.user_interfaces.DatosPersonalesUI.*;
import static femsa.user_interfaces.PasswordUI.CONTRASENIA;
import static femsa.user_interfaces.RegistroUI.CASILLA_1;
import static femsa.user_interfaces.RegistroUI.REENVIAR_SMS;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Ingresar {

    private String codigoValidacion;

    public Ingresar(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public static Performable codigoDeValidacion(String codigoValidacion) throws IOException {

        System.out.println("esta es la otp: " + codigoValidacion);
        return Task.where("{0} ingresa el codigo OTP que le llego a su linea movil",
                Click.on(CASILLA_1),
                Digitar.conTecladoNativo(codigoValidacion)
        );
    }

    public static Performable unNuevoCodigoDeVerificacion() throws IOException {

        return Task.where("{0} ingresa un nuevo codigo de validacion",
                Esperar.queTermineLaCuentaRegresiva(),
                Click.on(REENVIAR_SMS)
        );
    }

    public static Performable unaContrasenia(String contrasenia) {
        return Task.where("{0} ingresa una contraseña para su cuenta",
                WaitUntil.the(PasswordUI.TITULO, isPresent()).forNoMoreThan(ofSeconds(5))
                        .then(Enter.theValue(contrasenia).into(CONTRASENIA))
        );
    }

    public static Performable datosPersonales(Usuario usuario) {
        return Task.where("{0} llena el formulario de datos personales",
                WaitUntil.the(DatosPersonalesUI.TITULO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Enter.theValue(usuario.getNombre()).into(NOMBRES),
                Enter.theValue(usuario.getApellido()).into(PRIMER_APELLIDO),
                Enter.theValue(usuario.getEmail()).into(EMAIL),
                Enter.theValue(usuario.getNombreNegocio()).into(NOMBRE_DE_TU_NEGOCIO),
                SelectFromDropDown.byVisibleText(ACTIVIDAD_DE_TU_NEGOCIO, usuario.getActividadEconomica()),
                Enter.theValue(usuario.getCodigoPostal()).into(CODIGO_POSTAL)
        );
    }

    public static Performable cuentaClabeTitular(Usuario usuario) {
        return Task.where("{0} Ingresa los datos de su cuenta CLABE",
                WaitUntil.the(DatosBancariosUI.TITULO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Enter.theValue(usuario.getNombreTitular()).into(NOMBRE_TITULAR),
                Enter.theValue(usuario.getCuentaClabe()).into(CLABE)
        );
    }
}
