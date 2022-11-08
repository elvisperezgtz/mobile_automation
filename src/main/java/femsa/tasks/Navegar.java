package femsa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static femsa.user_interfaces.AdministracionPerilUI.*;
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
    public static Performable aLaPantallaDeDatosBancarios(){
        return Task.where("{0} navega hasta la pantalla de administracion de perfil",
               Navegar.aLaPantallaAdministracionDePerfil(),
                Click.on(CLABE)
        );
    }
    public static Performable aLaPantallaDocumentosLegales(){
        return Task.where("{0} navega hasta la pantalla de Documentos legales",
                aLaPantallaAdministracionDePerfil(),
                Click.on(DOCUMENTOS_LEGALES)
        );
    }
 public static Performable aLaPantallaAdministracionDePerfil(){
        return Task.where("{0} navega hasta la pantalla de administracion de perfil",
                WaitUntil.the(PERFIL, isVisible()).forNoMoreThan(ofSeconds(15)),
                Click.on(PERFIL)
        );
    }
    public static Performable aLaPantallaDeDatosPersonales(){
        return Task.where("{0} navega hasta la pantalla de administracion de perfil",
                Navegar.aLaPantallaAdministracionDePerfil(),
                Click.on(EDITAR)
        );
    }

}
