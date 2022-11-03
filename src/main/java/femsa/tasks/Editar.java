package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.ClabeInterbancariaUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Editar {
    public static Performable formularioDeDatosBancarios(String clabe, String titular) {
        return Task.where("{0} edita sus datos bancarios en el formulario de datos bancarios",
                Enter.theValue(titular).into(NOMBRE_TITULAR),
                Enter.theValue(clabe).into(CLABE_INTERBANCARIA)
        );
    }

    public static Performable losDatosBancarios(String clabe, String titular) {
        return Task.where("{0} edita sus datos bancarios",

                WaitUntil.the(CLABE_INTERBANCARIA, isEnabled()),
                Editar.formularioDeDatosBancarios(clabe, titular),
                Click.on(GUARDAR),
                Click.on(CONFIRMAR)
        );
    }
}
