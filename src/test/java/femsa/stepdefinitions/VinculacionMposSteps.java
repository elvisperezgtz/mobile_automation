package femsa.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import femsa.models.Usuario;
import femsa.tasks.Vincular;

import static java.time.Duration.ofSeconds;
import static femsa.user_interfaces.VinculacionUI.BUSCANDO_DISPOSITIVOS;

public class VinculacionMposSteps {
    @Managed(driver = "appium")
    private AppiumDriver driver;

    public Usuario usuario = new Usuario();

    @When("{actor} realiza la vinculacion del dispositivo MPOS")
    public void elvisRealizaLaVinculacionDelDispositivoMPOS(Actor actor) {
        actor.attemptsTo(
                Vincular.dispositivoMpos()
        );
    }

    @Then("{actor} deberia poder que inicio la busqueda de dispositivos")
    public void elvisDeberiaPoderQueInicioLaBusquedaDeDispositivos(Actor actor) {
        actor.attemptsTo(Ensure.that(BUSCANDO_DISPOSITIVOS.waitingForNoMoreThan(ofSeconds(15))).isDisplayed());
    }

    @When("{actor} realiza la vinculacion del dispositivo Mpos aceptando activar el Bluetooth")
    public void elvisRealizaLaVinculacionDelDispositivoMposAceptandoActivarElBluetooth(Actor actor) {
        actor.attemptsTo(
                Vincular.dispositivoMposAceptandoElUsoDeLocalizacionYBluetooth()
        );
    }
}
