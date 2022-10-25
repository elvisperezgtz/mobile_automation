package femsa.tasks;

import femsa.interactions.Hide;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static femsa.user_interfaces.LoginUI.CONTRASENIA;
import static femsa.user_interfaces.LoginUI.EMAIL_O_NUMERO;

public class Llenar {
    public static Performable elFormularioInicioDeSesion(String usuario, String contrasenia){
        return Task.where("{0} llena el formulario de inicio de sesion con sus credenciales",
                Enter.theValue(usuario).into(EMAIL_O_NUMERO),
                Enter.theValue(contrasenia).into(CONTRASENIA),
                Hide.theKeyboard()
                );

    }
}
