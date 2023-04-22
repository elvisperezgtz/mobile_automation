package femsa.stepdefinitions;

import femsa.api.Update;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

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
    @After("@hookPersonalData")
    public void setDefaultUser() {
        Update.userInfo(ELVIS.getName());
    }

    @Before("@hookBusinessData")
    @After("@hookBusinessData")
    public void setDefaultBusinessData() {
        Update.businessInfo(ELVIS);
    }

    @Before("@hookBankAccountInfo")
    @After("@hookBankAccountInfo")
    public void  setDefaultBankAccountInfo(){
        Update.bankAccountInfo(ELVIS);
    }

}
