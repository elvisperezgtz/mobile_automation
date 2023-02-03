package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.AdministracionPerilUI.CERRAR_SESION;
import static femsa.user_interfaces.ModalCerrarSesionUI.SI_CERRAR_SESION;


public class Cerrar {
    public static Performable sesion(){
        return Task.where("{0} cierra la sesion desde la app",
                Click.on(CERRAR_SESION),
                Click.on(SI_CERRAR_SESION));
    }

}
