package femsa.tasks;

import femsa.user_interfaces.DatosBancariosUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static femsa.user_interfaces.ModalGuardarUI.GUARDAR;
import static femsa.user_interfaces.ModalGuardarUI.GUARDAR_CAMBIOS;

public class Guardar {
    public static Performable datos(){
        return Task.where("{0} guarda los datos editados",
                Click.on(GUARDAR),
                Click.on(GUARDAR_CAMBIOS)
                );
    }
    public static Performable datosBancarios(){
        return Task.where("{0} guarda los datos editados",
                Click.on(GUARDAR),
                Click.on(DatosBancariosUI.CONFIRMAR)
        );
    }
}
