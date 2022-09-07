package femsa.stepdefinitions;

import femsa.interactions.Ejecutar;
import femsa.utils.Commands;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.Console;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void uninstallApp(){
        System.out.println("Eliminando la app ...");
                Commands.execute("adb uninstall com.oxxo.Mpos.dev");
    }


}
