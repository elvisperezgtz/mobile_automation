package femsa.interactions;

import femsa.utils.Commands;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Execute implements Interaction {
    private String commando;

    public Execute(String commando) {
        this.commando = commando;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Commands.execute(commando);
    }

    public static Execute theAdbCommand(String command) {
        return Tasks.instrumented(Execute.class, command);
    }
}
