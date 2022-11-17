package femsa.tasks;

import net.serenitybdd.screenplay.Tasks;

public class Registrar {
    public static ElNumeroTelefonico elNumeroTelefonico(String numeroTelefonico) {
        return Tasks.instrumented(ElNumeroTelefonico.class, numeroTelefonico);
    }


}
