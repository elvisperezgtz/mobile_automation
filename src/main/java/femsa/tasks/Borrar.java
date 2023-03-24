package femsa.tasks;

import femsa.interactions.Clear;
import femsa.interactions.SelectFromDropDown;
import femsa.user_interfaces.DatosNegocioUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static femsa.user_interfaces.DatosBancariosUI.CLABE;
import static femsa.user_interfaces.DatosBancariosUI.NOMBRE_TITULAR;
import static femsa.user_interfaces.EditPersonalInformationUI.LOGO;

public class Borrar {

    public static Performable campoEnDatosPersonales(Target target) {
        return Task.where("{0} borra el contenido del campo",
                Clear.textBox(target)
                        .then(Click.on(LOGO))
        );
    }

    public static Performable campoEnNegocio(Target target) {
        return Task.where("{0} borra el contenido del campo",
                Clear.textBox(target),
                SelectFromDropDown.byVisibleText(DatosNegocioUI.ACTIVIDAD_DE_TU_NEGOCIO,"ABARROTES Y MISCELANEAS")
        );
    }
    public static Performable elCampoNombreDelTitular(){
        return Task.where("{0} borra el contenido del campo Nombre del titular",
                Clear.textBox(NOMBRE_TITULAR)
                        .then(Click.on(CLABE))
        );
    }
    public static Performable elCampoCLABEInterbancaria(){
        return Task.where("{0} borra el contenido del campo CLABE Interbancaria",
                Clear.textBox(CLABE)
                        .then(Click.on(NOMBRE_TITULAR))
        );
    }

}
