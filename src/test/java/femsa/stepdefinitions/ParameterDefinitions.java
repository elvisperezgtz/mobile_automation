package femsa.stepdefinitions;

import femsa.utils.database.FindUser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.sql.SQLException;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

//    @After
//    public void uninstallApp(){
//        System.out.println("Eliminando la app ...");
//                Commands.execute("adb uninstall com.oxxo.Mpos.dev");
//    }

    @Before("@hookDatosPersonales")
    public void setDefaultUser() throws SQLException {
        FindUser.andUpdate();
    }
    @After("@hookDatosPersonales")
    public void backupUser() throws SQLException {
        FindUser.andUpdate();
    }

}
