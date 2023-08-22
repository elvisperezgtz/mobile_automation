package femsa.stepdefinitions;

import femsa.api.Update;
import femsa.utils.Commands;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.logging.Logger;

public class ParameterDefinitions {
    EnvironmentVariables env;
    private static final Logger LOGGER = Logger.getLogger(ParameterDefinitions.class.getName());

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before(order = 1)
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before("@hookPersonalData")
    @After("@hookPersonalData")
    public void setDefaultUser() {
        Update.userInfo(EnvironmentSpecificConfiguration.from(env).getProperty("actor"));
    }

    @Before("@hookBusinessData")
    @After("@hookBusinessData")
    public void setDefaultBusinessData() {
        Update.businessInfo(EnvironmentSpecificConfiguration.from(env).getProperty("actor"));
    }

    @Before("@hookBankAccountInfo")
    @After("@hookBankAccountInfo")
    public void setDefaultBankAccountInfo() {
        Update.bankAccountInfo(EnvironmentSpecificConfiguration.from(env).getProperty("actor"));
    }

    @Before(value = "@hookEnableWifi", order = 2)
    @After("@hookEnableWifi")
    public void turnWifiOn() {
        LOGGER.info("Turning on Wifi...");
        String deviceName = EnvironmentSpecificConfiguration.from(env).getProperty("appium.deviceName");
        Commands.execute("adb -s " + deviceName + " shell svc wifi enable");
    }

}
