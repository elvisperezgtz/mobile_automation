package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static femsa.user_interfaces.ClabeInterbancariaUI.CLABE_INTERBANCARIA;
import static femsa.user_interfaces.ClabeInterbancariaUI.NOMBRE_TITULAR;

public class Editar {
    public static Performable losDatosBancarios(String titular, String clabe){
        return Task.where("{0} edita sus datos bancarios",
                Enter.theValue(titular).into(NOMBRE_TITULAR),
                Enter.theValue(clabe).into(CLABE_INTERBANCARIA)
        );
    }
}
