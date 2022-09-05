package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static femsa.user_interfaces.IntroDispositivoUI.*;
import static femsa.user_interfaces.VinculacionUI.MIENTRAS_LA_APP_ESTA_EN_USO;

public class Permitir {
    public static Performable activarBlueTooth() {
        return Task.where("{0} permite activar el Bluetooth",
                WaitUntil
                        .the(TITULO_SOLICITUD_ACTIVACION_BT, isVisible())
                        .forNoMoreThan(ofSeconds(10))
                        .then(Click.on(PERMITIR_ACTIVACION_BT))
        );
    }

    public static Performable usarUbicacion() {
        return Task.where(
                "{0} permite el uso de la ubicacion",
                WaitUntil
                        .the(TITULO_PERMITIR_UBICACION, isVisible())
                        .forNoMoreThan(ofSeconds(10))
                        .then(Click.on(MIENTRAS_LA_APP_ESTA_EN_USO)),

                Check.whether(MIENTRAS_LA_APP_ESTA_EN_USO.resolveFor(theActorInTheSpotlight()).isVisible())
                        .andIfSo(Click.on(MIENTRAS_LA_APP_ESTA_EN_USO))
                        .otherwise()



        );
    }

}
