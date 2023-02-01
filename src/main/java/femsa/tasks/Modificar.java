package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static femsa.user_interfaces.DatosNegocioUI.BOTON_EDITAR;
import static femsa.user_interfaces.DatosNegocioUI.NOMBRE_NEGOCIO;

public class Modificar {
    public static Performable nombreDeNegocio(String nombreNegocio){
        return Task.where("{0} modifica el nombre del negocio",
                Click.on(BOTON_EDITAR),
                Confirmar.contrasenia("Femsa123"),
                Enter.theValue(nombreNegocio).into(NOMBRE_NEGOCIO),
                Guardar.datos()
                );
    }
}
