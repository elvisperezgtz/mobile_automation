package femsa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DoYouWantToGoModalUI {
    private DoYouWantToGoModalUI() {
    }

    public static final Target TITLE = Target.the("title")
            .locatedForAndroid(By.xpath("//android.widget.TextView[contains(@text,'¿Quieres salir?')]"))
            .locatedForIOS(By.xpath(""));


    public static final Target CONTINUE_EDITING = Target.the("Continue editing button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SEGUIR EDITANDO']"))
            .locatedForIOS(By.xpath(""));

    public static final Target EXIT_WITHOUT_SAVING = Target.the("Exit without saving button")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text='SALIR SIN GUARDAR']"))
            .locatedForIOS(By.xpath(""));

}
