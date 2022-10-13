package femsa.tasks;

import femsa.user_interfaces.LoginUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.OnBoardingUI.YA_TENGO_CUENTA;

public class IniciarSesion {

    public static Performable conSusCredenciales(String usuario, String contrasenia){
        return Task.where("{Inicia sesion con sus credenciales }",
                Click.on(YA_TENGO_CUENTA),
                Llenar.elFormularioInicioDeSesion(usuario, contrasenia),
                Click.on(LoginUI.INICIAR_SESION)
        );
    }
}
