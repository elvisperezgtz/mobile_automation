package femsa.tasks;

import femsa.interactions.Clear;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static femsa.user_interfaces.EdicionDatosPersonalesUI.LOGO;

public class Borrar {

    public static Performable campoEnDatosPersonales(Target target){
        return Task.where("{0} borra el contenido del campo",
                Clear.textBox(target)
                        .then(Click.on(LOGO))
                );
    }
}
