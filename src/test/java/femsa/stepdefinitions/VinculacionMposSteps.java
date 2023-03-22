package femsa.stepdefinitions;

import femsa.interactions.Ejecutar;
import femsa.models.Usuario;
import femsa.tasks.Complete;
import femsa.tasks.Conceder;
import femsa.tasks.Conectar;
import femsa.tasks.Desactivar;
import femsa.user_interfaces.VinculacionExitosaUI;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.AfterEach;

import java.time.Duration;

import static femsa.user_interfaces.VinculacionUI.BOTON_CONTINUAR;
import static femsa.user_interfaces.VinculacionUI.DISPOSITIVOS_ENCONTRADOS;
import static java.time.Duration.ofSeconds;

public class VinculacionMposSteps {
    @Managed(driver = "appium")
    private AppiumDriver driver;

    public Usuario usuario = new Usuario();

    @AfterEach
    public void uninstallApp(){
        Ejecutar.elComandoAdb("adb uninstall com.oxxo.Mpos.dev");
    }
    @When("{actor} realiza la vinculacion del dispositivo MPOS")
    public void elvisRealizaLaVinculacionDelDispositivoMPOS(Actor actor) {
        actor.attemptsTo(
                Conceder.permisosConBlueToothActivado(),
                Conectar.elDispositivoMpos()
        );
    }

    @Then("{actor} deberia poder que inicio la busqueda de dispositivos")
    public void elvisDeberiaPoderQueInicioLaBusquedaDeDispositivos(Actor actor) {
        actor.attemptsTo(Ensure.that(DISPOSITIVOS_ENCONTRADOS.waitingForNoMoreThan(ofSeconds(60))).isDisplayed());
    }

    @When("{actor} realiza la vinculacion del dispositivo Mpos aceptando activar el Bluetooth")
    public void elvisRealizaLaVinculacionDelDispositivoMposAceptandoActivarElBluetooth(Actor actor) {
        actor.attemptsTo(
                Conceder.permisosConBluetoothDesactivado()
        );
    }

    @When("{actor} desactiva el bluetooth de su telefono")
    public void elvisDesactivaElBluetoothDeSuTelefono(Actor actor) {
        actor.attemptsTo(
                Desactivar.blueTooth()
        );
    }

    @And("{actor} ingresa los datos de su cuenta Clabe")
    public void elvisIngresaLosDatosDeSuCuentaClabe(Actor actor) {
        usuario.defaulValues();
        actor.attemptsTo(
                Click.on(BOTON_CONTINUAR.waitingForNoMoreThan(Duration.ofSeconds(20))),
                Complete.elProcesoDeOnboarding(usuario)
        );
    }

    @Then("{actor} deberia ver el titulo {string}")
    public void elvisDeberiaVerElTitulo(Actor actor, String titulo) {
        actor.attemptsTo(
                Ensure.that(VinculacionExitosaUI.FELICIDADES).text().containsIgnoringCase(titulo)
        );
    }
}
