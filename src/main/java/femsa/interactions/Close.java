package femsa.interactions;

import femsa.utils.GetProxiesDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static femsa.utils.Validate.isAndroid;

public class Close implements Interaction {

    private String appBundle;

    public Close(String appBundle) {
        this.appBundle = appBundle;
    }

    @Override
    @Step("{0} closes the app")
    public <T extends Actor> void performAs(T actor) {
        if (Boolean.TRUE.equals(isAndroid())) {
            GetProxiesDriver.forAndroid().terminateApp(appBundle);
        } else {
            GetProxiesDriver.forIos().terminateApp(appBundle);
        }
    }

    public static Close theApp(String appBundle) {
        return Tasks.instrumented(Close.class, appBundle);
    }
}
