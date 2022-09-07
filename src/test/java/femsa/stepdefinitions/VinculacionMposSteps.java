package femsa.stepdefinitions;

import femsa.interactions.Ejecutar;
import femsa.tasks.Desactivar;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import femsa.models.Usuario;
import femsa.tasks.Conceder;
import org.junit.jupiter.api.AfterEach;

import static femsa.user_interfaces.VinculacionUI.DISPOSITIVOS_ENCONTRADOS;
import static java.time.Duration.ofSeconds;
import static femsa.user_interfaces.VinculacionUI.BUSCANDO_DISPOSITIVOS;

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
                Conceder.permisosConBlueToothActivado()
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
}
