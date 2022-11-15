package femsa.tasks;

import femsa.user_interfaces.HomeUI;
import femsa.user_interfaces.VinculacionUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.CobroUI.COBRAR;
import static femsa.user_interfaces.VinculacionUI.BOTON_CONTINUAR;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Cobrar {
    public static Performable viaChip(String monto, String concepto){
        return Task.where(
                Click.on(HomeUI.COBRAR),
                Habilitar.elBlueTooth(),
                Llenar.elFormularioDeCobros(monto, concepto),
                Click.on(COBRAR),
                Conectar.elDispositivoMpos(),
                WaitUntil.the(VinculacionUI.VINCULACION_EXITOSA, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(BOTON_CONTINUAR)
        );
    }
}
