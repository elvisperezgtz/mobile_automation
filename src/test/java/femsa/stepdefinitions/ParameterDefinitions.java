package femsa.stepdefinitions;

import femsa.api.Update;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.sql.SQLException;

import static femsa.enums.CredentialsName.ELVIS;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before("@hookPersonalData")
    public void setDefaultUser() throws SQLException {
        Update.userInfo(ELVIS.getName());
    }
    @After("@hookPersonalData")
    public void backupUser() throws SQLException {
        Update.userInfo(ELVIS.getName());
    }

}
