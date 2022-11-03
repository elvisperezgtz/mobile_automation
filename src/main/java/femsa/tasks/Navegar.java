package femsa.tasks;

import femsa.user_interfaces.AdministracionPerilUI;
import femsa.user_interfaces.HomeUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static femsa.user_interfaces.AdministracionPerilUI.CLABE;
import static femsa.user_interfaces.HomeUI.*;
import static femsa.user_interfaces.IntroDispositivoUI.CONECTAR_DISPOSITIVO;
import static femsa.user_interfaces.IntroDispositivoUI.YA_LO_TENGO;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Navegar {
    public static Performable aVincularDispositivoMpos(){
        return Task.where("{0} navega hasta la pantalla de vincular dispositivo",
                Click.on(YA_LO_TENGO),
                Click.on(CONECTAR_DISPOSITIVO)
                );
    }
    public static Performable aAdministracionDePerfil(){
        return Task.where("{0} navega hasta la pantalla de administracion de perfil",
                WaitUntil.the(PERFIL, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(PERFIL),
                Click.on(CLABE)
        );
    }
}
