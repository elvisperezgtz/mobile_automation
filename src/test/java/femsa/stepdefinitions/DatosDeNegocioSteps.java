package femsa.stepdefinitions;

import femsa.tasks.Editar;
import femsa.tasks.Navegar;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import java.util.List;
import java.util.Map;

public class DatosDeNegocioSteps {
    @When("{actor} ingresa a la opcion datos de negocio")
    public void elvisIngresaALaOpcionDatosDeNegocio(Actor actor) {
        actor.attemptsTo(
                Navegar.aLaPantallaDeDatosDeNegocio()
        );
    }

    @When("{actor} edita los datos de negocio")
    public void elvisEditaLosDatosDeNegocio(Actor actor, DataTable datosNegocio) {
        List<Map<String,String>>rows = datosNegocio.asMaps(String.class, String.class);
        actor.attemptsTo(
                Editar.datosDelNegocio(
                        rows.get(0).get("Nombre"),
                        rows.get(0).get("Actividad"),
                        rows.get(0).get("CodigoPostal")
                )

        );
    }

    @And("Elvis deberia ver los datos actualizados correctamente")
    public void elvisDeberiaVerLosDatosActualizadosCorrectamente() {
        /**
         * Validar mensaje
         * validar datos
         *  | Nombre      | Actividad  | CodigoPostal |
         *       | Bug Hunters | ASOCIACIÓN | 50004        |
         */
    }
}
