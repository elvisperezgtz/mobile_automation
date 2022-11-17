package femsa.tasks;

import femsa.interactions.Digitar;
import femsa.interactions.Esperar;
import femsa.interactions.GetOtp;
import femsa.interactions.SelectFromDropDown;
import femsa.models.Usuario;
import femsa.user_interfaces.DatosBancariosUI;
import femsa.user_interfaces.DatosPersonalesUI;
import femsa.user_interfaces.PasswordUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static femsa.interactions.Ejecutar.elComandoAdb;
import static femsa.user_interfaces.AdministracionPerilUI.AYUDA;
import static femsa.user_interfaces.DatosBancariosUI.CLABE;
import static femsa.user_interfaces.DatosBancariosUI.NOMBRE_TITULAR;
import static femsa.user_interfaces.DatosPersonalesUI.*;
import static femsa.user_interfaces.PasswordUI.CONTRASENIA;
import static femsa.user_interfaces.RegistroUI.CASILLA_1;
import static femsa.user_interfaces.RegistroUI.REENVIAR_SMS;
import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Ingresar {

    private String codigoValidacion;

    public Ingresar(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public static Performable codigoDeValidacion(String codigoValidacion) throws IOException {
        return Task.where("{0} ingresa el codigo OTP que le llego a su linea movil",
                WaitUntil.the(CASILLA_1, isClickable()).forNoMoreThan(ofMinutes(3)).then(Click.on(CASILLA_1)),
                Digitar.conTecladoNativo(codigoValidacion)
        );
    }

    //todo verificar este metodo, cambiar nombre
    public static Performable unNuevoCodigoDeVerificacion() throws IOException {

        return Task.where("{0} ingresa un nuevo codigo de validacion",
                Esperar.queTermineLaCuentaRegresiva(),
                Click.on(REENVIAR_SMS)
        );
    }

    public static Performable unaContrasenia(String contrasenia) {
        return Task.where("{0} ingresa una contrasenia para su cuenta",
                WaitUntil.the(PasswordUI.TITULO, isPresent()).forNoMoreThan(ofSeconds(5))
                        .then(Enter.theValue(contrasenia).into(CONTRASENIA))
        );
    }

    public static Performable datosPersonales(Usuario usuario) {
        return Task.where("{0} llena el formulario de datos personales",
                WaitUntil.the(DatosPersonalesUI.TITULO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(NOMBRES).then(Enter.theValue(usuario.getNombre()).into(NOMBRES)),
                Click.on(PRIMER_APELLIDO).then(Enter.theValue(usuario.getApellido()).into(PRIMER_APELLIDO)),
                Click.on(EMAIL).then(Enter.theValue(usuario.getEmail()).into(EMAIL)),
                Click.on(NOMBRE_DE_TU_NEGOCIO).then(Enter.theValue(usuario.getNombreNegocio()).into(NOMBRE_DE_TU_NEGOCIO)).then(elComandoAdb("adb shell input keyevent 4")),
                SelectFromDropDown.byVisibleText(ACTIVIDAD_DE_TU_NEGOCIO, usuario.getActividadEconomica()),
                Click.on(CODIGO_POSTAL).then(Enter.theValue(usuario.getCodigoPostal()).into(CODIGO_POSTAL)).then(elComandoAdb("adb shell input keyevent 4")).then(Click.on(TITULO))
        );
    }

    public static Performable cuentaClabeTitular(Usuario usuario) {
        return Task.where("{0} Ingresa los datos de su cuenta CLABE",
                WaitUntil.the(DatosBancariosUI.TITULO, isVisible()).forNoMoreThan(ofSeconds(15)),
                Enter.theValue(usuario.getNombreTitular()).into(NOMBRE_TITULAR),
                Enter.theValue(usuario.getCuentaClabe()).into(CLABE)
        );
    }

    public static Performable codigoOtp() throws IOException {
        return Task.where("{0} ingresa el codigo recibido en su dispositivo celular",
                GetOtp.fromSMS(),
                Ingresar.codigoDeValidacion(OnStage.theActorInTheSpotlight().recall("otp"))
        );
    }
    public static Performable aLaPantallaAyuda(){
        return Task.where("{0} ingresa a la opcion Ayuda",
                WaitUntil.the(AYUDA, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(AYUDA));
    }
}
