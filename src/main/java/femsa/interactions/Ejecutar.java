package femsa.interactions;

import femsa.utils.Commands;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.io.IOException;

public class Ejecutar implements Interaction {
    private String commando;

    public Ejecutar(String commando) {
        this.commando = commando;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Commands.execute(commando);
    }
public static Ejecutar elComandoAdb(String commando){
        return Tasks.instrumented(Ejecutar.class, commando);
}
}
