package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.ClabeInterbancariaUI.*;

public class Cancelar {
    public static Performable laActualizacionDeDatosBancarios(){
        return Task.where("{0} cancela la actualizacion de los datos bancarios",
                Click.on(CANCELAR_EDICION),
                Click.on(SALIR_SIN_GUARDAR));
    }

    public static Performable laActualizacionDeDatosBancariosYSeguirEditando(){
        return Task.where("{0} cancela la actualizacion de los datos bancarios",
                Click.on(CANCELAR_EDICION),
                Click.on(SEGUIR_EDITANDO));
    }
    public static Performable guardadoDeDatos(){
        return Task.where("{0} cancela el guardado de los datos bancarios en el modal: Tus datos son correctos?",
                Click.on(GUARDAR),
                Click.on(CANCELAR_DATOS_CORRECTOS));
    }
}
