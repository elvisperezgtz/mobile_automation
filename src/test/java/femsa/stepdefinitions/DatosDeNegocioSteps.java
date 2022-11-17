package femsa.stepdefinitions;

import femsa.tasks.Editar;
import femsa.tasks.Navegar;
import femsa.user_interfaces.DatosNegocioUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static femsa.user_interfaces.DatosNegocioUI.*;

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

    @And("{actor} deberia ver los datos actualizados correctamente")
    public void elvisDeberiaVerLosDatosActualizadosCorrectamente(Actor actor, DataTable datosNegocio) {

        List<Map<String,String>> rows = datosNegocio.asMaps(String.class, String.class);
        actor.attemptsTo(
                Ensure.that(NOMBRE_NEGOCIO).text().isEqualTo(rows.get(0).get("Nombre")),
//                Ensure.that(ACTIVIDAD_DE_TU_NEGOCIO).text().isEqualTo(rows.get(0).get("Actividad")),
                Ensure.that(CODIGO_POSTAL).text().isEqualTo(rows.get(0).get("CodigoPostal"))
        );
    }


    @When("{actor} intenta editar los datos del negocio")
    public void elvisIntentaEditarLosDatosDelNegocio( Actor actor) {

                actor.attemptsTo(Click.on(EDITAR));
    }
}
