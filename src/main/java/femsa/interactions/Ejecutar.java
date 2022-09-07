package femsa.interactions;

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
        try {
            Runtime.getRuntime().exec(new String[]{"bash", "-l", "-c",commando});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static Ejecutar elComandoAdb(String commando){
        return Tasks.instrumented(Ejecutar.class, commando);
}
}
