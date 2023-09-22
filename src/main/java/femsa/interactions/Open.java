package femsa.interactions;

import femsa.utils.GetProxiesDriver;
import femsa.utils.Validate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class Open implements Interaction {
    private String appBundle;

    public Open(String appBundle) {
        this.appBundle = appBundle;
    }

    @Override
    @Step("{0} opens the app")
    public <T extends Actor> void performAs(T actor) {
        if (Validate.isAndroid()) {
            GetProxiesDriver.forAndroid().activateApp(appBundle);
        } else {
            GetProxiesDriver.forIos().activateApp(appBundle);
        }
    }

    public static Open theApp(String appBundle) {
        return Tasks.instrumented(Open.class, appBundle);
    }
}
